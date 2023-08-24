
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameOption1 {
    int rating;
    String userChoice = "";
    String compChoice;
    boolean exit = false;
    boolean loss = false;
    boolean draw = false;
    boolean win = false;
    private String name; // Declare a variable to store the player's name

    // Constructor to receive the player's name
    public GameOption1(String name) {
        this.name = name;
    }

    public void welcomeUser() {
        System.out.println("Hello, " + name);
    }


    public void scoreBoard() {

        String filePath = "rating.txt";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String wholeFile = scanner.nextLine();
                HashMap<String, Integer> scores = new HashMap<>();
                String[] eachLine = wholeFile.split(" ");
                String part1 = eachLine[0];
                String part2 = eachLine[1];
                //to insert values to scores
                for (int i = 0; i < wholeFile.length(); i++) {
                    scores.put(part1, Integer.parseInt(part2));
                }
                Map<String, Integer> scoreboard = new HashMap<>();
                scoreboard.put(name, rating);
                // Iterate over the HashMap
                if (scores.containsKey(name)) {
                    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                        String key = entry.getKey();
                        int value = entry.getValue();
                        rating = value;
                    }
                    if (!scores.containsKey(name)) {
                        rating = 0;
                    }

                }
            }//try scope
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }// working on file
    }


    public void playGame() {
        scoreBoard();
        while (!exit) {
            Scanner scanner = new Scanner(System.in);
            userChoice = scanner.nextLine();
            String[] choices = {"rock", "paper", "scissors"};

            Random random = new Random();
            int randomIndex = random.nextInt(choices.length);
            compChoice = choices[randomIndex];

            if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + rating);
            } else if (userChoice.equals(compChoice)) {
                draw = true;
                rating += 50;
                System.out.println("There is a draw " + compChoice);
            } else if ((userChoice.equals("rock") && compChoice.equals("scissors")) ||
                    (userChoice.equals("paper") && compChoice.equals("rock")) ||
                    (userChoice.equals("scissors") && compChoice.equals("paper"))) {
                win = true;
                rating += 100;
                System.out.println("Well done. The computer chose " + compChoice + " and failed");
            } else if ((userChoice.equals("scissors") && compChoice.equals("rock")) ||
                    (userChoice.equals("rock") && compChoice.equals("paper")) ||
                    (userChoice.equals("paper") && compChoice.equals("scissors"))) {
                loss = true;
                rating += 0;
                System.out.println("Sorry, but the computer chose " + compChoice);
            } else if (userChoice.equals("!exit")) {
                exit = true;
                System.out.println("Bye");
            } else {
                System.out.println("Invalid input");
            }

        }

    }

}



















