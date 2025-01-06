import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        while(true){
            int response = game();
            if(response==0){
                System.out.println("Thank you for playing!");
                break;
            }
        }
    }
    public static int game(){
        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        final int target = random.nextInt(100)+1;

        System.out.println("Welcome to game!");
        System.out.println("You will get 3 attempts to guess the number between 1-100, the scores will be displayed at the end.");

        System.out.println("Lets start the game!");

        int chances = 3;

        while(chances-->0) {
            System.out.println("Please enter a number between 1 to 100: ");
            int input = sc.nextInt();

            if (input == target) {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            }
            else if(chances<=0){
                System.out.println("Wrong guess, No chances left.");
                break;
            }
            else{
                System.out.println("Wrong guess, Chances left: " + chances);
                if(input>target){
                    System.out.println("Try a smaller number!");
                }
                else{
                    System.out.println("Try a greater number!");
                }

            }
        }

        System.out.println("The correct number is: " + target);
        int score = chances/3*100;
        System.out.println("Your score is: " + score + "%");

        System.out.println("Do you want to play the game again? Enter 1 if Yes or 0 if No: ");
        int response = sc.nextInt();
        return  response;
    }

}
