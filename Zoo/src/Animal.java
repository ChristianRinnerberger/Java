public abstract class Animal {
    private int age;
    private String name;
    private int paws;
    private String color;
    private int counter;


    public Animal(int age, String name, int paws, String color){
        this.age = age;
        this.name = name;
        this.paws = paws;
        this.color = color;
        counter++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPaws() {
        return paws;
    }

    public void setPaws(int paws) {
        this.paws = paws;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCounter() {
        return counter;
    }

}
