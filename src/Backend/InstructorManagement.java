/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Backend.CourseProgress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public void addLesson(Course course,String title, String content, String optionalResources,Quiz quiz)
    {
    Course c=findCoursebyId(courses, course.getCourseId());
        c.addLesson(title,content,optionalResources,quiz);
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
         public Map<String, Map<String, LessonAnalytics>> getCourseAnalytics() {
        Map<String, Map<String, LessonAnalytics>> analytics = new HashMap<>();

        List<User> allUsers = database.loadUsers();
        
        List<Student> allStudents = new ArrayList<>();
        for (User user : allUsers) {
            if (user instanceof Student) {
                allStudents.add((Student) user);
            }
        }

        for (Course course : instructor.getCreatedcCourses()) {
            
            Map<String, LessonAggregator> lessonAggregators = new HashMap<>();
            
            for (Lesson lesson : course.getLessons()) {
                lessonAggregators.put(lesson.getTitle(), new LessonAggregator());
            }

            for (Student student : allStudents) {
                CourseProgress studentProgress = null;
                     for(CourseProgress courseProgress:student.getEnrolledCourses())
                {if(courseProgress.getCourse().equals(course.getCourseId()))
                    studentProgress=courseProgress;}
                
            
                
                if (studentProgress != null) {
                    for (Lesson lesson : course.getLessons()) {
                        LessonAggregator aggregator = lessonAggregators.get(lesson.getTitle());
                        
                        QuizAttempt attempt = studentProgress.getAttemptForLesson(lesson.getLessonId());
                        
                        if (attempt != null) {
                            aggregator.addAttempt(attempt.getScore(), attempt.getTotal());
                        }

                        if (attempt != null && attempt.getScore() == attempt.getTotal()) {
                            aggregator.addCompletion(1);
                        } else if (attempt != null) {
                            aggregator.addCompletion(0);
                        }
                    }
                }
            }
            
            Map<String, LessonAnalytics> courseAnalytics = new HashMap<>();
            int totalEnrolledStudents = course.getStudents().size();

            for (Map.Entry<String, LessonAggregator> entry : lessonAggregators.entrySet()) {
                String lessonTitle = entry.getKey();
                LessonAggregator aggregator = entry.getValue();

                double avgScore = aggregator.calculateAverageScore();
                
                double completionPercentage = (double) aggregator.getTotalCompletions() / totalEnrolledStudents * 100.0;
                
                courseAnalytics.put(lessonTitle, new LessonAnalytics(
                    lessonTitle, 
                    avgScore, 
                    completionPercentage
                ));
            }
            analytics.put(course.getCourseId(), courseAnalytics);
        }

        return analytics;
    }



    public ArrayList<Course> getCourses() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}