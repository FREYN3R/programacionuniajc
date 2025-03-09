package Cine;

public class CinemaRoom {
    private int roomId;
    private Function[] functions;
    private boolean hasPreferentialSection;
    
    public CinemaRoom(int roomId, boolean hasPreferentialSection) {
        this.roomId = roomId;
        this.hasPreferentialSection = hasPreferentialSection;
        this.functions = new Function[3];  // 3 funciones por día
        
        // Inicializar funciones vacías
        for (int i = 0; i < 3; i++) {
            functions[i] = new Function(this);
        }
    }
    
    public int getRoomId() {
        return roomId;
    }
    
    public Function[] getFunctions() {
        return functions;
    }
    
    public boolean hasPreferentialSection() {
        return hasPreferentialSection;
    }
    
    public boolean assignFunction(int timeSlot, Movie movie) {
        if (timeSlot >= 0 && timeSlot < 3) {
            functions[timeSlot].setMovie(movie);
            functions[timeSlot].initializeSeats();
            return true;
        }
        return false;
    }
}