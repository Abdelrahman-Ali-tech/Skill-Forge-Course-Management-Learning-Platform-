/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frontend;

import Backend.Course;
import Backend.Instructor;
import Backend.InstructorManagement;
import Backend.JsonDatabase;
import Backend.Lesson;
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
public class ManageLessons extends javax.swing.JPanel {

    private Course course;
    private JsonDatabase database;
    private ArrayList<Lesson> lessons = new ArrayList<>();
    private DefaultTableModel tableModel;
    private Instructor ins;
    
    public ManageLessons(Course course,Instructor ins) {
        this.course=course;
        this.ins=ins;
        initComponents();
        initTable();
    }
        private void initTable() {
        tableModel = new DefaultTableModel(new String[]{"Lesson Id", "Title", "Status"}, 0);
        jTable1.setModel(tableModel);
    }

            private void loadCoursesLessons() {
        this.lessons = course.getLessons();

        tableModel.setRowCount(0);
        for (Lesson l : this.lessons) {
            tableModel.addRow(new Object[]{l.getLessonId() , l.getTitle(), l.isStatue()});
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        jButton1.setText("Add Lesson");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit Lesson");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete Lesson");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("return");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton6))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Lesson lesson=getlessonselected();
    if(lesson==null)
    {JOptionPane.showMessageDialog(this, "Select a lesson first");return;}
    lessons.remove(lesson);
    course.setLessons(lessons);
    loadCoursesLessons();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          String title;
 String content ;
 String optionalResources;
 InstructorManagement insmg =new InstructorManagement(ins);
 
        
        Lesson lesson=getlessonselected();
    if(lesson==null)
    {JOptionPane.showMessageDialog(this, "Select a lesson first");return;}
    AddLesson Dialog =new AddLesson((JFrame) this.getTopLevelAncestor(), true, this.course);
    if(Dialog.isFinished())
    {title=Dialog.getTitle();
    content=Dialog.getContent();
    optionalResources=Dialog.getOptionalResources();
    insmg.editLesson(course,lesson, title, content, optionalResources, ins);
    JOptionPane.showMessageDialog(this, "Successfilly Added");
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                  String title;
 String content ;
 String optionalResources;
 InstructorManagement insmg =new InstructorManagement(ins);
 
        
        Lesson lesson=getlessonselected();
    if(lesson==null)
    {JOptionPane.showMessageDialog(this, "Select a lesson first");return;}
    AddLesson Dialog =new AddLesson((JFrame) this.getTopLevelAncestor(), true, this.course);
    if(Dialog.isFinished())
    {title=Dialog.getTitle();
    content=Dialog.getContent();
    optionalResources=Dialog.getOptionalResources();
    insmg.addLesson(course, title, content, optionalResources, ins);
    JOptionPane.showMessageDialog(this, "Successfilly Added");
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFrame frame = (JFrame) this.getTopLevelAncestor();
        frame.getContentPane().removeAll();
        frame.add(new InstructorDashBoard());
        frame.revalidate();
        frame.repaint();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}



