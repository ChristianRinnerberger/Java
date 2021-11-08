import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.*;

public class DerbyDaoImpl implements CinemaDao {
    Connection connection;

    public DerbyDaoImpl(String dbName) {
        this(dbName, false);
    }

    public DerbyDaoImpl(String dbName, boolean clearAll) {
        try
        {
            final String DB_URL = "jdbc:derby:"+dbName+";create=true";
            this.connection = DriverManager.getConnection(DB_URL);

            // Delete all Tables: "Tabula Rasa"
            if (clearAll)
                clearDatabase();

            // Set up all tables, that do not exist!
            initDatabase();

        } catch (Exception e)
        {
            System.out.println("Error Creating the Database!");
            System.out.println(e.getMessage());
        }
    }

    public void executeDBStatement(String sql) throws SQLException {
        try {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute(sql);
            } catch(SQLException e) {
                if (!e.getSQLState().equals("X0Y32")) {
                    return; // Already exists
                } else {
                    throw (e);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void clearDatabase() {
        String sql;
        try {
            sql = "DROP TABLE reservation";
            executeDBStatement(sql);
            sql = "DROP TABLE show";
            executeDBStatement(sql);
            sql = "DROP TABLE seat";
            executeDBStatement(sql);
            sql = "DROP TABLE showroom";
            executeDBStatement(sql);
            sql = "DROP TABLE movie";
            executeDBStatement(sql);
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void initDatabase() {
        String sql;
        try {
            sql = "CREATE TABLE showroom (id integer PRIMARY KEY, location varchar(32))";
            executeDBStatement(sql);

            sql = "CREATE TABLE movie (id integer PRIMARY KEY NOT NULL, title varchar(32), story_title varchar(32), genre varchar(32))";
            executeDBStatement(sql);

            sql = "CREATE TABLE seat (id integer PRIMARY KEY NOT NULL, showroom_id integer, FOREIGN KEY (showroom_id) REFERENCES showroom(id), row integer, number integer)";
            executeDBStatement(sql);

            sql = "CREATE TABLE show (id integer PRIMARY KEY NOT NULL, movie_id integer, FOREIGN KEY (movie_id) REFERENCES movie(id), showroom_id integer, FOREIGN KEY (showroom_id) REFERENCES showroom(id), show_date date)";
            executeDBStatement(sql);

            sql = "CREATE TABLE reservation (id integer PRIMARY KEY NOT NULL, seat_id integer, FOREIGN KEY (seat_id) REFERENCES seat(id), show_id integer, FOREIGN KEY (show_id) REFERENCES show(id))";
            executeDBStatement(sql);

            // Set Counter to the Max ID in Show Table + 1
            // Show.setCounter(123);

        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public ArrayList<ShowRoom> getAllShowRooms() {
        ArrayList<ShowRoom> result = new ArrayList<>();

        String sql = "SELECT * FROM SHOWROOM";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                int id = sqlResult.getInt("id");
                String location = sqlResult.getString("location");
                result.add(new ShowRoom(id, location));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> result = new ArrayList<>();

        String sql = "SELECT * FROM MOVIE";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                int id = sqlResult.getInt("id");
                String title = sqlResult.getString("title");
                String storyTitle = sqlResult.getString("story_title");
                Genre genre = Genre.valueOf(sqlResult.getString("genre"));

                result.add(new Movie(id, title, storyTitle, genre));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public ArrayList<Seat> getAllSeats() {
        ArrayList<Seat> result = new ArrayList<>();

        String sql = "SELECT * FROM SEAT";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                int id = sqlResult.getInt("id");
                int showRoomId = sqlResult.getInt("showroom_id");
                int row = sqlResult.getInt("row");
                int number = sqlResult.getInt("number");

                result.add(new Seat(id, showRoomId, row, number));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public ArrayList<Reservation> getAllReservations() {
        ArrayList<Reservation> result = new ArrayList<>();

        String sql = "SELECT * FROM RESERVATION";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                int id = sqlResult.getInt("id");
                int seatId = sqlResult.getInt("seat_id");
                int showId = sqlResult.getInt("show_id");

                result.add(new Reservation(this, id, showId, seatId));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public ArrayList<Show> getAllShows() {
        ArrayList<Show> result = new ArrayList<>();

        String sql = "SELECT * FROM SHOW";
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                int id = sqlResult.getInt("id");
                int movieId = sqlResult.getInt("movie_id");
                int showRoomId = sqlResult.getInt("showroom_id");
                LocalDate showDate = sqlResult.getDate("show_date").toLocalDate();

                result.add(new Show(this, id, movieId, showRoomId, showDate));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return result;
        }
        return result;
    }

    @Override
    public void addShowRoom(ShowRoom showRoom) {
        String sql = "INSERT INTO showroom (id, location) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, showRoom.getId());
            stmt.setString(2, showRoom.getLocation());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public ShowRoom removeShowRoom(int id) {
        return null;
    }

    @Override
    public ShowRoom getShowRoom(int id) {
        return null;
    }

    @Override
    public Seat addSeat(int showRoomId, int row, int number) {
        String sql = "INSERT INTO seat (id, showroom_id, row, number) VALUES (?, ?, ?, ?)";
        Seat seat = null;
        try {
            seat = new Seat(showRoomId, row, number);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, seat.getId());
            stmt.setInt(2, showRoomId);
            stmt.setInt(3, row);
            stmt.setInt(4, number);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return seat;
    }

    @Override
    public Seat getSeat(int id) {
        String sql = "SELECT * FROM seat where id = ?";
        Seat seat = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();

            while(sqlResult.next()) {
                id = sqlResult.getInt("id");
                int showRoomId = sqlResult.getInt("showroom_id");
                int row = sqlResult.getInt("row");
                int number = sqlResult.getInt("number");

                seat = new Seat(id, showRoomId, row, number);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return seat;
    }

    @Override
    public Seat getSeat(int showRoomId, int row, int seat) {
        String sql = "SELECT * FROM seat where showroom_id = ? AND row = ? AND number = ?";
        Seat rSeat = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, showRoomId);
            stmt.setInt(2, row);
            stmt.setInt(3, seat);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                int id = sqlResult.getInt("id");
                showRoomId = sqlResult.getInt("showroom_id");
                row = sqlResult.getInt("row");
                int number = sqlResult.getInt("number");

                rSeat = new Seat(id, showRoomId, row, number);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return rSeat;
    }

    @Override
    public Seat removeSeat(int seatId) {
        return null;
    }

    @Override
    public Movie addMovie(String title, String storyTitle, Genre genre) {
        String sql = "INSERT INTO movie (id, title, story_title, genre) VALUES (?, ?, ?, ?)";
        Movie movie = null;
        try {
            movie = new Movie(title, storyTitle, genre);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, movie.getId());
            stmt.setString(2, title);
            stmt.setString(3, storyTitle);
            stmt.setString(4, genre.toString());
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return movie;
    }

    @Override
    public Movie removeMovie(int id) {
        return null;
    }

    @Override
    public Movie getMovie(int id) {
        String sql = "SELECT * FROM movie where id = ?";
        Movie movie = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                id = sqlResult.getInt("id");
                String title = sqlResult.getString("title");
                String storyTitle = sqlResult.getString("story_title");
                Genre genre = Genre.valueOf(sqlResult.getString("genre"));

                movie = new Movie(id, title, storyTitle, genre);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return movie;
    }

    @Override
    public Show scheduleMovie(int showRoomId, LocalDate date, int movieId) {
        String sql = "INSERT INTO show (id, movie_id, showroom_id, show_date) VALUES (?, ?, ?, ?)";
        Show show = null;
        try {
            show = new Show(this, movieId, showRoomId, date);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, show.getId());
            stmt.setInt(2, movieId);
            stmt.setInt(3, showRoomId);
            stmt.setDate(4, Date.valueOf(date));
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return show;
    }

    @Override
    public Show unscheduleMovie(int id) {
        return null;
    }

    @Override
    public Show getShow(int id) {
        String sql = "SELECT * FROM show where id = ?";
        Show show = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                id = sqlResult.getInt("id");
                int movieId = sqlResult.getInt("movie_id");
                int showRoomId = sqlResult.getInt("showroom_id");
                LocalDate showDate = sqlResult.getDate("show_date").toLocalDate();

                show = new Show(this, id, movieId, showRoomId, showDate);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return show;
    }

    @Override
    public Reservation reserveSeat(int showId, int row, int seat) {
        String sql = "INSERT INTO reservation (id, seat_id, show_id) VALUES (?, ?, ?)";
        Reservation reservation = null;
        try {
            reservation = new Reservation(this, showId, row, seat);
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, reservation.getId());
            stmt.setInt(2, getSeat(getShow(showId).getShowRoomId(), row, seat).getId());
            stmt.setInt(3, showId);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return reservation;
    }

    @Override
    public Reservation deleteReservation(int id) {
        return null;
    }

    @Override
    public Reservation getReservation(int id) {
        String sql = "SELECT * FROM reservation where id = ?";
        Reservation reservation = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet sqlResult = stmt.getResultSet();
            while(sqlResult.next()) {
                id = sqlResult.getInt("id");
                int seatId = sqlResult.getInt("seat_id");
                int showId = sqlResult.getInt("show_id");

                reservation = new Reservation(this, id, seatId, showId);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return reservation;
    }

    @Override
    public boolean checkReservation(int showId, int seatId) {
        return false;
    }
}
