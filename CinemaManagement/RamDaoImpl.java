import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RamDaoImpl implements CinemaDao {
    HashMap<Integer, Movie> movieStorage;
    HashMap<Integer, ShowRoom> showRoomStorage;
    HashMap<Integer, Seat> seatStorage;
    HashMap<Integer, Reservation> reservationStorage;
    HashMap<Integer, Show> showStorage;

    public RamDaoImpl() {
        movieStorage = new HashMap<>();
        showRoomStorage = new HashMap<>();
        seatStorage = new HashMap<>();
        reservationStorage = new HashMap<>();
        showStorage = new HashMap<>();
    }

    @Override
    public ArrayList<ShowRoom> getAllShowRooms() {
        ArrayList<ShowRoom> result = new ArrayList<>();
        for (Map.Entry<Integer, ShowRoom> entry : showRoomStorage.entrySet()
             ) {
            //entry.getKey();
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, Movie> entry : movieStorage.entrySet()
        ) {
            //entry.getKey();
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public ArrayList<Seat> getAllSeats() {
        ArrayList<Seat> result = new ArrayList<>();
        for (Map.Entry<Integer, Seat> entry : seatStorage.entrySet()
        ) {
            //entry.getKey();
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        ArrayList<Reservation> result = new ArrayList<>();
        for (Map.Entry<Integer, Reservation> entry : reservationStorage.entrySet()
        ) {
            //entry.getKey();
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public ArrayList<Show> getAllShows() {
        ArrayList<Show> result = new ArrayList<>();
        for (Map.Entry<Integer, Show> entry : showStorage.entrySet()
        ) {
            //entry.getKey();
            result.add(entry.getValue());
        }
        return result;
    }

    @Override
    public void addShowRoom(ShowRoom showRoom) {
        showRoomStorage.put(showRoom.getId(), showRoom);
    }

    @Override
    public ShowRoom removeShowRoom(int id) {
        return showRoomStorage.remove(id);
    }

    @Override
    public ShowRoom getShowRoom(int id) {
        return showRoomStorage.get(id);
    }

    @Override
    public Seat addSeat(int showRoomId, int row, int number) {
        Seat newSeat = new Seat(showRoomId, row, number);
        return seatStorage.put(newSeat.getId(), newSeat);
    }

    @Override
    public Seat getSeat(int id) {
        return seatStorage.get(id);
    }

    @Override
    public Seat getSeat(int showRoomId, int row, int seat) {
        Seat result;
        for ( Map.Entry<Integer, Seat> entry : seatStorage.entrySet()
             ) {
            if (entry.getValue().getNumber() == seat && entry.getValue().getRow() == row) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public Seat removeSeat(int seatId) {
        return seatStorage.remove(seatId);
    }

    @Override
    public Movie addMovie(String title, String storyTitle, Genre genre) {
        Movie newMovie = new Movie(title, storyTitle, genre);
        return movieStorage.put(newMovie.getId(), newMovie);
    }

    @Override
    public Movie removeMovie(int id) {
        return movieStorage.remove(id);
    }

    @Override
    public Movie getMovie(int id) {
        return movieStorage.get(id);
    }

    @Override
    public Show scheduleMovie(int showRoomId, LocalDate date, int movieId) {
        Show newShow = new Show(this, movieId, showRoomId, date);
        return showStorage.put(newShow.getId(), newShow);
    }

    @Override
    public Show unscheduleMovie(int id) {
        return showStorage.remove(id);
    }

    @Override
    public Show getShow(int id) {
        return showStorage.get(id);
    }

    @Override
    public Reservation reserveSeat(int showId, int row, int seat) {
        Seat tmpSeat = getSeat(getShow(showId).getShowRoomId(), row, seat);
        if (tmpSeat == null) {
            System.out.println("Error: Seat does not exist!");
            return null;
        } else {
            Reservation newReservation = new Reservation(this, showId, tmpSeat.getId());
            return reservationStorage.put(newReservation.getId(), newReservation);
        }
    }

    @Override
    public Reservation deleteReservation(int id) {
        return reservationStorage.remove(id);
    }

    @Override
    public Reservation getReservation(int id) {
        return reservationStorage.get(id);
    }

    @Override
    public boolean checkReservation(int showId, int seatId) {
        for (Map.Entry<Integer, Reservation> entry : reservationStorage.entrySet()
             ) {
            if (entry.getValue().getSeatId() == seatId && entry.getValue().getShowId() == showId) {
                return true;
            }
        }
        return false;
    }
}
