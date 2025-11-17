/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author AliAl
 */
public class Lesson {
     private String lessonId;        
     private String title;        
     private String content;        
     private String optionalResources[];        

    public Lesson( String title, String content, String[] optionalResources) {
        this.lessonId =  String.valueOf(100000 + (int) (Math.random() * 900000));
        this.title = title;
        this.content = content;
        this.optionalResources = optionalResources;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getOptionalResources() {
        return optionalResources;
    }

    public void setOptionalResources(String[] optionalResources) {
        this.optionalResources = optionalResources;
    }
    public void fetchtoCourse(Course course)
    {
    course.addLesson(this);
    }
    
}
