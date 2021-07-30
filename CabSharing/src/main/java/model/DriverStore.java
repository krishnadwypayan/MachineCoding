package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class DriverStore {
    private Map<String, Driver> drivers;

    public DriverStore() {
        this.drivers = new HashMap<>();
    }

    public List<Driver> getNearbyDrivers(Ride ride) {
        List<Driver> result = new ArrayList<>();
        for (Driver driver : drivers.values()) {
            if (driver.getLocation().distance(ride.getSource()) <= 5 && driver.getLocation().distance(ride.getDest()) <= 5) {
                result.add(driver);
            }
        }
        return result;
    }

    public String getEarnings() {
        StringBuilder sb = new StringBuilder();
        for (Driver driver : drivers.values()) {
            sb.append(driver.getName()).append(" earned ").append(driver.getEarning());
        }
        return sb.toString();
    }

    public Driver getDriver(String driverName) {
        return drivers.get(driverName);
    }

    public void putDriver(String driverName, Driver driver) {
        this.drivers.put(driverName, driver);
    }
}
