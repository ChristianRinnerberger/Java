import java.util.HashMap;

public class RamDaoImpl implements ZooDao{
    HashMap<Integer, Animal> animalStorage;
    HashMap<Integer, Zebra> zebraStorage;
    HashMap<Integer, Tiger> tigerStorage;
    HashMap<Integer, Penguin> penguinStorage;

    public RamDaoImpl(){
        animalStorage = new HashMap<>();
        zebraStorage = new HashMap<>();
        tigerStorage = new HashMap<>();
        penguinStorage = new HashMap<>();
    }

    @Override
    public HashMap<Integer, Animal> getAllAnimals() {
        return animalStorage;
    }

    @Override
    public HashMap<Integer, Tiger> getAllTigers() {
        return tigerStorage;
    }

    @Override
    public HashMap<Integer, Penguin> getAllPenguins() {
        return penguinStorage;
    }

    @Override
    public HashMap<Integer, Zebra> getAllZebras() {
        return zebraStorage;
    }

    @Override
    public void addTiger() {

    }

    @Override
    public Tiger removeTiger() {
        return null;
    }

    @Override
    public Tiger getTiger() {
        return null;
    }

    @Override
    public void addPenguin() {

    }

    @Override
    public Penguin removePenguin() {
        return null;
    }

    @Override
    public Penguin getPenguin() {
        return null;
    }

    @Override
    public void addZebra() {

    }

    @Override
    public Zebra removeZebra() {
        return null;
    }

    @Override
    public Zebra getZebra() {
        return null;
    }
}
