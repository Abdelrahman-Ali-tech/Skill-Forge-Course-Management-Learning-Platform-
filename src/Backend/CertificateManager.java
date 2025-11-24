
package Backend;

/**
 *
 * @author ahmedessam
 */
import java.util.ArrayList;
import java.util.List;


public class CertificateManager {

    private JsonDatabase db;

    public CertificateManager(JsonDatabase db) {
        this.db = db;
    }
   public void generateCertificates(CourseProgress cp,Student student) {
    boolean anyNew = false;
       ArrayList<User> users=(ArrayList<User>) db.loadUsers();
       users.remove(student);
    
            if (cp.getProgress() >= 1.0f) {
                String courseId = cp.getCourse();

                boolean exists = student.getCertificates().stream()
                        .anyMatch(c -> c.getCourseId().equals(courseId));

                if (!exists) {
                    Certificate cert = new Certificate(student.getUserId(), courseId);
                    student.addCertificate(cert);
                    System.out.println("Generated certificate for user " + student.getUsername() +
                                       " | courseID: " + courseId);
                    anyNew = true;
                }
            }
            else{System.out.println("Didn't completed the course!");}
  

    if (anyNew) {
        users.add(student);
        db.saveUsers(users);
    }
}

}