/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Authentication {
    private ArrayList<User> users;
    private JsonDatabase database;
    public Authentication() {
       database=new JsonDatabase();
       users=(ArrayList<User>) database.loadUsers();
    }

    public static String hashing(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder hashPassword = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hashPassword.append('0');
                }
                hashPassword.append(hex);
            }
            return hashPassword.toString();
        } catch (NoSuchAlgorithmException e) {

            System.out.println(e);
            return null;
        }

    }
    public User signIn (String email, String password)
    { try{
        User user =this.database.findUserByEmail(email);
        String hashPassword=hashing(password);
                System.out.println("signin checker");
        if(hashPassword.equals(user.getPasswordHash()))
            return user;
        else return null;
    }
    catch (NullPointerException e)
    {
        return null;
    }}


    public String signUp(String username,String email,String passwordHash,String role)
{
if (!email.toLowerCase().endsWith("@gmail.com")&& !email.toLowerCase().endsWith("@outlook.com")&& !email.toLowerCase().endsWith("@yahoo.com"))
     return "wrong Email format";
if(role.equals("Student"))
{Student student=new Student(username, email, hashing(passwordHash),null,null,null);
  this.database.addUser(student);}
 else
{Instructor instructor=new Instructor(role,username, email, hashing(passwordHash),null);
  this.database.addUser(instructor);}

return "Successfully Added";
}



}
