public class Camera {


    private Lens lens;
    private String brand;
    private int megaPixels;
    private int displaySize;
    private boolean colored;
    public static int count;


    public void setLens(Lens lens) {
        this.lens = lens;
    }

    public Camera(Lens lens, String brand, int megaPixels, int displaySize, boolean colored) {
        this.lens = lens;
        this.brand = brand;
        this.megaPixels = megaPixels;
        this.displaySize = displaySize;
        this.colored = colored;
        count++;
    }

    public Lens getLens() {
        return lens;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMegaPixels() {
        return megaPixels;
    }

    public void setMegaPixels(int megaPixels) {
        this.megaPixels = megaPixels;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }


    public int getSize() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "lens=" + lens +
                ", brand='" + brand + '\'' +
                ", megaPixels=" + megaPixels +
                ", displaySize=" + displaySize +
                ", colored=" + colored +
                '}';
    }
}

