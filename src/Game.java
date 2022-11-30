import java.util.Scanner;
public class Game {
    private int scene;
    private String username;
    private int hp;
    private int atk;
    private int food;
    private int defense = 0;
    private String input = "";
    private String biome = "";
    private String biomeAdj = "";
    private boolean goodAdj;

    private boolean wolf = false;
    private boolean giantScorpion = false;
    private boolean bear = false;
    private boolean giantBear = false;

    public Game (){
        scene = 1;
        username = "User";
        hp = 100;
        atk = 10;
        food = 90;
    }
    public Game (String username){
        this.username = username;
        scene = 1;
        hp = 100;
        atk = 10;
        food = 90;
    }

    public int getScene(){
        return scene;
    }


    public void createScene(){
        System.out.println();

        if (scene == 1){
            System.out.print("Hello " + username + ", you are on a strange ever changing island. Try your best to survive and escape.");
        }
        else if(scene == 0){
            biome = "forest";
            description();
        }
        else{
            System.out.println("You arrive on a cliff overlooking the ocean.\nThere is nothing to do here, so you head back.");
            headBack();
        }

        if(food > 90){
            System.out.println("You are well fed. +5 hp");
            hp += 5;
        }
        if(food <= 10){
            System.out.println("You are starving! -10 hp");
            hp -= 10;
        }

        food -= 10;
        statsCheck();
        System.out.println("HP: " + hp);
        System.out.println("food: " + food);
    }

    public void options(boolean typo){
        Scanner input = new Scanner(System.in);
        String answer = "";

        if(!typo) {
            System.out.println("Do you want to explore this area or travel elsewhere? (E/T)");
            answer = input.nextLine();

            if (answer.equals("E")) {
                double chance = Math.random();
                if (biome.equals("forest")) {
                    if (goodAdj) {
                        if (chance <= (1.0 / 3.0)) {
                            System.out.println("You caught a rabbit and ate it. +40 food");
                            food += 40;
                        } else if (chance >= (2.0 / 3.0)) {
                            System.out.println("You caught a bird and ate it. +20 food");
                            food += 20;
                        } else {
                            System.out.println("You found a bush of wild berries. Do you want to eat them? (Y/N)");
                            answer = input.nextLine();

                            if (answer.equals("Y")) {
                                chance = Math.random();
                                if (chance >= 1.0 / 2.0) {
                                    System.out.println("The berries tasted like strawberries. +30 food");
                                    food += 30;
                                } else {
                                    System.out.println("The berries gave you food poisoning! -15 food -5 health");
                                }
                            }
                        }
                    }
                    //goodAdj = false
                    else {
                        if (chance <= (1.0 / 3.0)) {
                            System.out.println("You couldn't find anything");
                        } else if (chance >= (2.0 / 3.0)) {
                            System.out.println("You caught a bird and ate it. +20 food");
                            food += 20;
                        } else {
                            System.out.println("You found a bush of wild berries. Do you want to eat them? (Y/N)");
                            answer = input.nextLine();
                            if (answer.equals("Y")) {
                                chance = Math.random();
                                if (chance >= 1.0 / 2.0) {
                                    System.out.println("The berries tasted like strawberries. +30 food");
                                    food += 30;
                                } else {
                                    System.out.println("The berries gave you food poisoning! -15 food -5 health");
                                }
                            }
                        }
                    }
                }

                if (biome.equals("desert")) {
                    if (chance <= (1.0 / 3.0)) {
                        System.out.println("You found a cactus and ate it but you accidentally touched a few spikes. +15 food -5 hp");
                        hp -= 5;
                        food += 15;
                    } else if (chance >= (2.75 / 3.0)) {
                        System.out.println("You caught a lizard and ate it. +15 food");
                        food += 15;
                    } else {
                        System.out.println("You couldn't find anything");
                    }
                }
                answer = "T";
                System.out.println("You feel like you have stayed in this area for long enough and decide to travel elsewhere");
            }
            if (answer.equals("T")) {
                System.out.println("Which direction do you want to travel in? (N/E/S/W)");
                answer = input.nextLine();
                changeScene(answer);
            }
        }
        else {
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
            System.out.println("Sorry, please enter one of the options within the parentheses");
            options(true);
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
    public String adjective(){
        double chance = Math.random();
        String adj = "";

        if(biome.equals("forest")){
            if (chance <= (1.0 / 3.0)) {
                adj = "thick lush";
                goodAdj = true;
            } else if (chance >= (2.0 / 3.0)) {
                adj = "flourishing";
                goodAdj = true;
            } else {
                adj = "bare";
                goodAdj = false;
            }
        }
        if(biome.equals("desert")){
            if (chance <= (1.0 / 3.0)) {
                adj = "barren";
                goodAdj = false;
            } else if (chance >= (2.0 / 3.0)) {
                adj = "arid";
                goodAdj = false;
            } else {
                adj = "dry";
                goodAdj = false;
            }
        }
        //a or an
        String firstLetter = adj.substring(0,1);
        if(firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i") || firstLetter.equals("o") || firstLetter.equals("u")){
            return "an" + adj;
        }
        else{
            return "a" + adj;
        }

    }

    public void description(){
        System.out.println("You arrive at " + adjective() + biome + ".");
    }

    public void statsCheck(){
        if(hp>100){
            hp = 100;
        }
        if(food>100){
            food = 100;
        }
    }
}
