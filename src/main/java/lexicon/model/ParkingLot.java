package lexicon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ParkingLot {

    // Fields
    private int areaCode;
    private Map<Integer, ParkingSpot> parkingSpotMap;

    // Constructor
    public ParkingLot(int areaCode, Map<Integer, ParkingSpot> parkingSpotMap) {
        this.areaCode = areaCode;
        this.parkingSpotMap = parkingSpotMap;
    }

    // Methods
    public List<ParkingSpot> getAvailableParkingSpots() {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot parkingSpot : parkingSpotMap.values())
            if (!parkingSpot.isOccupied()) availableSpots.add(parkingSpot);
        return availableSpots;
    }
    public ParkingSpot getParkingSpotBySpotNumber(int spotNumber) {
        return parkingSpotMap.get(spotNumber);
    }
    public void displayParkingSpot() {
        System.out.println("----------------------");
        int counter = 0;
        for (ParkingSpot spot : parkingSpotMap.values()) {
            counter++;
            System.out.print("| " + spot.getSpotNumber() + " " + (spot.isOccupied() ? "X" : "\u2713" ));
            System.out.print(" |");
            if (counter % 3 == 0) {
                System.out.println();
                System.out.println("----------------------");
            }
        }
        System.out.println("----------------------");
    }

    // Getters
    public int getAreaCode() {
        return areaCode;
    }

    public List<ParkingSpot> getParkingSpotMap() {
        return new ArrayList<>(parkingSpotMap.values());
    }




}
