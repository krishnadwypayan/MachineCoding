package model;

import java.util.Objects;

/**
 * Created by Krishna Kota on 11/05/21
 */
public class Vehicle {
    private String name;
    private Station station;
    private boolean isAvailable;

    public Vehicle(String name, Station station) {
        this.name = name;
        this.station = station;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public Station getStation() {
        return station;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void toggleAvailable() {
        this.isAvailable = !this.isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return name.equals(vehicle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", station=" + station +
                '}';
    }
}
