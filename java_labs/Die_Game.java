package java_labs;
import java.util.Random;
import java.util.Scanner;

public class  Die_Game {

    enum GameOutcome {
        WIN,
        LOSE, 
        CONTINUE
    }

 public static int rollDice() {
        Random rand = new Random();
        int die1 = rand.nextInt(6) ;  
        int die2 = rand.nextInt(6) ; 
        return die1 + die2;  
    }
    public static GameOutcome checkOutcome(int sum, int point) {
    
        switch (sum) {
            case 7:
            case 11:
            	return GameOutcome.WIN;
            case 2:
            case 3:
            case 12:
            	return GameOutcome.LOSE;
            default:
                if (point != 0 && sum == point) 
                	return GameOutcome.WIN;
                else if (sum == 7) 
                	return GameOutcome.LOSE;
                 else 
                	 return GameOutcome.CONTINUE;
        }
                
        }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to this game!");

        
        int sum = rollDice();
        System.out.println("You rolled: " + sum);

        // Check the outcome of the first roll
        GameOutcome outcome = checkOutcome(sum, 0);
        
        // If the first roll is 7 or 11, you win immediately
        if (outcome == GameOutcome.WIN) {
            System.out.println("You win!");
            return;
        }
        
        // If the first roll is 2, 3, or 12, you lose immediately
        if (outcome == GameOutcome.LOSE) {
            System.out.println("You lose!");
            return;
        }

        // If we get here, the sum becomes the "point"
        int point = sum;
        System.out.println("Your point is: " + point);
        
        // Continue rolling until the point or a 7 is rolled
        while (true) {
            System.out.println("Rolling again...");
            sum = rollDice();
            System.out.println("You rolled: " + sum);
            outcome = checkOutcome(sum, point);

            if (outcome == GameOutcome.WIN) {
                System.out.println("You made your point! You win!");
                break;
            }
        }
    }
    };

