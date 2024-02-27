import java.util.*;

class Movie {
    private String title;
    private List<String> genres;
    private String rating;
    private List<String> actors;
    private String music;
    private int length;

    public Movie(String title, List<String> genres, String rating, List<String> actors, String music, int length) {
        this.title = title;
        this.genres = genres;
        this.rating = rating;
        this.actors = actors;
        this.music = music;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getRating() {
        return rating;
    }

    public List<String> getActors() {
        return actors;
    }

    public String getMusic() {
        return music;
    }

    public int getLength() {
        return length;
    }
}

class User {
    private List<String> interests;
    private String preferredRating;
    private List<String> preferredActors;
    private String preferredMusic;
    private int preferredLength;

    public User(List<String> interests, String preferredRating, List<String> preferredActors, String preferredMusic, int preferredLength) {
        this.interests = interests;
        this.preferredRating = preferredRating;
        this.preferredActors = preferredActors;
        this.preferredMusic = preferredMusic;
        this.preferredLength = preferredLength;
    }

    public List<String> getInterests() {
        return interests;
    }

    public String getPreferredRating() {
        return preferredRating;
    }

    public List<String> getPreferredActors() {
        return preferredActors;
    }

    public String getPreferredMusic() {
        return preferredMusic;
    }

    public int getPreferredLength() {
        return preferredLength;
    }
}

class MovieRecommendationSystem {
    private List<Movie> movies;

