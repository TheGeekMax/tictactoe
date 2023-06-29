package textures;
import com.sun.tools.javac.Main;
import javax.swing.*;

public class TextureManager {
    public static final ImageIcon BLANK = new ImageIcon(System.getProperty("user.dir") +"\\src\\textures\\blank.png");
    public static final ImageIcon CROSS = new ImageIcon(System.getProperty("user.dir") +"\\src\\textures\\circ.png");
    public static final ImageIcon CIRCLE = new ImageIcon(System.getProperty("user.dir") +"\\src\\textures\\cross.png");

    public TextureManager(){
        System.out.println(System.getProperty("user.dir"));
    }
}
