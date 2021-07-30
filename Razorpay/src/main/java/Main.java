import controller.DatabaseController;
import controller.TableController;
import data.Database;
import data.IntDatatype;
import data.Record;
import data.Schema;
import data.StringDatatype;
import exceptions.TableNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class Main {

    public static void main(String[] args) throws TableNotFoundException {
        DatabaseController databaseController = new DatabaseController();
        TableController tableController = new TableController();


        Database database =  databaseController.createDatabase("db");

        Schema schema = new Schema();
        schema.putColumn("A", new IntDatatype());
        schema.putColumn("B", new IntDatatype());
        schema.putColumn("C", new StringDatatype());

        tableController.createTable(database, "table1", schema);


        Map<String, Record> record1 = new HashMap<>();
        record1.put("A", new Record<Integer>(1));
        record1.put("B", new Record<Integer>(40));
        record1.put("C", new Record<String>("abc"));

        Map<String, Record> record2 = new HashMap<>();
        record2.put("A", new Record<Integer>(10));
        record2.put("B", new Record<Integer>(1000));
        record2.put("C", new Record<String>("def"));

        Map<String, Record> record3 = new HashMap<>();
        record3.put("A", new Record<Integer>(20));
        record3.put("B", new Record<Integer>(60));
        record3.put("C", new Record<String>("efg"));

        try {
            tableController.addRecord(database, "table1", record1);
            tableController.addRecord(database, "table1", record2);
            tableController.addRecord(database, "table1", record3);
        } catch (TableNotFoundException e) {
            e.printStackTrace();
        }

        tableController.printTable(database, "table1");

        tableController.updateRecordColumn(database, "table1", 1, "B", new Record<Integer>(50));
        tableController.printTable(database, "table1");

        tableController.deleteRecord(database, "table1", 2);
        tableController.printTable(database, "table1");


        Map<String, Record> record4 = new HashMap<>();
        record4.put("A", new Record<Integer>(20));
        record4.put("B", new Record<Integer>(50));
        record4.put("C", new Record<String>("efg"));
        tableController.addRecord(database, "table1", record4);

        tableController.printTable(database, "table1");
        List<List<String>> lists = tableController.filterAndPrint(database, "table1", "B", 50);
        System.out.println(lists);

    }

}
