import javax.swing.*;
import java.awt.*;

public class GameMain extends JFrame {
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    public static final int WIDTH = 3;
    public static final int HEIGHT = 3;

    public boolean playing = false;
    public int player = 1; //1- player 1, 2- player 2

    //variables relatif au tableau :
    public int[][] plateau = new int[WIDTH][HEIGHT];
    public GameButton[][] buttons = new GameButton[WIDTH][HEIGHT];

    //variables associé au joueurs
    private UserPlayer p1;
    private UserPlayer p2;

    public GameMain(){
        this.setTitle("Tic Tac Toe");
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(WIDTH,HEIGHT));

        //on ajoute tout les boutons
        for(int j = 0; j < HEIGHT; j ++){
            for(int i = 0; i < WIDTH; i ++){
                plateau[i][j] = 0;
                GameButton current = new GameButton(i,j,this);
                buttons[i][j] = current;
                this.getContentPane().add(current);
            }
        }
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GameMain();
        //new TextureManager();
    }

    public void playAt(int x,int y){
        return;
    }
}