package com.udacity.critter.entities;

import com.udacity.critter.user.EmployeeSkill;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    @ManyToMany(targetEntity = Pet.class)
    private List<Pet> pets;

    private LocalDate date;

    @ElementCollection
    private Set<EmployeeSkill> activities;

    public Schedule setID(long id) {
        this.id = id;
        return this;
    }
    public Schedule setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }
    public Schedule setPets(List<Pet> pets) {
        this.pets = pets;
        return this;
    }
    public Schedule setDate(LocalDate date) {
        this.date = date;
        return this;
    }
    public Schedule setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
        return this;
    }


}
