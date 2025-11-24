package Frontend;

import Backend.Course;
import Backend.CourseProgress;
import Backend.Instructor;
import Backend.InstructorManagement;
import Backend.JsonDatabase;
import Backend.Lesson;
import Backend.Student;
import Backend.StudentManagement;
import java.awt.Frame;
import java.security.cert.LDAPCertStoreParameters;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmedessam
 */
public class ViewLessons extends javax.swing.JPanel {

    private Course course;
    private ArrayList<Lesson> lessons = new ArrayList<>();
    private DefaultTableModel tableModel;
    private Student student;
    private StudentManagement studentManagement;
    
    public ViewLessons(Course course,Student student) {
        this.course=course;
        this.student = student;
        this.studentManagement=new StudentManagement(student);
        initComponents();
        initTable();
        loadCoursesLessons();
    }
        private void initTable() {
        tableModel = new DefaultTableModel(new String[]{"Lesson Id", "Title", "Status"}, 0);
        jTable1.setModel(tableModel);
        
    }

            private void loadCoursesLessons() {
                     JsonDatabase database=new JsonDatabase();
            ArrayList<Course> courses=(ArrayList<Course>) database.loadCourses();
            course=InstructorManagement.findCoursebyId(courses, course.getCourseId());
            this.lessons = course.getLessons();

        tableModel.setRowCount(0);
        CourseProgress courseProgres=null;
        for(CourseProgress c: student.getEnrolledCourses())
            {  if(c.getCourse().equals(course.getCourseId()))
            { courseProgres=c; 
                break;
            }
            }
        
        boolean statue;
        for (Lesson l : this.lessons) {
            statue=false;
        for(String coml: courseProgres.getlessonsProgress())
            {  if(lessons.indexOf(l)==Integer.valueOf(coml))
            { statue=true; 
                break;
            }
            }
            tableModel.addRow(new Object[]{l.getLessonId() , l.getTitle(),statue});
        }
    }
private Lesson getlessonselected()throws NullPointerException{
    int row =jTable1.getSelectedRow();
    if(row==-1)
        return null;
    return this.lessons.get(row);

}

            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lesson ID", "Title", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Access ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("return");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton6))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Select a course first!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Lesson selectedlesson= lessons.get(selectedRow);

        JFrame frame = (JFrame) this.getTopLevelAncestor();
        frame.getContentPane().removeAll();
        frame.setContentPane(new AccessMark(selectedlesson,student,course));
        frame.revalidate();
        frame.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFrame frame = (JFrame) this.getTopLevelAncestor();
        frame.getContentPane().removeAll();
        frame.setContentPane(new StudentDashBoard(student));
        frame.revalidate();
        frame.repaint();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
