import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        int count = 0;
        int castCount = 0;
        for (SimpleMovie movie : movies) {
            if (movie.getActorsData().indexOf("Kevin Bacon") != -1) {
                count++;
                castCount += movie.getNumOfActors();
            }
        }
        System.out.println("Number of Kevin Bacon movies: " + count);
        System.out.println("Number of cast members: " + castCount);
    }
}