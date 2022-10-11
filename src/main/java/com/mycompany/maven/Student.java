package com.mycompany.maven;
public class Student {
    private double id;
    private String first_name;
    private String gender;
    private String email;
    private double gpa;

    public Student(double id, String first_name, String gender, String email, double gpa) {
        this.id = id;
        this.first_name = first_name;
        this.gender = gender;
        this.email = email;
        this.gpa = gpa;
    }
    
    public double getId() {
        return id;
    }
    
    public void setId(double id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }    

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", gpa='" + gpa + '\'' +              
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
    
}
