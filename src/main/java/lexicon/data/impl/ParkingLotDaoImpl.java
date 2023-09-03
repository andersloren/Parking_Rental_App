package lexicon.data.impl;

import lexicon.data.ParkingLotDao;
import lexicon.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLotDaoImpl implements ParkingLotDao {
    private List<ParkingLot> parkingLots;
    private static ParkingLotDaoImpl instance;

    private ParkingLotDaoImpl() {
        parkingLots = new ArrayList<>();
    }

    public static ParkingLotDaoImpl getInstance() {
        if (instance == null) {
            instance = new ParkingLotDaoImpl();
        }
        return instance;
    }

    @Override
    public ParkingLot create(ParkingLot parkingLot) {
        if (parkingLot == null) throw new IllegalArgumentException("Customer Data is null");
        parkingLots.add(parkingLot);
        return parkingLot;
    }

    @Override
    public Optional<ParkingLot> find(Integer integer) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAreaCode() == integer) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
