package org.hibernatekathir;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Embeddable
@Entity
@Table(name= "laptop_table")
public class Laptop {
    @Id
    private int lap_id;
    private String l_name;
    private String model;
    private int ram;


    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public int getLap_id() {
        return lap_id;
    }

    public void setLap_id(int lap_id) {
        this.lap_id = lap_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lap_id=" + lap_id +
                ", l_name='" + l_name + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
