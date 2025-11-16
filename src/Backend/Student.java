/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;


public class Student extends User{

   private ArrayList <CourseProgress> enrolledCourses;


    public Student(String userId, String role, String username, String email, String passwordHash,ArrayList <CourseProgress> enrolledCourses) {
        super(userId,role,username,email,passwordHash);
        this.enrolledCourses=enrolledCourses;
        
    }
    
}
