package Cine;

public class Cinema {
    private CinemaRoom[] rooms;
    private Movie[] movies;
    private int movieCount;
    private static final int MAX_MOVIES = 12;  // Máximo número de películas en el repertorio
    
    public Cinema() {
        rooms = new CinemaRoom[3];
        
        // Inicializar las salas con sus configuraciones específicas
        rooms[0] = new CinemaRoom(1, true);   // Sala 1 con sección preferencial
        rooms[1] = new CinemaRoom(2, true);   // Sala 2 con sección preferencial
        rooms[2] = new CinemaRoom(3, false);  // Sala 3 sin sección preferencial (solo 3D)
        
        movies = new Movie[MAX_MOVIES];
        movieCount = 0;
    }
    
    public CinemaRoom getRoomById(int roomId) {
        if (roomId >= 1 && roomId <= 3) {
            return rooms[roomId - 1];
        }
        return null;
    }
    
    public Movie[] getMovies() {
        return movies;
    }
    
    public int getMovieCount() {
        return movieCount;
    }
    
    public boolean addMovie(Movie movie) {
        if (movieCount < MAX_MOVIES) {
            movies[movieCount] = movie;
            movieCount++;
            return true;
        }
        return false;
    }
    
    public boolean assignFunction(int roomId, int timeSlot, Movie movie) {
        CinemaRoom room = getRoomById(roomId);
        
        // Verificar compatibilidad de la sala con el tipo de película
        if (roomId == 3 && !movie.getType().equalsIgnoreCase("3D")) {
            return false;
        }
        
        if (roomId != 3 && movie.getType().equalsIgnoreCase("3D")) {
            return false;
        }
        
        return room.assignFunction(timeSlot, movie);
    }
}
