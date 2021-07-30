package controller;

import model.Driver;
import model.DriverStore;
import model.Ride;
import model.User;
import model.UserStore;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class RideController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public List<Driver> findRide(String userName, Ride ride, DriverStore driverStore) {
        return driverStore.getNearbyDrivers(ride);
    }

    public String chooseRide(String userName, String driverName, Ride ride, UserStore userStore, DriverStore driverStore) {
        User user = userStore.getUser(userName);
        Driver driver = driverStore.getDriver(driverName);
        if (user != null && driver != null) {
            user.addRide(ride);
            driver.updateEarning(ride.getFare());
            return "ride Started";
        } else {
            logger.warning("Unknown user.");
            return "Unknown user.";
        }
    }

    public String calculateBill(String userName, UserStore userStore) {
        User user = userStore.getUser(userName);
        if (user != null) {
            return "Ride ended. Bill amount: " + user.calculateBill();
        } else {
            logger.warning("Unknown user.");
            return "Unknown user.";
        }
    }

    public String findTotalEarning(DriverStore driverStore) {
        return driverStore.getEarnings();
    }
}
