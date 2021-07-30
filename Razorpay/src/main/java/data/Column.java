package data;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class Column {
    private String name;
    private Datatype datatype;

    public Column(String name, Datatype datatype) {
        this.name = name;
        this.datatype = datatype;
    }

    public String getName() {
        return name;
    }

    public Datatype getDatatype() {
        return datatype;
    }
}
