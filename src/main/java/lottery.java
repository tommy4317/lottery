import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lottery {

    public static void main(String[] args) {


            System.out.println("Hello World");

           AsciiChars.printNumbers();
           AsciiChars.printUpperCaseLetters();
          AsciiChars.printLowerCaseLetters();

            Scanner scan = new Scanner(System.in);

            System.out.println("Please enter your name");
            String name = scan.next();
            name += scan.nextLine();

            System.out.println("Hello " + name + ", would you like to continue, Yes or No?");
            String answer = scan.next();

            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Great! Let's get started...");
            }

            if (answer.equalsIgnoreCase("no")) {
                System.out.println("That's fine, but please return later to finish up.");

                System.exit(0);
            }

            //pause before beginning the questions
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {
            }

            String anotherAnswer;

            //do-while loop to repeat the questions
            do {
                System.out.println("Do you have a red car?  (yes, no)");
                String car = scan.next();

                if (car.equalsIgnoreCase("yes")) {
                    System.out.println("Cool! \nRed cars rock! " + "Let's continue...");
                }

                if (car.equalsIgnoreCase("No")) {
                    System.out.println("Good, red cars attract more cops! " + "Let's continue...");
                }

                System.out.println("What is the name of your favorite pet");
                String pet = scan.next();

                System.out.println("What is their age?");
                int age = scan.nextInt();

                System.out.println("What is your lucky number");
                int number = scan.nextInt();

                System.out.println("Do you have a favorite Quaterback, \nyes or no?");
                String quaterback = scan.next();

                if (quaterback.equalsIgnoreCase("yes")) {
                    System.out.println("Great! What's their name?");
                    String qbname = scan.next();
                    quaterback += scan.nextLine();

                }

                if (quaterback.equalsIgnoreCase("No")) {
                    System.out.println("That's fine. \nLet's continue...");
                }

                System.out.println("What's your Quaterback's jersey number? \nOr just enter a random number between 1 and 25.");
                int jersey = scan.nextInt();

                System.out.println("What is the two-digit model number of your car?");
                double model_number = scan.nextInt();

                System.out.println("What is the first name of your favorite actor or actress?");
                String thespian_name = scan.next();
                thespian_name += scan.nextLine();

                System.out.println("Pick a number between 1 and 50?");
                int random_number = scan.nextInt();

                //lottery
                Random rand = new Random(jersey + random_number + age);
                int min = 1, max = 49, slots = 6;

                //all elements are initialized to be zero
                int[] lotteryArray = new int[slots];
                boolean isRepeated;
                int randomNumber = 0;

                for (int indexDrawn = 0; indexDrawn < slots; indexDrawn++) {
                    do {
                        isRepeated = false;
                        //1 to 49
                        randomNumber = rand.nextInt(max + 1 - min) + min;
                        //check for repeated number against the filled non-zero elements
                        for (int k = 0; k <= indexDrawn; k++) {
                            //check against each filled non-zero elements, hope that none repeates the random number
                            if (lotteryArray[k] == randomNumber) {
                                isRepeated = true;
                                break;
                            }

                        }
                    } while (isRepeated);
                    lotteryArray[indexDrawn] = randomNumber;

                }

                Arrays.sort(lotteryArray);
                System.out.println("Here are your lucky lottery numbers:");
                for (int i = 0; i < slots; i++) {
                    System.out.print(lotteryArray[i] + " ");
                }

                System.out.println("Thank-you " + name+ " for playing. \n Would you like to start the questions over and play again? \n Yes or No");
                anotherAnswer = scan.next();
            } while (anotherAnswer.equalsIgnoreCase("Yes"));

                if (anotherAnswer.equalsIgnoreCase("No"))
                  System.out.println("Ok, have a great day!");
                
    }
}
