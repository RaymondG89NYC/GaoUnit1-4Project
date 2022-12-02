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
    private int wolfHp = 125;
    private int wolfAtk = 10;
    private int scorpHp = 50;
    private int scorpAtk = 25;
    private int bearHp = 150;
    private int bearAtk = 15;
    private int giantBearHp = 200;
    private int giantBearAtk = 20;

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
        Scanner input = new Scanner(System.in);
        String answer = "";
        System.out.println();

        if (scene == 1){
            biome = "forest";
            System.out.println("Hello " + username + ", you are on a strange ever changing island. The animals here seem smaller and weaker for some reason. Try your best to survive and escape.");
            wait(3);
            description();
        }
        else if(scene == 0){
            biome = "forest";
            description();
        }
        else if(scene == 2){
            biome = "forest";
            description();
        }
        else if(scene == 4){
            biome = "forest";
            description();
        }
        else if(scene == 5){
            biome = "forest";
            description();
        }
        else if(scene == 6){
            biome = "desert";
            description();
        }
        else if(scene == 8){
            biome = "forest";
            System.out.println("You arrive at a strange cave. The walls are smooth and appear to be man-made centuries ago. Moss are growing on the cave walls.");
            System.out.println("You spot something shine inside the cave, so you decided to go into the cave.");
            System.out.println("You discover a chest inside. It appears brand-new despite its surroundings, as if it had just appeared.");
            System.out.println("The chest creaked as you open it. It contains a stone sword and a leather helmet. Something resembling a decomposing rotten apple is also in the chest.");
            System.out.println("You decide to take the stone sword and the leather helmet. +12 atk +5 def");
        }
        else if(scene == 9){
            biome = "forest";
            description();
            encounter("bear", bearHp, bearAtk);
        }
        else if(scene == 10){
            biome = "desert";
            description();
            encounter("giant scorpion", scorpHp, scorpAtk);
        }
        else if(scene == 12){
            biome = "forest";
            description();
            encounter("wolf", wolfHp, wolfAtk);
        }
        else if(scene == 13){
            biome = "forest";
            description();
            System.out.println("You found a clearing in the middle of the forest. Do you want to build a camp here? (Y?N)");
            answer = input.nextLine();
        }
        else if(scene == 14){
            biome = "forest";
            description();
        }
        else if(scene == 16){
            biome = "forest";
            description();
        }
        else if(scene == 17){
            biome = "forest";
            description();
        }
        else if(scene == 18){
            biome = "forest";
            description();
        }
        else if(scene == 20){
            biome = "forest";
            description();
        }
        else if(scene == 21){
            biome = "forest";
            description();
        }
        else if(scene == 22){
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
        wait(2);
        System.out.println("HP: " + hp);
        System.out.println("food: " + food);
        System.out.println("Atk: " + atk);
    }

    public void options(boolean typo){
        Scanner input = new Scanner(System.in);
        String answer = "";

        if(!typo) {
            System.out.println("Do you want to explore this area or travel elsewhere? (E/T)");
            answer = input.nextLine();

            if (answer.equals("E")) {
                double chance = Math.random();
                double atkChance = Math.random();
                boolean dmgUp = false;
                if(atkChance <= 1.0/10.0){
                    dmgUp = true;
                }
                if (biome.equals("forest")) {
                    if (goodAdj) {
                        if (chance <= (1.0 / 3.0)) {
                            System.out.println("You caught a rabbit and ate it. +40 food");
                            if(dmgUp){
                                System.out.println("You now know more about animal anatomy. +1 atk");
                                atk++;
                            }
                            food += 40;
                        } else if (chance >= (2.0 / 3.0)) {
                            System.out.println("You caught a bird and ate it. +20 food");
                            if(dmgUp){
                                System.out.println("You now know more about animal anatomy. +1 atk");
                                atk++;
                            }
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
                            if(dmgUp){
                                System.out.println("You now know more about animal anatomy. +1 atk");
                                atk++;
                            }
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
                        if(dmgUp){
                            System.out.println("You now know more about animal anatomy. +1 atk");
                            atk++;
                        }
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
        String description = "";

        if(biome.equals("forest")){
            if (chance <= (1.0 / 3.0)) {
                biomeAdj = "thick lush";
                goodAdj = true;
                description = "The forest is vast and diverse, with ancient trees reaching high into the clouds. \n";
                description += "A mixture of noises, most of which are birds, add life to the forest, and drown out the occasional sounds of breaking twigs beneath the feet of larger animals.";
            } else if (chance >= (2.0 / 3.0)) {
                biomeAdj = "flourishing";
                goodAdj = true;
                description = " The tree have healthy green leaves, and a variety of beastly noises, belonging mostly to foraging beasts, echos in the air.";
            } else {
                biomeAdj = "bare";
                goodAdj = false;
                description = " The trees have no foliage and everything seems quiet. It looks as if this area is dying.";
            }
        }
        if(biome.equals("desert")){
            if (chance <= (1.0 / 3.0)) {
                biomeAdj = "barren";
                goodAdj = false;
            } else if (chance >= (2.0 / 3.0)) {
                biomeAdj = "arid";
                goodAdj = false;
            } else {
                biomeAdj = "dry";
                goodAdj = false;
            }
        }
        //a or an
        String firstLetter = biomeAdj.substring(0,1);
        if(firstLetter.equals("a") || firstLetter.equals("e") || firstLetter.equals("i") || firstLetter.equals("o") || firstLetter.equals("u")){
            return "an " + biomeAdj;
        }
        else{
            return "a " + biomeAdj + " " + biome + ". " + description;
        }

    }

    public void description(){
        System.out.println("You arrive at " + adjective());
    }

    public void statsCheck(){
        if(hp>100){
            hp = 100;
        }
        if(food>100){
            food = 100;
        }
        if(hp<=0){
            System.out.println("You died!");
            System.exit(0);
        }
    }

    public void encounter(String enemyName, int enemyHp, int enemyAtk){
        Scanner input = new Scanner(System.in);
        String answer = "";
        boolean answered = false;

        System.out.println("You found a " + enemyName + ". It seems to have sensed you as it tensed up.");
        while(!answered) {
            System.out.println("Do you want to fight it? (Y/N)");
            answer = input.nextLine();
            if(answer.equals("Y")){
                battle(enemyName, enemyHp, enemyAtk);
                answered = true;
            }
            else if(answer.equals("N")){
                System.out.println("You ran away when it looked straight at you");
                answered = true;
                headBack();
            }
        }
    }
    public void battle(String enemyName, int enemyHp, int enemyAtk){
        while (hp > 0 && enemyHp > 0){
            System.out.println();
            System.out.println("You have " + hp + "HP                     The " + enemyName + " has " + enemyHp);
            System.out.println("Test code: enemyHP: " + enemyHp + "wnear hp: " + bearHp);
            System.out.println("You attacked the " + enemyName + " for " + atk + "damage.");
            System.out.println("The " + enemyName + " attacked you for " + (enemyAtk-defense) + "damage.");
            hp -= enemyAtk;
            enemyHp -= atk;
            wait(1);
        }
        if(enemyHp <= 0){
            System.out.println("You killed the " + enemyName + " with " + hp + "hp left.");
            System.out.println("You now know more about animal anatomy. +1 atk");
            atk++;
        }
        if(hp <= 0){
            System.out.println("You died!");
            System.exit(0);
        }
    }
    public void wait(int seconds){
        try {
            Thread.sleep((long)seconds*1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
