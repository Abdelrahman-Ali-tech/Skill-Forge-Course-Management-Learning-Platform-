/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author AliAl
 */
public class Instructor extends User{
 
    private ArrayList<String> createdcCourses;
    public Instructor( String role, String username, String email, String passwordHash,ArrayList<String> createdcCourses) {
    super( username, email, passwordHash,"instructor");
        this.role = "Instructor";
        if(createdcCourses==null)
        {this.createdcCourses=new ArrayList<>();}
        else {this.createdcCourses=createdcCourses;}

    }

    public ArrayList<Course> getCreatedcCourses() {
      ArrayList<Course> courses= JsonDatabase.getCoursesByIdList(this.createdcCourses);
        return courses;
    }
    public  void addCourse(String courseId) {
        this.createdcCourses.add(courseId);
        
        
    }
    public  void removeCourse(String courseId) {
        this.createdcCourses.remove( courseId);
        
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
