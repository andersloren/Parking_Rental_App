package lexicon.model;

public class Vehicle {

    // Fields
    private final String licensePlate;
    private final VehicleType type;

    // Constructor
    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    // Methods
    public String vehicleInfo() {
        return "Vehicle: Licenceplate:" + licensePlate + ", Type: " + type;
    }

    // Getters
    public String getLicensePlate() {
        return licensePlate;
    }
    public VehicleType getType() {
        return type;
    }

    // ToString
    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type=" + type +
                '}';
    }
}
