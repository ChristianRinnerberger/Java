public class Tiger extends Animal {

    private int strips;

    public Tiger(int strips,int age, String name,int paws,String color){
        super(age,name,paws,color);
        this.strips = strips;
    }

    public int getStrips() {
        return strips;
    }

    public void setStrips(int strips) {
        this.strips = strips;
    }
}
