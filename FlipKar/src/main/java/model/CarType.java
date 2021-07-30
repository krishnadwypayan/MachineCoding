package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class CarType {

    private double charge;
    private List<Vehicle> vehicles = new ArrayList<>();

    public CarType(double charge) {
        this.charge = charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getCharge() {
        return charge;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
