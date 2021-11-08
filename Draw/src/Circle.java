import java.awt.*;

public class Circle extends Point{
    private int radius;

    public Circle(Canvas canvas, int coordX, int coordY,int radius, Color color) {
        super(canvas, coordX, coordY, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        getCanvas().getGraphics().setColor(color);
        int x = getCoordX()-(radius/2);
        int y = getCoordY()-(radius/2);
        getCanvas().getGraphics().fillOval(x,y,radius,radius);
    }
}
