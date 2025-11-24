/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    
    /**
     *
     * @return
     */
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
                CourseProgress studentProgress = student.getCourseProgress(course.getCourseId());
                
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

    public Map<String, Map<String, LessonAnalytics>> getCourseAnalytics() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Course> getCourses() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}