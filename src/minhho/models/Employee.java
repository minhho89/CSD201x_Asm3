package minhho.models;

import java.time.LocalDate;

public class Employee {

    private int id;          // id
    private String name;        // full name
    private LocalDate dob;      // date of birth
    private String pob;         // place of birth

    public Employee() {
    }

    public Employee(int id, String name, LocalDate dob, String pob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.pob = pob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", pob='" + pob + '\'';
    }
}
