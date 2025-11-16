/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author AliAl
 */
public class Instructor {
        private String userId;
    private String role;
    private String username;
    private String email;
    private String passwordHash;
   /* private String enrolledCourses;
    private String progress ; */

    public Instructor(String userId, String role, String username, String email, String passwordHash) {
        this.userId = userId;
        this.role = role;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }
    
}
