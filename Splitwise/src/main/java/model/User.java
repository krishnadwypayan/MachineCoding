package model;

/**
 * Created by Krishna Kota on 29/05/21
 */
public class User {
    private final String emailId;
    private UserMetadata userMetadata;

    public User(String emailId) {
        this.emailId = emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public UserMetadata getUserMetadata() {
        return userMetadata;
    }

    public void setUserMetadata(UserMetadata userMetadata) {
        this.userMetadata = userMetadata;
    }
}
