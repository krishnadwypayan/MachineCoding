package model;


/**
 * Created by Krishna Kota on 11/05/21
 */
public class Station {

    private String name;
    private Location location;
    private double price;

    public Station(String name, Location location, double price) {
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", price=" + price +
                '}';
    }
}