    public MovieRecommendationSystem(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> recommendMovies(User user) {
        List<Movie> recommendedMovies = new ArrayList<>();
        Set<String> userInterests = new HashSet<>(user.getInterests());
        String userRating = user.getPreferredRating();
        Set<String> userActors = new HashSet<>(user.getPreferredActors());
        String userMusic = user.getPreferredMusic();
        int userLength = user.getPreferredLength();

        for (Movie movie : movies) {
            Set<String> movieGenres = new HashSet<>(movie.getGenres());
            Set<String> movieActors = new HashSet<>(movie.getActors());

            if (userInterests.containsAll(movieGenres) &&
                    userRating.equals(movie.getRating()) &&
                    userActors.containsAll(movieActors) &&
                    userMusic.equals(movie.getMusic()) &&
                    userLength == movie.getLength()) {
                recommendedMovies.add(movie);
            }
        }

        return recommendedMovies;
    }

}

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", Arrays.asList("Drama"), "R", Arrays.asList("Tim Robbins", "Morgan Freeman"), "Thomas Newman", 142));
        movies.add(new Movie("The Godfather", Arrays.asList("Drama", "Crime"), "R", Arrays.asList("Al Pacino", "Diane Keaton"), "Nino Rota", 120));
        movies.add(new Movie("Inception", Arrays.asList("Action", "Adventure", "Sci-Fi"), "PG-13", Arrays.asList("Leonardo DiCaprio", "Ken Watanabe"), "Hans Zimmer", 148));
        movies.add(new Movie("Pulp Fiction", Arrays.asList("Crime", "Drama"), "R", Arrays.asList("John Travolta", "Samuel L Jackson"), "N/A", 154));
        movies.add(new Movie("The Heffalump Movie", Arrays.asList("Animated", "Adventure"), "G", Arrays.asList("Jim Cummings", "John Fielder"), "Joel Mcneely", 68));
        movies.add(new Movie("Robin Hood", Arrays.asList("Animated", "Adventure"), "G", Arrays.asList("Pete Ustinov", "Phil Harris"), "George Bruns", 83));
        movies.add(new Movie("Beauty and the Beast", Arrays.asList("Adventure", "Fantasy"), "G", Arrays.asList("Paige O'Hara", "Robby Benson"), "Alan Menken", 84));
        movies.add(new Movie("The Hobbit: An Unexpected Journey", Arrays.asList("Adventure", "Fantasy"), "PG-13", Arrays.asList("Ian Mckellen", "Martin Freeman"), "Howard Shore", 169));
        movies.add(new Movie("The Hobbit: The Desolation of Smaug", Arrays.asList("Adventure", "Fantasy"), "PG-13", Arrays.asList("Benedict Cumberbatch", "Luke Evans"), "Howard Shore", 161));
        movies.add(new Movie("The Hobbit: The Battle of the Five Armies", Arrays.asList("Adventure", "Fantasy"), "PG-13", Arrays.asList("Orlando Bloom", "Martin Freeman"), "Howard Shore", 144));
        movies.add(new Movie("The Count of Monte Cristo", Arrays.asList("Adventure", "Animation"), "PG-13", Arrays.asList("Jim Caviezel", "Guy Pearce"), "Edward Shearmur", 131));
        movies.add(new Movie("Frequency", Arrays.asList("Crime", "Mystery"), "PG-13", Arrays.asList("Dennis Quaid", "Jim Caviezel"), "Michael Kamen", 118));
        movies.add(new Movie("Field of Dreams", Arrays.asList("Drama"), "PG", Arrays.asList("Kevin Costner", "Rey Liotta"), "James Horner", 107));
        movies.add(new Movie("Toy Story", Arrays.asList("Animation", "Action", "Comedy"), "G", Arrays.asList("Tom Hanks", "Tim Allen"), "Randy Newman", 81));
        movies.add(new Movie("Frozen", Arrays.asList("Animated"), "PG", Arrays.asList("Kristen Bell", "Idina Menzel"), "Christophe Beck", 102));
        movies.add(new Movie("The Incredibles", Arrays.asList("Adventure", "Animation", "Action"), "PG", Arrays.asList("Brad Bird", "Craig T Nelson"), "Michael Giacchino", 115));
        movies.add(new Movie("Up", Arrays.asList("Adventure", "Animation", "Action"), "PG", Arrays.asList("Ed Asner", "Christopher Plumer"), "Michael Giacchino", 96));
        movies.add(new Movie("Coco", Arrays.asList("Animation", "Adventure", "Family"), "PG", Arrays.asList("Anthony Gonzalez", "Gael García Bernal"), "Michael Giacchino[", 105));
        movies.add(new Movie("Moana", Arrays.asList("Animation", "Action", "Comedy", "Musical"), "PG", Arrays.asList("Auliʻi Cravalho", "Dwayne Johnson"), "Lin-Manuel Miranda", 107));
        movies.add(new Movie("How to Train Your Dragon", Arrays.asList("Adventure", "Animation", "Action"), "PG", Arrays.asList("Gerard Butler", "America Ferrera"), "John Powell", 98));
        movies.add(new Movie("Zootopia", Arrays.asList("Animation", "Adventure", "Comedy"), "PG", Arrays.asList("Ginnifer Goodwin", "Idris Elba"), "Michael Giacchino", 108));
        movies.add(new Movie("Titanic", Arrays.asList("Drama", "Romance"), "PG-13", Arrays.asList("Leonardo DiCaprio", "Kate Winslet"), "James Horner", 195));
        movies.add(new Movie("Forrest Gump", Arrays.asList("Drama", "Romance"), "PG-13", Arrays.asList("Tom Hanks", "Robin Wright"), "Alan Silvestri", 142));
        movies.add(new Movie("The Dark Knight", Arrays.asList("Action", "Crime", "Drama"), "PG-13", Arrays.asList("Christian Bale", "Heath Ledger"), "Hans Zimmer", 152));
        movies.add(new Movie("Pulp Fiction", Arrays.asList("Crime", "Drama"), "R", Arrays.asList("John Travolta", "Uma Thurman"), "Various Artists", 154));
        movies.add(new Movie("The Matrix", Arrays.asList("Action", "Sci-Fi"), "R", Arrays.asList("Keanu Reeves", "Laurence Fishburne"), "Don Davis", 136)); 
        movies.add(new Movie("Gladiator", Arrays.asList("Action", "Adventure", "Drama"), "R", Arrays.asList("Russell Crowe", "Joaquin Phoenix"), "Hans Zimmer", 155));
        movies.add(new Movie("Jurassic Park", Arrays.asList("Action", "Adventure", "Sci-Fi"), "PG-13", Arrays.asList("Sam Neill", "Laura Dern"), "John Williams", 127));
        movies.add(new Movie("The Silence of the Lambs", Arrays.asList("Crime", "Drama", "Thriller"), "R", Arrays.asList("Jodie Foster", "Anthony Hopkins"), "Howard Shore", 118));
        movies.add(new Movie("The Green Mile", Arrays.asList("Crime", "Drama", "Fantasy"), "R", Arrays.asList("Tom Hanks", "Michael Clarke Duncan"), "Thomas Newman", 189));
        movies.add(new Movie("Braveheart", Arrays.asList("Biography", "Drama", "History"), "R", Arrays.asList("Mel Gibson", "Sophie Marceau"), "James Horner", 178));
        movies.add(new Movie("The Departed", Arrays.asList("Crime", "Drama", "Thriller"), "R", Arrays.asList("Leonardo DiCaprio", "Matt Damon"), "Howard Shore", 151));
        movies.add(new Movie("The Prestige", Arrays.asList("Drama", "Mystery", "Sci-Fi"), "PG-13", Arrays.asList("Christian Bale", "Hugh Jackman"), "David Julyan", 130));
        movies.add(new Movie("The Godfather: Part II", Arrays.asList("Crime", "Drama"), "R", Arrays.asList("Al Pacino", "Robert De Niro"), "Nino Rota", 202));
        movies.add(new Movie("Goodfellas", Arrays.asList("Biography", "Crime", "Drama"), "R", Arrays.asList("Robert De Niro", "Ray Liotta"), "Various Artists", 146));
        movies.add(new Movie("Fight Club", Arrays.asList("Drama"), "R", Arrays.asList("Brad Pitt", "Edward Norton"), "The Dust Brothers", 139));
        movies.add(new Movie("The Lord of the Rings: The Fellowship of the Ring", Arrays.asList("Action", "Adventure", "Drama"), "PG-13", Arrays.asList("Elijah Wood", "Ian McKellen"), "Howard Shore", 178));
        movies.add(new Movie("The Lord of the Rings: The Two Towers", Arrays.asList("Action", "Adventure", "Drama"), "PG-13", Arrays.asList("Elijah Wood", "Viggo Mortensen"), "Howard Shore", 179));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", Arrays.asList("Action", "Adventure", "Drama"), "PG-13", Arrays.asList("Elijah Wood", "Ian McKellen"), "Howard Shore", 201));
        movies.add(new Movie("The Sixth Sense", Arrays.asList("Drama", "Mystery", "Thriller"), "PG-13", Arrays.asList("Bruce Willis", "Haley Joel Osment"), "James Newton Howard", 107));
        movies.add(new Movie("Saving Private Ryan", Arrays.asList("Drama", "War"), "R", Arrays.asList("Tom Hanks", "Matt Damon"), "John Williams", 169));
        movies.add(new Movie("Spirited Away", Arrays.asList("Animation", "Adventure", "Family"), "PG", Arrays.asList("Daveigh Chase", "Suzanne Pleshette"), "Joe Hisaishi", 125));
        movies.add(new Movie("Finding Nemo", Arrays.asList("Animation", "Adventure", "Comedy"), "G", Arrays.asList("Albert Brooks", "Ellen DeGeneres"), "Thomas Newman", 100));
        movies.add(new Movie("The Lion King", Arrays.asList("Animation", "Adventure", "Drama"), "G", Arrays.asList("Matthew Broderick", "Jeremy Irons"), "Hans Zimmer", 88));
        movies.add(new Movie("Frozen", Arrays.asList("Animation", "Adventure", "Comedy"), "PG", Arrays.asList("Kristen Bell", "Idina Menzel"), "Christophe Beck", 102));
        movies.add(new Movie("Moana", Arrays.asList("Animation", "Adventure", "Comedy"), "PG", Arrays.asList("Auli'i Cravalho", "Dwayne Johnson"), "Mark Mancina", 107));
        movies.add(new Movie("Shrek", Arrays.asList("Animation", "Adventure", "Comedy"), "PG", Arrays.asList("Mike Myers", "Eddie Murphy"), "Harry Gregson-Williams", 90));
        movies.add(new Movie("The Incredibles", Arrays.asList("Animation", "Action", "Adventure"), "PG", Arrays.asList("Craig T. Nelson", "Holly Hunter"), "Michael Giacchino", 115));
        movies.add(new Movie("Despicable Me", Arrays.asList("Animation", "Adventure", "Comedy"), "PG", Arrays.asList("Steve Carell", "Jason Segel"), "Heitor Pereira", 95));
        movies.add(new Movie("Big Hero 6", Arrays.asList("Animation", "Action", "Adventure"), "PG", Arrays.asList("Ryan Potter", "Scott Adsit"), "Henry Jackman", 102));
        movies.add(new Movie("Ratatouille", Arrays.asList("Animation", "Adventure", "Comedy"), "G", Arrays.asList("Patton Oswalt", "Ian Holm"), "Michael Giacchino", 111));
        movies.add(new Movie("WALL-E", Arrays.asList("Animation", "Adventure", "Family"), "G", Arrays.asList("Ben Burtt", "Elissa Knight"), "Thomas Newman", 98));
        movies.add(new Movie("Kung Fu Panda", Arrays.asList("Animation", "Action", "Adventure"), "PG", Arrays.asList("Jack Black", "Dustin Hoffman"), "Hans Zimmer", 92));
        movies.add(new Movie("Tangled", Arrays.asList("Animation", "Adventure", "Comedy"), "PG", Arrays.asList("Mandy Moore", "Zachary Levi"), "Alan Menken", 100));
        movies.add(new Movie("The Little Mermaid", Arrays.asList("Animation", "Family", "Fantasy"), "G", Arrays.asList("Jodi Benson", "Samuel E. Wright"), "Alan Menken", 83));
        movies.add(new Movie("Aladdin", Arrays.asList("Animation", "Adventure", "Comedy"), "G", Arrays.asList("Scott Weinger", "Robin Williams"), "Alan Menken", 90));
        movies.add(new Movie("The Nightmare Before Christmas", Arrays.asList("Animation", "Family", "Fantasy"), "PG", Arrays.asList("Danny Elfman", "Chris Sarandon"), "Danny Elfman", 76));
        movies.add(new Movie("Cinderella", Arrays.asList("Animation", "Family", "Fantasy"), "G", Arrays.asList("Ilene Woods", "James MacDonald"), "Paul Smith", 74));
        

