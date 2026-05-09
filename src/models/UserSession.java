package models;

public class UserSession {
    
    private static UserSession instance = null;
    private User currentUser;
    
    private UserSession() {}
    
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    public void setLoggedInUser(User user) {
        this.currentUser = user;
    }
    
    public User getLoggedInUser() {
        return currentUser;
    }
    
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public boolean isAdmin() {
        return currentUser != null && "admin".equals(currentUser.getRole());
    }
    
    public void logout() {
        currentUser = null;
    }
}