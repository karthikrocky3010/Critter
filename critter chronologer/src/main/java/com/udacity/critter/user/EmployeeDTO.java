package com.udacity.critter.user;

import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.util.Set;

/**
 * Represents the form that employee request and response data takes. Does not map
 * to the database directly.
 */
@NoArgsConstructor
public class EmployeeDTO {
    private long id;
    private String name;
    private Set<EmployeeSkill> skills;
    private Set<DayOfWeek> daysAvailable;

    //Method chaining version of setId()
    public EmployeeDTO setIdMC(long id) {
        this.id = id;
        return this;
    }
    //Method chaining version of setName()
    public EmployeeDTO setNameMC(String name) {
        this.name = name;
        return this;
    }
    //Method chaining version of setSkills()
    public EmployeeDTO setSkillsMC(Set<EmployeeSkill> skills) {
        this.skills = skills;
        return this;
    }
    //Method chaining version of setDaysAvailable()
    public EmployeeDTO setDaysAvailableMC(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
        return this;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }



}
