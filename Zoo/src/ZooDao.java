import java.util.HashMap;

public interface ZooDao {
    public HashMap<Integer, Animal> getAllAnimals();
    public HashMap<Integer, Tiger> getAllTigers();
    public HashMap<Integer, Penguin> getAllPenguins();
    public HashMap<Integer, Zebra> getAllZebras();
    public void addTiger ();
    public Tiger removeTiger();
    public Tiger getTiger();
    public void addPenguin ();
    public Penguin removePenguin();
    public Penguin getPenguin();
    public void addZebra ();
    public Zebra removeZebra();
    public Zebra getZebra();



}
