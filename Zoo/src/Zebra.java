public class Zebra extends Tiger{

    private boolean runsALot;

    public Zebra(boolean runsALot, int strips,int age, String name,int paws,String color){
        super(strips, age, name, paws, color);
        this.runsALot = runsALot;
    }

    public boolean isRunsALot() {
        return runsALot;
    }

    public void setRunsALot(boolean runsALot) {
        this.runsALot = runsALot;
    }
}
