/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Khaled
 */
public class JsonDatabase {

    private static final String USER_FILE = "database/users.json";
    private static final String COURSE_FILE = "database/courses.json";

    private final Gson gson;

    public JsonDatabase() {
        gson =  GsonConfig.createGson();
        createDatabaseFolder();
        createFileIfNotExists(USER_FILE, "[]");
        createFileIfNotExists(COURSE_FILE, "[]");
    }

    private void createDatabaseFolder() {
        File folder = new File("database");
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    private void createFileIfNotExists(String path, String content) {
        File file = new File(path);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)){
                writer.write(content);
            } catch (IOException e) {
            }
        }
    }

    //user
    public List loadUsers() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(USER_FILE)));
            Object[] userArray = gson.fromJson(json, User[].class);

            List list = new ArrayList();
            if (userArray != null) {
                for (int i = 0; i < userArray.length; i++) {
                    list.add(userArray[i]);
                    
                }
            }
            return list;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public void saveUsers(List users) {
        try (FileWriter writer = new FileWriter(USER_FILE)) {
            gson.toJson(users, writer);
            Component JFrame = new JFrame();
           
        } catch (IOException e) {
        }
    }

    public boolean addUser(User user) {
        List users = loadUsers();

        Iterator it = users.iterator();
        while (it.hasNext()) {
            User u = (User) it.next();
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                return false;
            }
        }
        users.add(user);
        saveUsers(users);
        return true;
    }
    
    public User findUserByEmail(String email) {
        List users = loadUsers();
        Iterator it = users.iterator();
        while (it.hasNext()) {
            User u = (User) it.next();
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }

        }
        return null;
    }

    //courses
    public List loadCourses() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(COURSE_FILE)));
            Object[] courseArray = gson.fromJson(json, Object[].class);
            List list = new ArrayList();
            if (courseArray != null) {
                for (int i = 0; i < courseArray.length; i++) {
                    list.add(courseArray[i]);
                }
            }
            return list;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    public void saveCourses(List courses) {
         try (FileWriter writer = new FileWriter(COURSE_FILE))  {
            gson.toJson(courses, writer);
        } catch (IOException e) {
        }
    }

}
