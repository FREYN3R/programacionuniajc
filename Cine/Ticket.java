package Cine;

import java.util.Date;

public class Ticket {
    private Movie movie;
    private CinemaRoom room;
    private char row;
    private int seatNumber;
    private boolean preferential;
    private int price;
    private Date date;
    private int timeSlot;
    
    public Ticket(Movie movie, CinemaRoom room, char row, int seatNumber, 
                  boolean preferential, int price, int timeSlot) {
        this.movie = movie;
        this.room = room;
        this.row = row;
        this.seatNumber = seatNumber;
        this.preferential = preferential;
        this.price = price;
        this.date = new Date();
        this.timeSlot = timeSlot;
    }
    
    // Getters
    public Movie getMovie() {
        return movie;
    }
    
    public CinemaRoom getRoom() {
        return room;
    }
    
    public char getRow() {
        return row;
    }
    
    public int getSeatNumber() {
        return seatNumber;
    }
    
    public boolean isPreferential() {
        return preferential;
    }
    
    public int getPrice() {
        return price;
    }
    
    public Date getDate() {
        return date;
    }
    
    public int getTimeSlot() {
        return timeSlot;
    }
    
    // Get formatted seat code (e.g., A3, B8)
    public String getSeatCode() {
        return Character.toString(row) + seatNumber;
    }
    
    // Get formatted time slot string
    public String getTimeSlotString() {
        switch (timeSlot) {
            case 0: return "14:00 - 16:30";
            case 1: return "16:30 - 19:00";
            case 2: return "19:00 - 21:00";
            default: return "Horario no válido";
        }
    }
    
    // Print ticket information
    public String toString() {
        return "Película: " + movie.getName() + 
               "\nSala: " + room.getRoomId() + 
               "\nAsiento: " + getSeatCode() + 
               "\nHorario: " + getTimeSlotString() + 
               "\nPrecio: $" + price;
    }
}