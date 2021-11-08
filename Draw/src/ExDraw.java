import java.awt.*;

public class ExDraw {
    public static void main(String[] args) {
        Canvas myCanvas = new Canvas(1024,768);
        Point firstPoint = new Point(myCanvas,50,50, Color.black);
        Line firstLine = new Line(myCanvas,50,100,150,70,Color.ORANGE);
        Circle firstCircle = new Circle(myCanvas,200,200,30,Color.GREEN);
        myCanvas.setVisible(true);
    }
}
