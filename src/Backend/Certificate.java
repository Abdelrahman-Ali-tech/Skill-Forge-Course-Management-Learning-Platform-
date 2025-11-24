/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author ahmedessam
 */

import java.time.LocalDate;

public class Certificate {

    private String certificateId;
    private String userId;
    private String courseId;
    private String issueDate;

    // new certificate
    public Certificate(String userId, String courseId) {
        this.userId = userId;
        this.courseId = courseId;
        this.certificateId = "CERT-" + courseId + "-" + userId + "-" + System.currentTimeMillis();
        this.issueDate = LocalDate.now().toString();
    }

    // load from JSON
    public Certificate(String certificateId, String userId, String courseId, String issueDate) {
        this.certificateId = certificateId;
        this.userId = userId;
        this.courseId = courseId;
        this.issueDate = issueDate;
    }

    public String getCertificateId() { return certificateId; }
    public String getUserId() { return userId; }
    public String getCourseId() { return courseId; }
    public String getIssueDate() { return issueDate; }
}
