import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("This is a simple adventure game.");
        Scanner input = new Scanner(System.in);
        Game gameFile = new Game();
        System.out.println("Do you want to name your character? (Y/N)");
        String answer = input.nextLine();

        if(answer.equals("Y")){
            System.out.println("What is your character's name?");
            answer = input.nextLine();
            gameFile = new Game(answer);
        }
        else{
            gameFile = new Game();
        }

        while(gameFile.getScene() != -1){
            gameFile.createScene();
            gameFile.options(false);
        }

    }
}
