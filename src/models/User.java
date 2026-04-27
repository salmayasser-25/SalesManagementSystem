package models;

public class User {
    private int userId;
    private String username;
    private String password;
    private String fullname;
    private String role;
    private String email;
    private String address;
    
    public User() {}
    
    public User(String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }
    
    // Getters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullname() { return fullname; }
    public String getRole() { return role; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    
    // Setters
    public void setUserId(int userId) { this.userId = userId; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public void setRole(String role) { this.role = role; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
}