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
    private String statue;
  
    
    
    public Course( String title, String description, String instructorId,ArrayList<Lesson> lessons,  ArrayList<Student> students,String statue) {
        this.courseId =  String.valueOf(100000 + (int) (Math.random() * 900000));
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.lessons = lessons;
        this.students = students;
        this.statue=statue;
    }
    public Course( String title, String description, String instructorId) {
        this.courseId =  String.valueOf(100000 + (int) (Math.random() * 900000));
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.lessons = new ArrayList<Lesson>();
        this.students = new ArrayList<Student>();
        this.statue="Pending";
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

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
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
        public void addLesson(String title, String content, String optionalResources,Quiz quiz) {
        Lesson lesson =new Lesson(title, content, optionalResources);
        lesson.setQuiz(quiz);
System.out.println("Questions: " + quiz.getQuestions());
System.out.println("Options: " + quiz.getOptions());
System.out.println("Correct: " + quiz.getCorrectIndex());
System.out.println("Questions: " + lesson.getQuiz().getQuestions());
System.out.println("Options: " + lesson.getQuiz().getOptions());
System.out.println("Correct: " + lesson.getQuiz().getCorrectIndex());


        this.lessons.add(lesson);
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Course course = (Course) obj;
    return courseId.equals(course.courseId);
}

@Override
public int hashCode() {
    return courseId.hashCode();
}

}
