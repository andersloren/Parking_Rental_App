package lexicon.data;

import lexicon.model.Customer;
import lexicon.model.ParkingSpot;

import java.util.Optional;

public interface ParkingSpotDao extends BaseDao<ParkingSpot, Integer>{

    void occupyParkingSpot(int spotNumber); // True
    void vacateParkingSpot(int spotNumber); // False
}
