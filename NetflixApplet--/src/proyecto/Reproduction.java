/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

public class Reproduction {

    private String type;
    private String title;
    private String gender;
    private double duration;
    private int year;
    private int see;

    //get 
    public int getSee() {
        return see;
    }
     
    public double getDuration() {
        return duration;
    }

    public String getGender() {
        return gender;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    //set
    public void setSee(int see) {
        this.see = see;
    }
    
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //CONSTRUCTOR 
    public Reproduction(String type, String title, String gender, double duration, int year) {
        this.type = type;
        this.title = title;
        this.gender = gender;
        this.duration = duration;
        this.year = year;
        this.see= see;
    }

    //TO STRING 
    public String toString() {
        return "Reproduction:" + "the type: " + type + ", the title is: " + title +
                ", the gender is:" + gender + ", the duration: " + duration + ", the year is: " + year + '|';
    }

}
