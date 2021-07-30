package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class Database {
    private String name;
    private Map<String, Table> tables = new HashMap<>();

    public Database(String name) {
        this.name = name;
    }

    public void addTable(Table table) {
        tables.put(table.getName(), table);
    }

    public Map<String, Table> getTables() {
        return tables;
    }
}