        Scanner scanner = new Scanner(System.in);

        // Display the menu options
        System.out.println("Select an option:");
        System.out.println("1. Genre");
        System.out.println("2. Rating");
        System.out.println("3. Duration");
        System.out.println("4. Composer");
        System.out.println("5. Actors");
        System.out.println("0. Exit");

        // Prompt user for input
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You selected Genre.");
                // Prompt user to input preferred genres
                System.out.println("Enter your preferred genres (separated by commas):");
                scanner.nextLine(); // Consume the newline character
                String genresInput = scanner.nextLine();
                List<String> userGenres = Arrays.asList(genresInput.split("\\s*,\\s*"));
            
                // Filter movies based on user's preferred genres
                List<Movie> genreFilteredMovies = new ArrayList<>();
                for (Movie movie : movies) {
                    if (movie.getGenres().stream().anyMatch(userGenres::contains)) {
                        genreFilteredMovies.add(movie);
                    }
                }
            
                // Display recommended movies based on genre filtering
                if (genreFilteredMovies.isEmpty()) {
                    System.out.println("No movies found matching your preferred genres.");
                } else {
                    System.out.println("Recommended movies based on genre:");
                    for (Movie movie : genreFilteredMovies) {
                        System.out.println(movie.getTitle());
                    }
                }
                break;
            case 2:
                System.out.println("You selected Rating.");
                // Prompt user to input preferred rating
                System.out.println("Enter your preferred rating:");
                scanner.nextLine(); // Consume the newline character
                String userRating = scanner.nextLine();
            
