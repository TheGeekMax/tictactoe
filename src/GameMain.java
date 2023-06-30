import player.*;
import textures.TextureManager;

import javax.swing.*;
import java.awt.*;

public class GameMain extends JFrame {
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 600;
    public static final int WIDTH = 3;
    public static final int HEIGHT = 3;

    public static boolean playing = false;
    public static boolean touchable = false;
    public int player = 1; //1- player 1, 2- player 2

    //variables relatif au tableau :
    public int[][] plateau = new int[WIDTH][HEIGHT];
    public GameButton[][] buttons = new GameButton[WIDTH][HEIGHT];

    //variables associé au joueurs
    private UserPlayer p1;
    private UserPlayer p2;

    public GameMain(){
        p1 = new RandIa(this);
        p2 = new RandIa(this);

        this.setTitle("Tic Tac Toe");
        this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(WIDTH,HEIGHT));
        this.setResizable(false);
        this.setIconImage(TextureManager.CROSS.getImage());

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

        play();
    }

    private void play(){
        while(true) {
            while (!isWin()) {
                playing = false;
                player = 1;
                p1.play(plateau);

                if (!isWin()) {
                    playing = false;
                    player = 2;
                    p2.play(plateau);
                }
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            reset();
        }
    }

    private void reset(){
        for(int j = 0; j < HEIGHT; j ++){
            for(int i = 0; i < WIDTH; i ++){
                plateau[i][j] = 0;
                buttons[i][j].reset();
            }
        }
    }

    public static void main(String[] args) {
        new GameMain();
        //new TextureManager();
    }

    public void playAt(int x,int y){

        if(playing)
            return;

        if(plateau[x][y] == 0){
            plateau[x][y] = player;
            buttons[x][y].changeIcon(player);
            playing = true;
        }
    }

    private boolean isWin(){
        //cas long 3 (cas > todo )
        boolean empty = true;
        for(int j = 0; j < HEIGHT; j ++){
            for(int i = 0; i < WIDTH; i ++){
                if(plateau[i][j] == 0){
                    empty = false;
                }
            }
        }

        if(empty)
            return true;

        for(int i = 0 ; i< 3 ; i ++){
            if(plateau[i][0] == plateau[i][1] && plateau[i][0] == plateau[i][2] && plateau[i][0] != 0)
                return true;

            if(plateau[0][i] == plateau[1][i] && plateau[0][i] == plateau[2][i]&& plateau[0][i] != 0)
                return true;
        }
        return (plateau[0][0] == plateau[1][1] && plateau[0][0] == plateau[2][2] && plateau[0][0] != 0)
            || (plateau[2][0] == plateau[1][1] && plateau[2][0] == plateau[0][2] && plateau[2][0] != 0);
    }
}