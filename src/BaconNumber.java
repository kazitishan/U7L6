import java.util.ArrayList;

public class BaconNumber {
    private ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");

    ArrayList<SimpleMovie> kevinBaconMovies;
    ArrayList<String> kevinBaconActors;
    ArrayList<SimpleMovie> kevinBaconActorsMovies;
    ArrayList<SimpleMovie> actorMovies;
    ArrayList<String> actorActors;
    ArrayList<SimpleMovie> actorActorsMovies;
    String actor;

    public BaconNumber(String actor){
        this.actor = actor;
        kevinBaconMovies = new ArrayList<SimpleMovie>();
        kevinBaconActors = new ArrayList<String>();
        kevinBaconActorsMovies = MovieDatabaseBuilder.getMovieDB("src/KevinBaconActorMovies.txt");

        actorMovies = new ArrayList<SimpleMovie>();
        actorActors = new ArrayList<String>();
        actorActorsMovies = new ArrayList<SimpleMovie>();

        // getting all Kevin Bacon movies and the actors in all of them, and all the inputted actor movies and the actors in them:
        for (SimpleMovie movie : movies){
            if (movie.getActorsData().contains("Kevin Bacon")) {
                kevinBaconMovies.add(movie);
                for (int i = 0; i < movie.getActors().size(); i++){
                    if (!kevinBaconActors.contains(movie.getActors().get(i))) kevinBaconActors.add(movie.getActors().get(i));
                }
            }
            if (movie.getActorsData().contains(actor)) {
                actorMovies.add(movie);
                for (int i = 0; i < movie.getActors().size(); i++){
                    if (!actorActors.contains(movie.getActors().get(i))) actorActors.add(movie.getActors().get(i));
                }
            }
        }


    }

    private SimpleMovie findCommonMovie(ArrayList<SimpleMovie> actor1, ArrayList<SimpleMovie> actor2){
        for (SimpleMovie movie : actor1){
            if (actor2.contains(movie)) return movie;
        }
        return null;
    }

    private String findCommonActor(ArrayList<String> actor1, ArrayList<String> actor2){
        for (String actor : actor1){
            if (actor2.contains(actor)) return actor;
        }
        return null;
    }

    public String findBaconNumber(){
        // checking first degree:
        SimpleMovie commonMovie = findCommonMovie(kevinBaconMovies, actorMovies);
        if (commonMovie != null){
            return "Bacon Number of 1: Kevin Bacon was in " + commonMovie.getTitle() + " with " + actor;
        }
        // checking second degree
        String commonActor = findCommonActor(kevinBaconActors, actorActors);
        if (commonActor != null){
            ArrayList<SimpleMovie> commonActorMovies = new ArrayList<SimpleMovie>();
            for (SimpleMovie movie : movies){
                if (movie.getActors().contains(commonActor)) commonActorMovies.add(movie);
            }
            return "Bacon Number of 2: Kevin Bacon was in " + findCommonMovie(kevinBaconMovies, commonActorMovies).getTitle() + " with " + commonActor + " who was in " + findCommonMovie(commonActorMovies, actorMovies).getTitle() + " with " + actor;
        }
        // checking third degree:
        for (SimpleMovie movie : movies){
            for (String actor : actorActors){
                if (movie.getActors().contains(actor)) actorActorsMovies.add(movie);
            }
        }
        commonMovie = findCommonMovie(kevinBaconActorsMovies, actorActorsMovies);
        if (commonMovie != null){
            String kevinBaconActor = "";
            String actorActor = "";
            for (String actor : commonMovie.getActors()){
                if (kevinBaconActors.contains(actor)) kevinBaconActor = actor;
                if (actorActors.contains(actor)) actorActor = actor;
            }
            ArrayList<SimpleMovie> kevinBaconActorMovies = new ArrayList<SimpleMovie>();
            ArrayList<SimpleMovie> actorActorMovies = new ArrayList<SimpleMovie>();
            for (SimpleMovie movie : movies){
                if (movie.getActors().contains(kevinBaconActor)) kevinBaconActorMovies.add(movie);
                if (movie.getActors().contains(actorActor)) actorActorMovies.add(movie);
            }
            return "Bacon Number of 3: Kevin Bacon was in " + findCommonMovie(kevinBaconMovies, kevinBaconMovies) + " with " + kevinBaconActor + "who was in " + commonMovie.getTitle() + " with " + actorActor + "who was in " + findCommonMovie(actorActorMovies, actorMovies) + " with " + actor;
        }
        return "infinite.";
    }
}
