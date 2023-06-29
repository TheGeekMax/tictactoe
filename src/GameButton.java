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
                instance.playAt(x,y);
                updatePic(TextureManager.CIRCLE);
            }
        });
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
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
