/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

import Backend.Course;
import Backend.Instructor;
import Backend.InstructorManagement;
import Backend.LessonAnalytics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Map;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Khaled
 */
public class ChartFrame extends JFrame{
    private Instructor instructor;
    private InstructorManagement management;

    public ChartFrame(Instructor inst) {
        this.instructor = inst;
        this.management = new InstructorManagement(inst);

        setTitle("Instructor Insights & Analytics");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        

        Map<String, Map<String, LessonAnalytics>> allAnalytics = management.getCourseAnalytics();
        
        if (allAnalytics.isEmpty()) {
            add(new javax.swing.JLabel("No performance data available for your courses."), BorderLayout.CENTER);
            return;
        }

        String firstCourseId = allAnalytics.keySet().iterator().next();
        Map<String, LessonAnalytics> courseData = allAnalytics.get(firstCourseId);
        
        Course firstCourse = management.findCoursebyId(management.getCourses(), firstCourseId);
        String courseTitle = firstCourse != null ? firstCourse.getTitle() : "Selected Course";

        DefaultCategoryDataset quizDataset = createQuizDataset(courseData);
        DefaultCategoryDataset completionDataset = createCompletionDataset(courseData);

        
        JFreeChart quizChart = createChart(
            quizDataset, 
            "Quiz Averages - " + courseTitle, 
            "Average Score (%)"
        );
        
        JFreeChart completionChart = createChart(
            completionDataset, 
            "Lesson Completion - " + courseTitle, 
            "Completion Rate (%)"
        );

        ChartPanel quizChartPanel = new ChartPanel(quizChart);
        ChartPanel completionChartPanel = new ChartPanel(completionChart);

        javax.swing.JPanel chartsPanel = new javax.swing.JPanel(new java.awt.GridLayout(2, 1));
        chartsPanel.add(quizChartPanel);
        chartsPanel.add(completionChartPanel);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(chartsPanel, BorderLayout.CENTER);
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset, String title, String yAxisLabel) {
        JFreeChart chart = ChartFactory.createBarChart(
            title, 
            "Lesson", 
            yAxisLabel,                  
            dataset,                              
            PlotOrientation.VERTICAL,
            true, true, false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.lightGray); 
        return chart;
    }


    private DefaultCategoryDataset createQuizDataset(Map<String, LessonAnalytics> courseData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (LessonAnalytics data : courseData.values()) {
            dataset.addValue(data.getAverageQuizScore(), "Average Score", data.getLessonTitle());
        }

        return dataset;
    }
    

    private DefaultCategoryDataset createCompletionDataset(Map<String, LessonAnalytics> courseData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (LessonAnalytics data : courseData.values()) {
            dataset.addValue(data.getCompletionPercentage(), "Completion Rate", data.getLessonTitle());
        }

        return dataset;
    }
}
