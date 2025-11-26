/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

// completed courses
// add certificate


public class Student extends User{

   private ArrayList <CourseProgress> enrolledCourses;
   private ArrayList <Certificate> Certificates;
   private ArrayList <String> CompletedCoursesIds;


    public Student(  String username, String email, String passwordHash,
            ArrayList <CourseProgress> enrolledCourses,ArrayList <Certificate> Certificates,ArrayList <String> CompletedCoursesIds) {
        super(username,email,passwordHash,"student");
        this.role="Student";
       if(enrolledCourses==null)
        {this.enrolledCourses=new ArrayList<>();}
        else {this.enrolledCourses=enrolledCourses;}
       if(Certificates==null)
        {this.Certificates=new ArrayList<>();}
        else {this.Certificates=Certificates;}
       if(CompletedCoursesIds==null)
        {this.CompletedCoursesIds=new ArrayList<>();}
        else {this.CompletedCoursesIds=CompletedCoursesIds;}
        
    }

    public ArrayList<CourseProgress> getEnrolledCourses() {
        return enrolledCourses;
       
    }
    public ArrayList<Certificate> getCertificates() {
        return Certificates;
       
    }
     public ArrayList<String> getCompletedCoursesIds() {
        return CompletedCoursesIds;
       
    }

    public void setEnrolledCourses(ArrayList<CourseProgress> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
    public void addCourse(String courseid) {
        CourseProgress enrolledCourse= new CourseProgress(courseid);
        this.enrolledCourses.add(enrolledCourse);
        
    }
     public void addCertificate(Certificate certificate) {
        Certificates.add(certificate);
    }

}