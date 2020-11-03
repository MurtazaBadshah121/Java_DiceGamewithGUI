import java.util.*;
/**
 * Write a description of class ChuckTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChuckTest
{
    public static void main (String [] args) {
    Scanner scnr = new Scanner(System.in);
    
      int before = 0;
      final int ONES = 1;
      final int TWOS = 2;
      final int THREES= 3;
      final int FOURS = 4;
      final int FIVES = 5;
      final int SIXES = 6;  
      final int FIELD = 7;
      final int SMALL = 8;
      final int LARGE = 9;
    
    int errors = 0;
    
    /**************** phase 1 testing *******************/
    
    // testing the default constructor
    Chuck roll = new Chuck();
    
    System.out.println("*********** phase 1 testing ****************");
    System.out.println("============================================");
    if(roll.getMessage() == ""){
        System.out.println("The message variable is empty");
        errors++;
    }else{
        System.out.println("getMessage() has passed:) current message: " + roll.getMessage());
    }
    
    if(roll.getCredits() != 10){
        System.out.println("The message variable is empty");
        errors++;
    }else{
        System.out.println("Get credits has " + roll.getCredits() + " credits");
    }
    
    GVdie[] temp = roll.getDice();
    
    if(temp.length != 3){
        System.out.println("The message variable is empty");
        errors++;
    }else{
        System.out.println("There are " + temp.length + " elements in GVdie[]");
    }
    System.out.println("============================================");
    System.out.println("********* END of phase 1 testing ***********");
    System.out.println();
    /*******************END OF PHASE 1 TESTING****************************/
    
    /******************PHASE 2 TESTING BEGINS*****************************/
    
    // test all methods:
    
    Chuck game = new Chuck();
    
    System.out.println("============================================");
    System.out.println();
    System.out.println("************Method Testing begins***********");
    System.out.println();
    assert game.getCredits() == 10 : "credits should start at 10";
    
    // wins bet on Large
    before = game.getCredits();
    game.placeBet(LARGE);
    game.testRoll(new int [] {6,3,3});
    assert game.getCredits() == before + 1 : "Should have won betting on Large";
    System.out.println("Winning in Large passed!");
    
    // loses bet on Large
    before = game.getCredits();
    game.placeBet(LARGE);
    game.testRoll(new int [] {2,3,3});
    assert game.getCredits() == before - 1 : "Should have lost betting on Large";
    System.out.println("Losing on large passed!");
    
    // winning bet on Small
    before = game.getCredits();
    game.placeBet(SMALL);
    game.testRoll(new int [] {1,2,1});
    assert game.getCredits() == before + 1 : "Should have won betting on Small";
    System.out.println("Winning on Small passed!");
    
    // losing bet on Small
    before = game.getCredits();
    game.placeBet(SMALL);
    game.testRoll(new int [] {6,5,6});
    assert game.getCredits() == before - 1 : "Should have lost betting on Small";
    System.out.println("Losing on Small passed!");
    
    
    // winning bet on Field > 12
    before = game.getCredits();
    game.placeBet(FIELD);
    game.testRoll(new int [] {6,5,6});
    assert game.getCredits() == before + 1 : "Should have won betting on Field";
    System.out.println("Winning on field greater 8 passed!");
    
    // winning bet on Field < 8
    before = game.getCredits();
    game.placeBet(FIELD);
    game.testRoll(new int [] {1,1,1});
    assert game.getCredits() == before + 1 : "Should have won betting on Field";
    System.out.println("Winning on field less than 8 passed!");
   
    // Losing bet on Field
    before = game.getCredits();
    game.placeBet(FIELD);
    game.testRoll(new int [] {3,3,4});
    assert game.getCredits() == before - 1 : "Should have lost betting on Field";
    System.out.println("Losing on field passed!");
    
    // Winning on CheckNumber
    before = game.getCredits();
    game.placeBet(TWOS);
    game.testRoll(new int [] {2,2,2});
    assert game.getCredits() == before + 10 : "Should have won betting on 2's";
    System.out.println("Credits won: " + game.getCredits());
    
    // Winning on CheckNumber
    before = game.getCredits();
    game.placeBet(TWOS);
    game.testRoll(new int [] {2,2,1});
    assert game.getCredits() == before + 2 : "Should have won betting on 2's";
    System.out.println("Credits won: " + game.getCredits());
    
    // Winning on CheckNumber
    before = game.getCredits();
    game.placeBet(TWOS);
    game.testRoll(new int [] {2,2,2});
    assert game.getCredits() == before + 10 : "Should have won betting on 2's";
    System.out.println("Credits won: " + game.getCredits());
    
    //Losing on CheckNumber
    before = game.getCredits();
    game.placeBet(TWOS);
    game.testRoll(new int [] {3,3,4});
    assert game.getCredits() == before - 1 : "Should have lost betting on checknumber";
    System.out.println("Losing on checkNumber passed!");
    
    
    System.out.println();
    System.out.println("************Method Testing Ends***********");
    
    System.out.println("==========================================");
    System.out.println("Testing completed.");
  }
}
