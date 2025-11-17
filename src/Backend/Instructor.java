/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author AliAl
 */
public class Instructor extends User{
 
    private ArrayList<Course> createdcCourses;
    public Instructor( String role, String username, String email, String passwordHash,ArrayList<Course> createdcCourses) {
    super( username, email, passwordHash);
        this.role = "instructor";
        this.createdcCourses=createdcCourses;

    }

    public ArrayList<Course> getCreatedcCourses() {
        return createdcCourses;
    }
    public  void addCourse(Course course) {
        this.createdcCourses.add(course);
        
        
    }
    
}
