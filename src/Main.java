import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Game gameFile = new Game();
        System.out.println("This is a simple adventure game.");
        Scanner input = new Scanner(System.in);
        gameFile.wait(2);
        System.out.println("Do you want to name your character? Type Y if yes and type anything else if no.");
        String answer = input.nextLine();

        if(answer.equals("Y")){
            System.out.println("What is your character's name?");
            answer = input.nextLine();
            gameFile = new Game(answer);
        }
        else{
            gameFile = new Game();
        }

        while(gameFile.getScene() != -100){
            gameFile.createScene();
            if(gameFile.getScene() > -100) {
                gameFile.wait(2);
                gameFile.options(false);
            }
        }

        System.out.println("You win! Good job!");
        System.out.println(gameFile);

    }
}
