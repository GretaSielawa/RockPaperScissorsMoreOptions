import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class GameOption2 extends GameOption1 {
    public GameOption2(String name) {
        super(name);
    }

    public static boolean winsAgainst(String userChoice, String compChoice, String[] choices) {
        int userIndex = Arrays.asList(choices).indexOf(userChoice);
        int compIndex = Arrays.asList(choices).indexOf(compChoice);

        int halfSize = choices.length / 2;
        List<String> options = Arrays.asList(choices);

        List<String> optionsBeaten = new ArrayList<>();
        for (int i = userIndex + 1; i <= userIndex + halfSize; i++) {
            optionsBeaten.add(options.get(i % options.size()));
        }

        List<String> optionsBeating = new ArrayList<>();
        for (int i = userIndex + halfSize + 1; i <= userIndex + halfSize + halfSize; i++) {
            optionsBeating.add(options.get(i % options.size()));
        }

        if (optionsBeaten.contains(compChoice)) {
            return false;
        }
        if (optionsBeating.contains(compChoice)) {
            return true;
        }

        return false; // Draw
    }


    @Override
    public void playGame() {
        scoreBoard();

        String[] choices = {"rock", "gun", "lightning", "devil", "dragon", "water", "air", "paper", "sponge", "wolf",
                "tree", "human", "snake", "scissors", "fire"};
        int rating = 0;
        boolean exit = false;

        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();
            Random random = new Random();
            int randomIndex = random.nextInt(choices.length);
            String compChoice = choices[randomIndex];

            if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + rating);
            } else if (userChoice.equals("!exit")) {
                exit = true;
                System.out.println("Bye");
            } else if (Arrays.asList(choices).contains(userChoice)) {
                if (winsAgainst(userChoice, compChoice, choices)) {
                    rating += 100;
                    System.out.println("Well done. The computer chose " + compChoice + " and failed");
                } else if (winsAgainst(compChoice, userChoice, choices)) {
                    rating += 0;
                    System.out.println("Sorry, but the computer chose " + compChoice);
                } else {
                    rating += 50;
                    System.out.println("There is a draw: " + userChoice + " vs " + compChoice);
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }

}