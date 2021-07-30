package service;

import exceptions.StationNotFoundException;
import model.Location;
import model.Station;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class StationService {

    private Map<String, Station> stationMap = new HashMap<>();

    public Station createStation(String name, double lat, double lng, double price) {
        if (stationMap.containsKey(name)) {
            return stationMap.get(name);
        }

        Station station = new Station(name, new Location(lat, lng), price);
        stationMap.put(name, station);
        return station;
    }

    public Station getStation(String name) throws StationNotFoundException {
        if (!stationMap.containsKey(name)) {
            throw new StationNotFoundException();
        }
        return stationMap.get(name);
    }

}
