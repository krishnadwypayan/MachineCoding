package controller;

import model.Location;
import model.User;
import model.UserStore;

import java.util.logging.Logger;

/**
 * Created by Krishna Kota on 21/04/21
 */
public class UserController {

    private final Logger logger = Logger.getLogger(getClass().getName());

    public void addUser(User user, UserStore userStore) {
        userStore.putUser(user.getUserName(), user);
    }

    public void updateUser(String userName, long phone, UserStore userStore) {
        User user = userStore.getUser(userName);
        if (user != null) {
            user.setPhone(phone);
        } else {
            logger.warning("Unknown user.");
        }
    }

    public void updateLocation(String userName, Location location, UserStore userStore) {
        User user = userStore.getUser(userName);
        if (user != null) {
            user.setLocation(location);
        } else {
            logger.warning("Unknown user.");
        }
    }
}
