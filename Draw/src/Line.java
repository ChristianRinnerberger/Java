import java.awt.*;

public class Line extends Point {

    private int coordX2;
    private int coordY2;

    public Line(Canvas canvas, int coordX, int coordY, int coordX2, int coordY2, Color color){
        super(canvas,coordX, coordY,color);
        this.coordX2 = coordX2;
        this.coordY2= coordY2;
        getCanvas().registerObject(this);
    }

    @Override
    public void draw() {
        getCanvas().getGraphics().setColor(color);
        getCanvas().getGraphics().drawLine(getCoordX(), getCoordY(), getCoordX(), getCoordY());
    }

    public int getCoordX2() {
        return coordX2;
    }

    public void setCoordX2(int coordX2) {
        this.coordX2 = coordX2;
    }

    public int getCoordY2() {
        return coordY2;
    }

    public void setCoordY2(int coordY2) {
        this.coordY2 = coordY2;
    }
}
