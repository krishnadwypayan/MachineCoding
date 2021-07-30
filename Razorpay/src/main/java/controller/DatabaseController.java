package controller;

import data.Database;

/**
 * Created by Krishna Kota on 05/05/21
 */
public class DatabaseController {

    public Database createDatabase(String name) {
        return new Database(name);
    }

}
