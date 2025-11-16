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
public class Course {
    private String courseId;
    private String title;
    private String description;
    private String instructorId;
    private ArrayList<Lesson> lessons;
    private ArrayList<Student> students; 
  
    
    
    public Course( String title, String description, String instructorId,ArrayList<Lesson> lessons,  ArrayList<Student> students) {
        this.courseId =  String.valueOf(100000 + (int) (Math.random() * 900000));;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.lessons = lessons;
        this.students = students;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public ArrayList<Lesson> getLessons() {
        return  lessons;
    }

    public ArrayList<Student>getStudents() {
        return students;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
    
}
