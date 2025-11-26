/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Backend.JsonDatabase;
import java.util.ArrayList;

public class StudentManagement {
    private Student student;
    private ArrayList<Course> courses;
    private JsonDatabase database ;
    
    public StudentManagement(Student student) {
        this.student = student;
        database= new JsonDatabase();
        this.courses =(ArrayList<Course>) database.loadCourses() ;
    }
    public ArrayList<Course> browsingCourses ()
    {database= new JsonDatabase();
     this.courses =(ArrayList<Course>) database.loadCourses() ;
    ArrayList<Course> availableCourses=new ArrayList<Course>() ;
   for(Course course : courses)
    {   
     int test=1;
    for(CourseProgress courseProgress : this.student.getEnrolledCourses())
    {   
      if(course.getCourseId().equals(courseProgress.getCourse()))
      {System.out.println("0");
          test=0;}
      

    }
    if(!course.getStatue().equals("Accepted"))
    {test=0;}

    if(test==1)
        availableCourses.add(course);
    
    }
    return availableCourses;
    
    }
        public ArrayList<Course> enrolledCourses ()
    {database= new JsonDatabase();
     this.courses =(ArrayList<Course>) database.loadCourses() ;
    ArrayList<Course> enrolledCourses=new ArrayList<>();
    for(CourseProgress courseProgress : this.student.getEnrolledCourses())
    {
       
       enrolledCourses.add(InstructorManagement.findCoursebyId(courses, courseProgress.getCourse()));
    }
    return enrolledCourses;
    
    }
    public  ArrayList<Lesson> viewLessons(String courseId) {
        Course course=findCoursebyId(courses, courseId);
        ArrayList<Lesson> lessons=course.getLessons();
        return lessons;
    }
    
    public void  enroll(String id)
    {  database= new JsonDatabase();
        this.courses =(ArrayList<Course>) database.loadCourses() ;
      
     Course course=findCoursebyId(courses, id);
      course.addStudent(student);
      database.saveCourses(courses);
     
        ArrayList<User> users=(ArrayList<User>) database.loadUsers();
        int index =users.indexOf((User)student);
        users.remove(index);
        student.addCourse(course.getCourseId());
        users.add(student);
        database.saveUsers(users);
    }
    public Course findCoursebyId(ArrayList<Course> courses,String courseID)
    {
    for (Course c :courses)
    {
    if(c.getCourseId().equals(courseID))
        return c;
    }
    return null;
    }
    public void MarkAsComplete(Lesson lesson, Student student, Course course,QuizAttempt quizAttempt)
    {
       ArrayList<User> users=(ArrayList<User>) database.loadUsers();
        int index =users.indexOf((User)student);
        users.remove(index);
        CourseProgress cp=null;
        for(CourseProgress c :student.getEnrolledCourses())
        {
        if(c.getCourse().equals(course.getCourseId()))
            cp=c;
        
        }
        cp.updateProgress(lesson, course,quizAttempt);
        
    users.add(student);
    if(cp.getProgress()==1)
        
    database.saveUsers(users);
    CertificateManager certificateManager=new CertificateManager(new JsonDatabase());
     certificateManager.generateCertificates(cp, student);
    
    
    }
    
    
}
