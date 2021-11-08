public class Lens {

    private int minBrennweite;
    private int maxBrennweite;
    public static int count;

    public Lens(int minBrennweite, int maxBrennweite){
       if (minBrennweite < maxBrennweite) {
           this.minBrennweite = minBrennweite;
           this.maxBrennweite = maxBrennweite;
           count++;
       }
       else
       {
           this.minBrennweite = maxBrennweite;
           this.maxBrennweite = minBrennweite;
           count++;
       }
    }

    public int getMinBrennweite() {
        return minBrennweite;
    }

    public void setMinBrennweite(int minBrennweite) {
        this.minBrennweite = minBrennweite;
    }

    public int getMaxBrennweite() {
        return maxBrennweite;
    }

    public void setMaxBrennweite(int maxBrennweite) {
        this.maxBrennweite = maxBrennweite;
    }

    @Override
    public String toString() {
        return "Lens{" +
                "minBrennweite=" + minBrennweite +
                ", maxBrennweite=" + maxBrennweite +
                ", size=" + count +
                '}';
    }
}
