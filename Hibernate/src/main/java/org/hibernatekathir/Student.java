package org.hibernatekathir;

import jakarta.persistence.*;

@Entity
@Table(name = "student_table")
public class Student {


    @Id
    @Column(name = "roll_no")
    private int id;
    private String name;
    private int marks;
    @OneToOne
    private Laptop laptop;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    public int getRollno() {
        return id;
    }

    public void setRollno(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
