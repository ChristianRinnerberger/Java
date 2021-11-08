public class Reservation {
    private static int counter = 1;
    private int id;
    private int showId;
    private int seatId;
    private CinemaDao dao;

    public Reservation(CinemaDao dao, int id, int showId, int seatId, boolean create) {
        this.dao = dao;
        this.id = id;
        this.seatId = seatId;
        this.showId = showId;
        if (create)
            counter++;
    }

    public Reservation(CinemaDao dao, int id, int showId, int seatId) {
        this(dao, id, showId, seatId, false);
    }

    public Reservation(CinemaDao dao, int showId, int seatId) {
        this(dao, counter, showId, seatId, true);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Reservation.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    @Override
    public String toString() {
        Show showInfo = dao.getShow(showId);
        Movie movieInfo = dao.getMovie(showInfo.getMovieId());
        Seat seatInfo = dao.getSeat(seatId);

        return "Reservation: " + movieInfo.getTitle() + " -- " + movieInfo.getStoryTitle() + "\n" +
                showInfo.getDate() + ", " + seatInfo.toString();
    }
}
