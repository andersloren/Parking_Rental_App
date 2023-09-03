package lexicon.data.impl;

import lexicon.data.VehicleDao;
import lexicon.model.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {

    private List<Vehicle> storage;

    //todo: implement singleton design pattern

    public VehicleDaoImpl() {
        storage = new ArrayList<>();
    }

    @Override
    public Vehicle create(Vehicle data) {
        if (data == null) throw new IllegalArgumentException("Vehicle Data is null");
        if (find(data.getLicensePlate()).isPresent())
            throw new IllegalArgumentException("License Plate is already registered");
        storage.add(data);
        return data;
    }

    @Override
    public Optional<Vehicle> find(String licensePlate) {
        for (Vehicle element : storage) {
            if (element.getLicensePlate().equals(licensePlate)) {
                return Optional.of(element);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(String licensePlate) {
        Optional<Vehicle> vehicleOptional = find(licensePlate); //If the licensePlate exist in storage, it will be returned into vehicleOptional
        if (vehicleOptional.isEmpty()) {
            return false;
        } else {
            storage.remove(vehicleOptional.get());
            return true;
        }
    }

    @Override
    public Collection<Vehicle> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void update(Vehicle toUpdate) {
        if (toUpdate == null) throw new IllegalArgumentException("Vehicle Data is null");
        Optional<Vehicle> existingVehicleOptional = find(toUpdate.getLicensePlate()); //checks if licensePlate of toUpdate exists, if so, return existing car to existingVehicleOptional
        if (existingVehicleOptional.isEmpty()) throw new IllegalArgumentException("License Plate not found");
//        Vehicle originalData = existingVehicleOptional.get();
//        int index = storage.indexOf(originalData);
        int index = storage.indexOf(existingVehicleOptional.get()); //returns position of existingVehicleOptional
        if (index == -1) throw new IllegalArgumentException("Existing vehicle not found in the storage"); //if position is -1, existingVehicleOptional doesn't exist
        storage.set(index, toUpdate); // replace existingVehicleUpdate with toUpdate
    }
}
