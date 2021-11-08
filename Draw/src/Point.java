import java.awt.*;

public class Point extends DrawAble{

    private Color color;

    public Point(Canvas canvas, int coordX, int coordY,Color color){
        super(canvas, coordX, coordY);
        this.color = color;

    }

    @Override
    public void draw() {
        getCanvas().getGraphics().setColor(color);
        getCanvas().getGraphics().drawLine(getCoordX(), getCoordY(), getCoordX(), getCoordY());
    }
}
