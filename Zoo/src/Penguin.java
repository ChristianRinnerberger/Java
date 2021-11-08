public class Penguin extends Animal {

    private boolean hasABuddy;

    public Penguin(boolean hasABuddy,int age, String name,int paws,String color){
        super(age, name, paws, color);
        this.hasABuddy = hasABuddy;
    }

    public boolean isHasABuddy() {
        return hasABuddy;
    }

    public void setHasABuddy(boolean hasABuddy) {
        this.hasABuddy = hasABuddy;
    }
}
