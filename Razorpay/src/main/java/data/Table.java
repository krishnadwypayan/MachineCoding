package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class Table {
    private String name;
    private Schema schema;
    private Map<String, List<Record>> map = new HashMap<>();

    public Table(String name, Schema schema) {
        this.name = name;
        this.schema = schema;
        init();
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Record>> getMap() {
        return map;
    }

    public Schema getSchema() {
        return schema;
    }

    private void init() {
        for (String column : schema.getMap().keySet()) {
            map.put(column, new ArrayList<>());
        }
    }
}
