package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class UserStore {
    private Map<String, User> users;

    public UserStore() {
        this.users = new HashMap<>();
    }

    public User getUser(String userName) {
        return users.get(userName);
    }

    public void putUser(String userName, User user) {
        this.users.put(userName, user);
    }
}
