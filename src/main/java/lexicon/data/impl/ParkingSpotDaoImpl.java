package lexicon.data.impl;

import lexicon.data.ParkingSpotDao;
import lexicon.model.ParkingSpot;

import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {
    //todo: implement singleton design pattern
    @Override
    public ParkingSpot create(ParkingSpot parkingSpot) {
        //todo: implement the method
        return null;
    }

    @Override
    public Optional<ParkingSpot> find(Integer integer) {
        //todo: implement the method
        return Optional.empty();
    }

    @Override
    public void occupyParkingSpot(int spotNumber) {
        //todo: implement the method

    }

    @Override
    public void vacateParkingSpot(int spotNumber) {
        //todo: implement the method
    }
}
