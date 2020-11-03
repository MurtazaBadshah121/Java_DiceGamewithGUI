

/**
 * This is the Chuck class where we define the instanse variables and perform
 * the backend tasks of the Chuck a luck game GUI.
 *
 * @author (Murtaza Badshah)
 * @version (10/28/2020)
 */
public class Chuck
{
    /************************** PHASE 1 ************************************/
    // instance variables declaration
    // declared the int data type for balance.
    private int balance;
    // declared the GVdie class to the array called obj.
    private GVdie[] obj;
    // declared the String data type for message.
    private String message;
    // declared the boolean array for the bets.
    private boolean[] bets;

    /**
     * Constructor for objects of class Chuck
     */
    public Chuck()
    {
        // initialise instance variables

        /* Initialized the array obj with the class GVdie on each of the
         * elements of the array*/
        obj = new GVdie[3];
        //Created a for loop to instantiate each object with with GVdie class
        for(int i = 0; i < obj.length; i++)
        {
            // assigning each element in array to GVdie() class.
            obj[i] = new GVdie();
        }

        // Created another for loop to iterate from 0 to 2.
        for(int i = 0; i < obj.length; i++)
        {
            // setting each of the elements in array to be blank
            obj[i].setBlank();
        }

        // initialized the bets boolean array.
        bets = new boolean[9];

        // initialzied the balance variable and set the value to default to 10
        balance = 10;
    }

    /**
     * This method returns the message.
     *
     * 
     * @return    returns the message text.
     */
    public String getMessage()
    {
        return message; // returns the message string.
    }

    /**
     * This method returns the balance amount.
     *
     * @return    return the current balance amount.
     */
    public int getCredits()
    {
        return balance; // returns the balance value.
    }

    /**
     * This method returns the array of the GVdie
     *
     * @return    Return the array of the GVdie objects
     */
    public GVdie [] getDice()
    {
        return obj; // returns the array of the GVdie objects.
    }
    /************************** END OF PHASE 1 ****************************/

    /****************** PHASE 2 Private Helper Methods *******************/

    /**
     * This private method takes the values from the GVdie object and returns
     * the sum value.
     *
     * 
     * @return    The sum of the of the dice values
     */
    private int getSumDiceValues()
    {
        // initialzied the int sum to add the values too.
        int sum = 0;
        // created a for loop to iterate through the array.
        for(int i = 0; i < obj.length; i++)
        {
            /* adding the object value by calling the getValue() method from
             * the GVdie class and adding it to the sum integer.*/
            sum += obj[i].getValue();
        }
        // return the sum value after running the loop.
        return sum;
    }

    /**
     * This private method takes Integer num and checks if any two of the 
     * dice match the num value.
     *
     * @param  num  Int value retrived from the GVdie class.
     * @return    True or False if two die match each other. 
     */
    private boolean isDoubles(int num)
    {
        // initialized the int value counter.
        int value = 0;
        //created a for loop to iterate through each element of the array
        for (int i = 0; i < obj.length; i++)
        {
            // created an if that checks if each value matches the num
            if(obj[i].getValue() == num)
            {
                // if the condition is true then we add one to value.
                value++;
            }
        }
        /* this if checks if the int value is 2 or more meaning if 2 or more
        die match each other then we will return true else false. */
        if(value == 2 || value > 2)
        {
            return true; // return true value.
        }
        else 
        {
            return false; // return false value.
        }
    }

    /**
     * This private method checks if each of the element values match each
     * other and returns true else false.
     *
     *
     * @return    True or False if all cases match
     */
    private boolean isTriplets()
    {
        // if statement checks if index 0 matches index 1 and index 2
        if(obj[0].getValue() == obj[1].getValue() &&
        obj[1].getValue() == obj[2].getValue() &&
        obj[0].getValue() == obj[2].getValue()) 
        {
            return true; // returns the true value.
        }
        else 
        {
            return false; // returns the false value. 
        }

    }

    /**
     * This private method utilizes the getSumDiceValue and isTriplets
     * methods to check if the sum value is greater than 10 and isTriplets is
     * false. Then we will add two credits and update the message string that
     * the user has won.
     */
    private void checkLarge()
    {
        // if the sum is greater than 10 and none of the die match each other.
        if(getSumDiceValues() > 10 && isTriplets() == false)
        {
            // add 2 to the credits.
            balance += 2;
            // update the message to tell the user they won points
            message = "Congratualtions! You Won 2 credit on large! :)";
        }
    }