                // Filter movies based on user's preferred rating
                List<Movie> ratingFilteredMovies = new ArrayList<>();
                for (Movie movie : movies) {
                    if (movie.getRating().equalsIgnoreCase(userRating)) {
                        ratingFilteredMovies.add(movie);
                    }
                }
            
                // Display recommended movies based on rating filtering
                if (ratingFilteredMovies.isEmpty()) {
                    System.out.println("No movies found matching your preferred rating.");
                } else {
                    System.out.println("Recommended movies based on rating:");
                    for (Movie movie : ratingFilteredMovies) {
                        System.out.println(movie.getTitle());
                    }
                }
                break;
            case 3:
                System.out.println("You selected Duration.");
                // Prompt user to input preferred duration
                System.out.println("Enter your preferred duration (in minutes):");
                int userDuration = scanner.nextInt();
            
                // Filter movies based on user's preferred duration
                List<Movie> durationFilteredMovies = new ArrayList<>();
                for (Movie movie : movies) {
                    if (movie.getLength() <= userDuration) {
                        durationFilteredMovies.add(movie);
                    }
                }
            
                // Display recommended movies based on duration filtering
                if (durationFilteredMovies.isEmpty()) {
                    System.out.println("No movies found within your preferred duration.");
                } else {
                    System.out.println("Recommended movies based on duration:");
                    for (Movie movie : durationFilteredMovies) {
                        System.out.println(movie.getTitle());
                    }
                }
                break;
            case 4:
                System.out.println("You selected Composer.");
                // Prompt user to input preferred music
                System.out.println("Enter your preferred composer:");
                scanner.nextLine(); // Consume the newline character
                String userMusic = scanner.nextLine();
            
