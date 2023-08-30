package lexicon.model;

public class ParkingSpot {

    // Fields
    private int spotNumber;
    private boolean isOccupied;

    // Constructor
    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public ParkingSpot(int spotNumber, boolean isOccupied) {
        this.spotNumber = spotNumber;
        this.isOccupied = isOccupied;
    }
    // Methods
    public void occupy() {
        this.isOccupied = true;
    }

    public void vacate() {
        this.isOccupied = false;
    }

    // Getters
    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    // ToString

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", isOccupied=" + isOccupied +
                '}';
    }

}
