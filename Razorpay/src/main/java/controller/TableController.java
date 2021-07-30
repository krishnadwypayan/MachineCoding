package controller;

import data.Database;
import data.Record;
import data.Schema;
import data.Table;
import exceptions.TableNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class TableController {

    public Table createTable(Database database, String name, Schema schema) {
        Table table = new Table(name, schema);
        database.addTable(table);
        return table;
    }

    public void addRecord(Database database, String tableName, Map<String, Record> records) throws TableNotFoundException {
        if (!database.getTables().containsKey(tableName)) {
            throw new TableNotFoundException();
        }

        Table table = database.getTables().get(tableName);
        for (String columnName : records.keySet()) {
            List<Record> recordList = table.getMap().get(columnName);
            recordList.add(records.get(columnName));
//            table.getMap().put(columnName, recordList);
        }
    }

    public void updateRecordColumn(Database database, String tableName, int primaryKey, String colName, Record record) throws TableNotFoundException {
        if (!database.getTables().containsKey(tableName)) {
            throw new TableNotFoundException();
        }

        Table table = database.getTables().get(tableName);
        table.getMap().get(colName).set(primaryKey-1, record);
    }

    public void deleteRecord(Database database, String tableName, int primaryKey) throws TableNotFoundException {
        if (!database.getTables().containsKey(tableName)) {
            throw new TableNotFoundException();
        }

        Table table = database.getTables().get(tableName);
        for (String column : table.getMap().keySet()) {
            table.getMap().get(column).remove(primaryKey);
        }
    }

    public List<List<String>> filterAndPrint(Database database, String tableName, String columnName, int val) throws TableNotFoundException {
        if (!database.getTables().containsKey(tableName)) {
            throw new TableNotFoundException();
        }

        Table table = database.getTables().get(tableName);
        List<Integer> indices = new ArrayList<>();
        List<Record> records = table.getMap().get(columnName);
        for (int i = 0; i < records.size(); i++) {
            if ((Integer) records.get(i).getVal() == val) {
                indices.add(i);
            }
        }

        List<List<String>> result = new ArrayList<>();
        int i = 0;
        for (int idx : indices) {
            result.add(new ArrayList<>());
            for (String col : table.getMap().keySet()) {
                result.get(i).add(table.getMap().get(col).get(idx).toString());
            }
            i++;
        }
        return result;
    }

    public void printTable(Database database, String tableName) throws TableNotFoundException {
        if (!database.getTables().containsKey(tableName)) {
            throw new TableNotFoundException();
        }

        Table table = database.getTables().get(tableName);
        System.out.println(table.getMap());


//        List<List<String>> list = new ArrayList<>();
//
//        int rows = 0;
//        for (String column : table.getMap().keySet()) {
//            rows = table.getMap().get(column).size();
//            break;
//        }
//
//        for (int i = 0; i < rows; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        int i = 0;
//        for (String column : table.getMap().keySet()) {
//
//            List<Record> records = table.getMap().get(column);
//            for (Record record : records) {
//                for (i = 0; i < rows; i++) {
//                    list.get(i).add(record.getVal().toString());
//                }
//            }
//        }

//        System.out.println(list);
    }
}
