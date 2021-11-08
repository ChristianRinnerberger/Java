public class Seat {
    private static int counter = 1;
    private int id;
    private int showRoomId;
    private int row;
    private int number;

    public Seat(int id, int showRoomId, int row, int number, boolean create) {
        this.showRoomId = showRoomId;
        this.row = row;
        this.number = number;
        this.id = id;
        if (create)
            counter++;
    }

    public Seat(int id, int showRoomId, int row, int number) {
        this(id, showRoomId, row, number, false);
    }

    public Seat(int showRoomId, int row, int number) {
        this(counter, showRoomId, row, number, true);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Seat.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowRoomId() {
        return showRoomId;
    }

    public void setShowRoomId(int showRoomId) {
        this.showRoomId = showRoomId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Seat (" + id + "): Show Room (" + showRoomId + "), Row (" + row + "), Seat (" + number + ")\n";
    }
}
