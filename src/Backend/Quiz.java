/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author Khaled
 */
public class Quiz {
    private ArrayList<String> questions;
    private ArrayList<ArrayList<String>> options;
    private ArrayList<Integer> correctIndex;

    public Quiz(ArrayList<String> questions, ArrayList<ArrayList<String>> options, ArrayList<Integer> correctIndex) {
        this.questions = questions;
        this.options = options;
        this.correctIndex = correctIndex;
    }
    
    public void addQuestions(String question,ArrayList<String> options,int correctIndex){
    questions.add(question);
    this.options.add(options);
    this.correctIndex.add(correctIndex);
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public ArrayList<ArrayList<String>> getOptions() {
        return options;
    }

    public ArrayList<Integer> getCorrectIndex() {
        return correctIndex;
    }
    
}
