package model;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class Ride {
    private Location source;
    private Location dest;

    public Ride(Location source, Location dest) {
        this.source = source;
        this.dest = dest;
    }

    public Location getSource() {
        return source;
    }

    public Location getDest() {
        return dest;
    }

    public double getFare() {
        return source.distance(dest);
    }
}