    /**
     * This private method utilizes the getSumDiceValue and isTriplets
     * methods to check if the sum value is less than 11 and isTriplets is
     * false. Then we will add two credits and update the message string that
     * the user has won.
     */
    private void checkSmall()
    {
        // if the sum is less than 11 and none of the die match each other.
        if(getSumDiceValues() < 11 && isTriplets() == false)
        {
            // add 2 to the credits.
            balance += 2;
            // update the message to tell the user they won points
            message = "Congratualtions! You Won 2 credits on small! :)";
        }
    }

    /**
     * This private method utilizes the getSumDiceValue and checks if its
     * less than 8 or greater than 12. If true 
     */
    private void checkField()
    {
        // if the sum is less than 8 and greater than 12.
        if(getSumDiceValues() < 8 ||  getSumDiceValues() > 12 )
        {
            // add 2 to the credits.
            balance += 2;
            // update the message to tell the user they won points
            message = "Congratualtions! You Won 2 credits for field! :)";
        }
    }

    /**
     * This private method takes Integer num and checks if any two of the 
     * dice match the num value or three of the die match num or only 1 die
     * matches num and then add credits to the balance accodingly and display
     * a congratulations message.
     *
     * @param  num  Int value retrived from the GVdie class.
     * @return    n/a. 
     */
    private void checkNumber(int num)
    {
        // check if all die match and they match to num
        if(isTriplets() == true && obj[0].getValue() == num) 
        {
            // add 11 to the credits.
            balance += 11;
            // update the message to tell the user they won points
            message = "Congratualtions! You Won 11 credits for" + 
            " matching values! :)";
        }

        // check if any two of the die match num.
        else if(isDoubles(num) == true)
        {
            // add 3 to the credits.
            balance += 3;
            // update the message to tell the user they won points
            message = "Congratualtions! You Won 3 credits for doubles :)";
        }

        // check if any of the die objects match num and adds 2 credits.
        else if(obj[0].getValue() == num ||
           obj[1].getValue() == num ||
           obj[2].getValue() == num)
        {
            // add 2 to the credits.
            balance += 2;
            // update the message to tell the user they won points
            message = "Congratualtions! You Won 2 credits for " +
            "matching values :)";
        }
    }   

    /**
     * This private method checks the bets entered.
     *
     * 
     * @return    n/a. 
     */
    private void checkAllBets()
    {
        //set the default message to say you lost.
        message = "Awww too bad you lost! Please try again :(";
        // used a for to loop the bets array.
        for(int i = 0; i < bets.length; i++)
        {
            // checking if any value in boolean array is true.
            if(bets[i] == true)
            {
                // if true then deduct 1 from credits.
                balance -= 1;
                
                // Checking if the array bets from 0 to 6 is true
                if(i >= 0 && i < 6)
                {
                    // if true then invoke checkNumber method
                    checkNumber(i + 1); //adding 1 to match index.
                }
                // Else if check bet array index 6 is true
                else if(bets[6] == true)
                {
                    // invoke the checkfield method.
                    checkField();
                }
                // else if check bet array index 7 is true.
                else if(bets[7] == true)
                {
                    //invoke the checksmall method.
                    checkSmall();
                }
                // else if check bet array index 8 to be true.
                else if(bets[8] == true)
                {
                    //invoke the checkLarge method.
                    checkLarge();
                }

            }
        }
    }
    /************************** END OF PHASE 2 ****************************/

    /******************** PHASE 3 MUTATOR METHODS *************************/
    
    /**
     * This public method does not return anything but it adds 
     * credits to the balance variable.
     *
     * @param  amount   integer amount value needed.
     * @return    n/a. 
     */
    public void addCredits(int amount)
    {
        // if the amount entered in greater than 0 then...
        if(amount > 0)
        {
            // add the amount value to the balance variable.
            balance += amount;
        }
    }

    /**
     * This public method takes the integer variable bet and
     * checks if the bet is between 0 and 9 and then sets the specific
     * index to true.
     *
     * @param  bet  integer value bet..
     * @return    n/a. 
     */
    public void placeBet(int bet)
    {
        // check if bet is greater than 0 and less or equal to 9.
        if(bet > 0 && bet <= 9)
        {
            // get the bets array and set the specific index to true.
            bets[bet - 1] = true;
        }   
    }
    
    /**
     * This public method takes integer bet and cancels any previous
     * bets placed.
     *
     * @param  bet  integer variable bet.
     * @return    n/a. 
     */
    public void cancelBet(int bet)
    {
        // check if the bet integer is between 1 and 9
        if(bet > 0 && bet <= 9)
        {
            // get the bets array and set the specific index to false.
            bets[bet - 1] = false;
        }
    }

