enum Genre {
    ACTION,
    ROMANCE,
    COMEDY,
    SCIFI,
    HORROR
}
public class Movie {
    private static int counter = 1;
    private int id;
    private String title;
    private Genre genre;
    private String storyTitle;

    public Movie(int id, String title, String storyTitle, Genre genre, boolean create) {
        this.id = id;
        this.title = title;
        this.storyTitle = storyTitle;
        this.genre = genre;
        if (create)
            counter++;
    }

    public Movie(int id, String title, String storyTitle, Genre genre) {
        this(id, title, storyTitle, genre, false);
    }

    public Movie(String title, String storyTitle, Genre genre) {
        this(counter, title, storyTitle, genre, true);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Movie.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    @Override
    public String toString() {
        return "Movie ("+id+"): " + title + " - " + storyTitle + "(" + genre + ")\n";
    }
}