                // Filter movies based on user's preferred music
                List<Movie> musicFilteredMovies = new ArrayList<>();
                for (Movie movie : movies) {
                    if (movie.getMusic().equalsIgnoreCase(userMusic)) {
                        musicFilteredMovies.add(movie);
                    }
                }
            
                // Display recommended movies based on music filtering
                if (musicFilteredMovies.isEmpty()) {
                    System.out.println("No movies found matching your preferred composer.");
                } else {
                    System.out.println("Recommended movies based on composer:");
                    for (Movie movie : musicFilteredMovies) {
                        System.out.println(movie.getTitle());
                    }
                }
                break;
            case 5:
                System.out.println("You selected Actors.");
                // Prompt user to input preferred actors
                System.out.println("Enter your preferred actors (separated by commas):");
                scanner.nextLine(); // Consume the newline character
                String actorsInput = scanner.nextLine();
                List<String> userActors = Arrays.asList(actorsInput.split("\\s*,\\s*"));
            
                // Filter movies based on user's preferred actors
                List<Movie> actorsFilteredMovies = new ArrayList<>();
                for (Movie movie : movies) {
                    if (movie.getActors().stream().anyMatch(userActors::contains)) {
                        actorsFilteredMovies.add(movie);
                    }
                }
            
                // Display recommended movies based on actor filtering
                if (actorsFilteredMovies.isEmpty()) {
                    System.out.println("No movies found featuring your preferred actors.");
                } else {
                    System.out.println("Recommended movies featuring preferred actors:");
                    for (Movie movie : actorsFilteredMovies) {
                        System.out.println(movie.getTitle());
                    }
                }
                break;
            case 0:
                System.out.println("Exiting the program.");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }

        scanner.close();
    }
}
