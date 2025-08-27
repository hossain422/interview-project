package com.saidy.StudentFormApp.dto;

public class StudentDTO {

    private Long id;
    private String name;
    private String roll;
    private String studentClass;
    private String department;
    private boolean active = true;

    // ✅ No-args constructor (form binding এর জন্য)
    public StudentDTO() {
    }

    // ✅ Parameterized constructor (optional)
    public StudentDTO(Long id, String name, String roll, String studentClass, String department, boolean active) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.studentClass = studentClass;
        this.department = department;
        this.active = active;
    }

    // --------- Getters & Setters ----------
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }
    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    // ✅ Debugging এর জন্য toString()
    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", department='" + department + '\'' +
                ", active=" + active +
                '}';
    }
}