import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JFrame {
    private int width;
    private int height;
    private Graphics2D g2d;
    private ArrayList<DrawAble> objects;

    public Canvas(int width, int hight){
        super("Zeichen-Demo");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        objects = new ArrayList<>();
    }

    public void paint(Graphics g){

        super.paint(g);
        for (DrawAble el : objects){
            el.draw();
        }
    }

    public void registerObject(DrawAble el){
        objects.add(el);
    }
}
