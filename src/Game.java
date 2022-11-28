public class Game {
    private int scene;
    private String username;

    public Game (){
        scene = 1;
        username = "User";
    }
    public Game (String username){
        this.username = username;
        scene = 1;
    }

    public int getScene(){
        return scene;
    }


}
