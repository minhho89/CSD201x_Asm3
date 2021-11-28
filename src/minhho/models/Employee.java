package minhho.models;

import java.time.LocalDate;

public class Employee {

    String id;          // id
    String name;        // full name
    LocalDate dob;      // date of birth
    String pob;         // place of birth

    public Employee() {
    }

    public Employee(String id, String name, LocalDate dob, String pob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.pob = pob;
    }


}
