package Cine;

public class Seat {
    private char row;
    private int number;
    private boolean available;
    private boolean preferential;
    
    public Seat(char row, int number, boolean preferential) {
        this.row = row;
        this.number = number;
        this.available = true;
        this.preferential = preferential;
    }
    
    public char getRow() {
        return row;
    }
    
    public int getNumber() {
        return number;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public boolean isPreferential() {
        return preferential;
    }
}