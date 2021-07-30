package controller;

import model.Driver;
import model.DriverStore;
import model.Location;

import java.util.logging.Logger;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class DriverController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public void addDriver(Driver driver, DriverStore driverStore) {
        driverStore.putDriver(driver.getName(), driver);
    }

    public void updateLocation(String driverName, Location location, DriverStore driverStore) {
        Driver driver = driverStore.getDriver(driverName);
        if (driver != null) {
            driver.setLocation(location);
        } else {
            logger.warning("Unknown driver.");
        }
    }

    public void changeStatus(String driverName, boolean status, DriverStore driverStore) {
        Driver driver = driverStore.getDriver(driverName);
        if (driver != null) {
            driver.setStatus(status);
        } else {
            logger.warning("Unknown driver.");
        }
    }
}
