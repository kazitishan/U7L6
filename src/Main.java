import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an actor: ");
        String actor = s.nextLine();
        BaconNumber number = new BaconNumber(actor);
        System.out.println(number.findBaconNumber());

        /*System.out.println(baconActorMovies.size());
        int count = 0;
        int castCount = 0;
        for (SimpleMovie movie : movies) {
            if (movie.getActorsData().indexOf("Kevin Bacon") != -1) {
                count++;
                castCount += movie.getNumOfActors();
            }
        }
        System.out.println("Number of Kevin Bacon movies: " + count);
        System.out.println("Number of cast members to have worked with Kevin Bacon: " + castCount);
        System.out.println("Number of movies: " + movies.size());*/
    }
}