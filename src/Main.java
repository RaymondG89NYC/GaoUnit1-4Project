import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to name your character? (Y/N)");
        String answer = input.nextLine();

        Game gameFile = new Game();

        if(answer.equals("Y")){
            System.out.println("What is your character's name?");
            answer = input.nextLine();
            gameFile = new Game(answer);
        }
        else{
            gameFile = new Game();
        }

        while(gameFile.getScene() != -1){
            System.out.println("Test");
        }

    }
}
