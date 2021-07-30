package service;

import exceptions.CarTypeNotFoundException;
import exceptions.StationNotFoundException;
import exceptions.VehicleNotFoundException;
import model.CarType;
import model.Station;
import model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class BookingService {

    private final CarTypeService carTypeService;
    private final StationService stationService;

    public BookingService(CarTypeService carTypeService, StationService stationService) {
        this.carTypeService = carTypeService;
        this.stationService = stationService;
    }

    public SortedSet<Vehicle> search(String name, double lat, double lng) {
        TreeSet<Vehicle> result = new TreeSet<>((a, b) -> {
            if (a.getStation().getPrice() == b.getStation().getPrice()) {
                return Double.compare(a.getStation().getLocation().getDist(lat, lng), b.getStation().getLocation().getDist(lat, lng));
            }
            return Double.compare(a.getStation().getPrice(), b.getStation().getPrice());
        });

        try {
            CarType carType = carTypeService.getCarType(name);
            for (Vehicle vehicle : carType.getVehicles()) {
                if (vehicle.getStation() != null) {
                    result.add(vehicle);
                }
            }
        } catch (CarTypeNotFoundException e) {

        }

        return result;
    }

    public Vehicle book(String carTypeName, String stationName) throws VehicleNotFoundException {
        try {
            CarType carType = carTypeService.getCarType(carTypeName);
            Station station = stationService.getStation(stationName);
            for (Vehicle vehicle : carType.getVehicles()) {
                if (vehicle.isAvailable() && vehicle.getStation().equals(station)) {
                    vehicle.toggleAvailable();
                    return vehicle;
                }
            }
        } catch (StationNotFoundException | CarTypeNotFoundException e) {

        }

        throw new VehicleNotFoundException();
    }

    public void drop(Vehicle vehicle, String stationName) {
        try {
            Station station = stationService.getStation(stationName);
            vehicle.setStation(station);
            vehicle.toggleAvailable();
        } catch (StationNotFoundException e) {

        }
    }

    public void getStationReport() {
        Map<Station, Vehicle> availableVehicles = new HashMap<>();
        Map<Station, Vehicle> bookedVehicles = new HashMap<>();

        for (CarType carType : carTypeService.getCarTypeMap().values()) {
            for (Vehicle vehicle : carType.getVehicles()) {
                if (vehicle.isAvailable()) {
                    availableVehicles.put(vehicle.getStation(), vehicle);
                } else {
                    bookedVehicles.put(vehicle.getStation(), vehicle);
                }
            }
        }

        System.out.println("The available vehicles are: \n" + availableVehicles);
        System.out.println("The booked vehicles are: \n" + bookedVehicles);
    }
}
