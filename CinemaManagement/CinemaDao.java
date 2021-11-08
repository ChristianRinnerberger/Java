import java.time.LocalDate;
import java.util.ArrayList;

public interface CinemaDao {
    public ArrayList<ShowRoom> getAllShowRooms();
    public ArrayList<Movie> getAllMovies();
    public ArrayList<Seat> getAllSeats();
    public ArrayList<Reservation> getAllReservations();
    public ArrayList<Show> getAllShows();
    public void addShowRoom(ShowRoom showRoom);
    public ShowRoom removeShowRoom(int id);
    public ShowRoom getShowRoom(int id);
    public Seat addSeat(int showRoomId, int row, int number);
    public Seat getSeat(int id);
    public Seat getSeat(int showRoomId, int row, int seat);
    public Seat removeSeat(int seatId);
    public Movie addMovie(String title, String storyTitle, Genre genre);
    public Movie removeMovie(int id);
    public Movie getMovie(int id);
    public Show scheduleMovie(int showRoomId, LocalDate date, int movieId);
    public Show unscheduleMovie(int id);
    public Show getShow(int id);
    public Reservation reserveSeat(int showId, int row, int seat);
    public Reservation deleteReservation(int id);
    public Reservation getReservation(int id);
    public boolean checkReservation(int showId, int seatId); // True -> reserved, False -> not reserved
}
