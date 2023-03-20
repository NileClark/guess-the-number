import java.util.Scanner;

public class GuessTheNumber {
    // game where user gets N number of tries to guess randomly generated number

    // method to generate the random number
    public int getRandomNumber() {
        int randomNumber;
        randomNumber = (int) (Math.random() * 100);
        return randomNumber;
    }

    // method to compare the random number with the guess
    public boolean compareNumbers(int userGuess, int randomNumber) {
        boolean theyMatch;
        if (randomNumber == userGuess) {
            theyMatch = true;
        } else {
            theyMatch = false;
        }
        return theyMatch;
    }

    // method to notify user of guess status
    public void notifyUser(String status, int guess, int number) {
        switch (status) {
            case "equal":
                System.out.println("Congratulations! You guessed it!!");
                break;
            case "less than":
                System.out.println("The number is greater than " + guess);
                break;
            case "greater than":
                System.out.println("The number is less than " + guess);
                break;
            default:
                System.out.println("Oops! You've used up all your guesses. The number was " + number + ".");
        }
    }

    public static void guessNumberGame() {
        // program should ask user's number, compare to generated number, communicate
        // if the user is correct, too high, or too low, communicate how many guesses

        GuessTheNumber gtn = new GuessTheNumber();
        Scanner sc = new Scanner(System.in);
        try {
            int numGuesses = 5;

            int number = gtn.getRandomNumber();

            System.out.println("I've chosen a number between 1 & 100."
                    + " You've got " + numGuesses + " tries to guess it!");

            for (int i = 0; i <= numGuesses; i++) {

                System.out.println("What's your guess?");
                int guess = sc.nextInt();

                if (i == numGuesses) {
                    gtn.notifyUser("out of guesses", guess, number);
                    break;
                }
              

                if (gtn.compareNumbers(guess, number)) {
                    gtn.notifyUser("equal", guess, number);
                    break;
                } else if (!gtn.compareNumbers(guess, number) && guess < number) {
                    gtn.notifyUser("less than", guess, number);
                } else if (!gtn.compareNumbers(guess, number) && guess > number) {
                    gtn.notifyUser("greater than", guess, number);
                }
            }
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) {
        guessNumberGame();
    }

}