    /**
     * This public method takes Integer num and checks if any two of the 
     * dice match the num value or three of the die match num or only 1 die
     * matches num and then add credits to the balance accodingly and display
     * a congratulations message.
     *
     * @param  num  Int value retrived from the GVdie class.
     * @return    n/a. 
     */
    public void clearAllBets()
    {
        for(int i = 0; i < bets.length; i++)
        {
            bets[i] = false;
        }
    }
    
    /**
     * This public method rolls the die array objects and then invokes
     * the checkallbets methods if its true then rolls the die if not.
     * then it outputs the message and sets the roll to blank.
     *
     * 
     * @return    n/a. 
     */
    public void roll()
    {
        // if enoughcredits is true then..
        if(enoughCredits() == true)
        {
            // run the for loop from 0 to 2.
            for(int i = 0; i < obj.length; i++)
            {
                // invoke the roll method for each obj index
                obj[i].roll();
            }
            //invoke the checkallbets method.
            checkAllBets();
            // invoke the clearallbets method.
            clearAllBets();
        } 
        // is the above condition is not true.
        else 
        {
            //set the default message
            message = "Sorry not enough credits to bet!";
            
            // run a for loop to set each GVdie object in the array to blank
            for(int i = 0; i < obj.length; i++)
            {
                //set each element in the GVdie array to invoek setblank
                obj[i].setBlank();
            }
        }
    }
    
    /**
     * This public resets the GVdie elements to blank and sets the
     * defaults to all variables.
     */
    public void reset()
    {
        // set a for loop that runs the GVdie method
        for(int i = 0; i < obj.length; i++)
        {
            // sets each element to blank.
            obj[i].setBlank();
        }
        
        // set the default message.
        message = "Awww too bad you lost! Please try again :(";
        // set the balance to 10
        balance = 10;
        // invoke the clear all bets method.
        clearAllBets();
    }

    /*********************** PREVENTING PLAYER ERRORS **********************/
    /**
     * This public method checks if the user has enough credits.
     *
     * 
     * @return    true or false. 
     */
    public boolean enoughCredits()
    {
        // initialized a int counter variable.
        int counter = 0;
        // created a for loop to run the length of the bets array
        for(int i = 0; i < bets.length; i++)
        {
            // if a bet is true then...
            if(bets[i] == true)
            {
                // increment the counter variable.
                counter++;
            }
        }
        
        // check if the counter is less than the balance.
        if(counter <= balance)
        {
            // if true then return true.
            return true;
        }
        else
        {
            // else return false.
            return false;
        }
    }

    /*********************** SOFTWARE TESTING ******************************/
    /**
     * This public method tests the software and prints out the dice
     * values.
     *
     * 
     * @return    n/a. 
     */
    public String diceToString()
    {
        // initialzied the string variable.
        String output = "";
        // created a for loop to run from 0 to 2.
        for(int i = 0; i < 2; i++)
        {
            /* add the string results if index 1 and 2 to output with
            the comma. */
            output += "," + obj[i + 1].getValue();
        }
        // return the string and the first index value plus the output.
        return "String: ["+ obj[0].getValue() + output + "]";
    }
    
    /**
     * This public method tests the roll based on the values entered
     * in an array.
     *
     * @param  array  of values.
     * @return    n/a. 
     */
    public void testRoll(int [] values)
    {
        // do //Initialized the do while loop.
        // {
        // // created a for loop that iterates from 0 to 2. (0, 1, 2)
        // for(int i = 0; i < obj.length; i++)
        // {
        // /* created an if to check if the Value array is greater than
        // * 0 and less than 7 ie between 1 and 6.*/
        // if(values[i] > 0 && values[i] < 7)
        // {
        // /* if its true then we create a while loop that checks
        // * the obj index 1 value is not equal to values array
        // * index 1. if that is true then we roll() die*/
        // while(obj[i].getValue() != values[i])
        // {
        // obj[i].roll();
        // }
        // } 
        // else if (values[i] > 6)
        // {
        // // if the condition doesnt pass then we will assign the value to be set as 1
        // values[i] = 1;
        // }
        // }
        // }
        // while(enoughCredits() != false);
        // created an if to check if enoughcredits method is true.
        if(enoughCredits() == true){
            // then run a for loop the length the GVdie objects
            for(int i = 0; i < obj.length; i++){
                // check if the values in the array are not from 1 to 6.
                if(values[i] < 0 || values[i] > 6){
                    // if its true then set the specific index value to 1
                    values[i] = 1;
                }
                /* inside the for created a while to check if the 
                 * value of the GVdie object does not match
                 * the values of the Array*/
                while(obj[i].getValue() != values[i]){
                    // keeps rolling until the condition is met.
                    obj[i].roll();
                }
            }
        }
        // invokes the checkallbets method
        checkAllBets();
        // invokes the clear all bets method to remove all bets.
        clearAllBets();
    }
}
