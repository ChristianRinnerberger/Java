public abstract class DrawAble {
    private final Canvas canvas;
    private int coordX;
    private int coordY;

    public DrawAble(Canvas canvas, int coordX, int coordY){
        this.canvas = canvas;
        this.coordX = coordX;
        this.coordY = coordY;
        getCanvas().registerObject(this);
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public abstract void draw();
}
