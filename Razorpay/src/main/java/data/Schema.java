package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class Schema {

    private Map<String, Datatype> map = new HashMap<>();

    public void putColumn(String name, Datatype datatype) {
        map.put(name, datatype);
    }

    public Map<String, Datatype> getMap() {
        return map;
    }
}
