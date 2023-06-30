import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import textures.TextureManager;

public class GameButton extends JButton {
    public int x,y;
    private GameMain instance;

    public GameButton(int x,int y,GameMain instance){
        super("");
        this.setIcon(rescale(TextureManager.BLANK));
        this.x = x;
        this.y = y;
        this.instance = instance;
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(GameMain.touchable)
                    instance.playAt(x,y);
            }
        });
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
    }
    public void changeIcon(int player){
        if(player == 1){
            this.setIcon(rescale(TextureManager.CIRCLE));
        }else{
            this.setIcon(rescale(TextureManager.CROSS));
        }
    }

    public void reset(){
        this.setIcon(rescale(TextureManager.BLANK));
    }

    private ImageIcon rescale(ImageIcon icon){
        return new ImageIcon(icon.getImage().getScaledInstance(GameMain.SCREEN_WIDTH/GameMain.WIDTH,GameMain.SCREEN_HEIGHT/GameMain.HEIGHT,Image.SCALE_SMOOTH));
    }

    public void updatePic(ImageIcon icon){
        this.setIcon(rescale(icon));
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(600/GameMain.WIDTH,600/GameMain.HEIGHT);
    }
}
