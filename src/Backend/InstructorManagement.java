/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import javax.swing.JOptionPane;


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
        ArrayList<User> users=(ArrayList<User>) database.loadUsers();
        int index =users.indexOf((User)instructor);
        users.remove(index);
        instructor.addCourse(course.getCourseId());
        users.add(instructor);
        database.saveUsers(users);
        courses.add(course);
        this.database.saveCourses(courses);

    }
        public  void deleteCourse(String idString) {
        Course course  =findCoursebyId((ArrayList<Course>) database.loadCourses(), idString);
        ArrayList<User> users=(ArrayList<User>) database.loadUsers();
        int index =users.indexOf((User)instructor);
        users.remove(index);
        instructor.removeCourse(course.getCourseId());
        users.add(instructor);
        database.saveUsers(users);
        courses.remove(course);
        this.database.saveCourses(courses);
    }
    public  ArrayList<Student> viewEnrolledStudents(Course c) {
        return c.getStudents();   
    }
    
    public void addLesson(Course course,String title, String content, String optionalResources)
    {
    Course c=findCoursebyId(courses, course.getCourseId());
        c.addLesson(title,content,optionalResources);
     database.saveCourses(courses);
    } 
    public  void editLesson(Course course,Lesson lesson,String title, String content, String optionalResources ,Instructor ins) {
        Course c=findCoursebyId(courses, course.getCourseId());
        if(c==null)
            System.out.println("course not found");
           
        Lesson l =findLessonbyId(c.getLessons(),lesson.getLessonId());
        l.setContent(content);
        l.setOptionalResources(optionalResources);
        l.setTitle(title);
        database.saveCourses(courses);
    }
    public void deleteLesson(Course course,Lesson lesson)
    {
    Course c=findCoursebyId(courses, course.getCourseId());
     if(c==null)
            System.out.println("course not found");
    ArrayList<Lesson> lessons=c.getLessons();
    Lesson l =findLessonbyId(c.getLessons(),lesson.getLessonId());
    lessons.remove(l);
   
    database.saveCourses(courses);  
    }
    public static Course findCoursebyId(ArrayList<Course> courses,String courseID)
    {
    for (Course c :courses)
    {
    if(c.getCourseId().equals(courseID))
        return c;
    }
    return null;
    }
    
        public static Lesson findLessonbyId(ArrayList<Lesson> lessons,String lessonID)
    {
    for (Lesson lesson :lessons)
    {
    if(lesson.getLessonId().equals(lessonID))
        return lesson;
    }
    return null;
    }
}