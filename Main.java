import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        GameOption1 option1 = new GameOption1(name);
        GameOption2 option2 = new GameOption2(name);
        option1.welcomeUser();

        
        String gameChoice = scanner.nextLine();
        System.out.println("Okay, let's start");
        if (gameChoice.equals("")) {
            option1.playGame();
        } else if (gameChoice.contains("rock,gun,lightning,devil,dragon,water,air,paper,sponge,wolf,tree,human,snake,scissors,fire")) {
            option2.playGame();
        }


    }
}