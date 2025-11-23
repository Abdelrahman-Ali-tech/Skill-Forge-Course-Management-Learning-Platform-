/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;


public class InstructorManagement {
    private ArrayList<Course> createdcCourses;
    private ArrayList<Course> courses;
   private JsonDatabase database;
    private Instructor instructor;

    public InstructorManagement( Instructor instructor) {
        this.createdcCourses = instructor.getCreatedcCourses();
        this.database=new JsonDatabase();
        this.courses=(ArrayList<Course>) database.loadCourses();
        this.instructor = instructor;
    }
    public  void createCourse(String title, String description, Instructor instructor) {
        Course course=new Course(title, description, instructor.getUserId());
        instructor.addCourse(course);
        courses.add(course);
        this.database.saveCourses(courses);

    }
        public  void deleteCourse(String idString) {
          Course course  =findCoursebyId((ArrayList<Course>) database.loadCourses(), idString);
        
        instructor.removeCourse(course);
        courses.remove(course);
        this.database.saveCourses(courses);

    }
    public  ArrayList<Student> viewEnrolledStudents(Course c) {
        return c.getStudents();
        
    }
    
    public void addLesson(Course course,String title, String content, String optionalResources,Instructor ins)
    {
    
     course.addLesson(title,content,optionalResources);
     ArrayList<User> users =(ArrayList<User>) database.loadUsers();
     users.remove(ins);
     users.add(ins);
     database.saveUsers(users);
        Course c=findCoursebyId(courses, course.getCourseId());
        c.addLesson(title,content,optionalResources);
     database.saveCourses(courses);
    } 
    public  void editLesson(Course c,Lesson lesson,String title, String content, String optionalResources ,Instructor ins) {
        this.courses.remove(c);
        lesson.setContent(content);
        lesson.setOptionalResources(optionalResources);
        lesson.setTitle(title);
     ArrayList<User> users =(ArrayList<User>) database.loadUsers();
     users.remove(ins);
     users.add(ins);
     database.saveUsers(users);
       this.courses.add(c);

    }
    public void deleteLesson(Course c,Lesson lesson)
    {
    
    
    ArrayList<Lesson> lessons=c.getLessons();
    lessons.remove(lesson);
    c.setLessons(lessons);
    
    }
    public Course findCoursebyId(ArrayList<Course> courses,String courseID)
    {
    for (Course c :courses)
    {
    if(c.getCourseId()==courseID)
        return c;
    }
    return null;
    }
    
    
}