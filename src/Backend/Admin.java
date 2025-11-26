/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

public class Admin extends User{
    
    public Admin(String username, String email, String passwordHash, String role) {
        super(username, email, passwordHash, role);
    }

    
    
   public void updateCourseStatue(Course course,String statue)
   {
   JsonDatabase database=new JsonDatabase();
   ArrayList <Course> courses =(ArrayList <Course>) database.loadCourses();
   for(Course c:courses)
   {if(c.getCourseId().equals(course.getCourseId()))
       { course=c;break;}
   }
   course.setStatue(statue);
   database.saveCourses(courses);
   }
   public ArrayList<Course> loadPendingCourses()
   {JsonDatabase database=new JsonDatabase();
   ArrayList<Course> courses=(ArrayList<Course>) database.loadCourses();
   ArrayList<Course> Pendingcourses=new ArrayList<>();
   for(Course course:courses)
   {
   if(course.getStatue().equals("Pending"))
       Pendingcourses.add(course);
   }
   return Pendingcourses;
   }
    
}
