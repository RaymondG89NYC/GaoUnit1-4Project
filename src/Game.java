import java.util.Scanner;
public class Game {
    private int scene;
    private String username;
    private int hp;
    private int dmg;
    private int hunger;
    private String input = "";

    public Game (){
        scene = 1;
        username = "User";
        hp = 100;
        dmg = 10;
        hunger = 100;
    }
    public Game (String username){
        this.username = username;
        scene = 1;
        hp = 100;
        dmg = 10;
        hunger = 100;
    }

    public int getScene(){
        return scene;
    }

    public void createScene(){
        if (scene == 1){
            System.out.print("You are on a strange ever changing island. Try your best to survive and escape.");
        }
        else{
            System.out.println("You arrive on a cliff overlooking the ocean.\nThere is nothing to do here, so you head back.");
            headBack();
        }
    }

    public void options(){
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to explore this area or travel elsewhere? (E/T)");
        String answer = input.nextLine();

        if(answer.equals("E")){

        }
        if(answer.equals("T")){
            System.out.println("Which direction do you want to travel in? (N/E/S/W)");
            answer = input.nextLine();
            changeScene(answer);
        }
    }

    public void changeScene(String input){
        this.input = input;
        if(input.equals("N")){
            scene += 4;
        }
        else if(input.equals("E")){
            scene += 1;
        }
        else if(input.equals("S")){
            scene -= 4;
        }
        else if(input.equals("W")){
            scene -= 1;
        }
        else{

        }
    }
    public void headBack(){
        if(input.equals("N")){
            scene -= 4;
        }
        else if(input.equals("E")){
            scene -= 1;
        }
        else if(input.equals("S")){
            scene += 4;
        }
        else if(input.equals("W")){
            scene += 1;
        }
    }
}
