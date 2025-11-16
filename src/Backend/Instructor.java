/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author AliAl
 */
public class Instructor extends User{
 

    public Instructor( String role, String username, String email, String passwordHash) {
    super( username, email, passwordHash);
        this.role = "instructor";

    }
    
}
