/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.Objects;



public class User {
    protected String userId;
    protected String role;
    protected String username;
    protected String email;
    protected String passwordHash;

    public User( String username, String email, String passwordHash,String role) {
        this.userId =  String.valueOf(100000 + (int) (Math.random() * 900000));
        this.role=role;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }
        public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    User user = (User) obj;
    return userId.equals(user.userId);
}

@Override
public int hashCode() {
    return Objects.hash(userId);
}


}
