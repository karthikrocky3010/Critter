package com.udacity.critter.schedule;

import com.udacity.critter.user.EmployeeSkill;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Represents the form that schedule request and response data takes. Does not map
 * to the database directly.
 */
@NoArgsConstructor
public class ScheduleDTO {
    private long id;
    private List<Long> employeeIds;
    private List<Long> petIds;
    private LocalDate date;
    private Set<EmployeeSkill> activities;

    //This version supports Method chaining
    public ScheduleDTO setIdMC(long id) {
        this.id = id;
        return this;
    }
    //This version supports Method chaining
    public ScheduleDTO setEmployeeIdMC(List<Long> employeeId) {
        this.employeeIds = employeeId;
        return this;
    }
    //This version supports Method chaining
    public ScheduleDTO setPetIdMC(List<Long> petId) {
        this.petIds = petId;
        return this;
    }
    //This version supports Method chaining
    public ScheduleDTO setDateMC(LocalDate date) {
        this.date = date;
        return this;
    }
    //This version supports Method chaining
    public ScheduleDTO setActivitiesMC(Set<EmployeeSkill> activities) {
        this.activities = activities;
        return this;
    }

    public long getId() {
        return id;
    }
    //normal setter
    public void setId(long id) {
        this.id = id;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }
    //normal setter
    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public List<Long> getPetIds() {
        return petIds;
    }
    //normal setter
    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }

    public LocalDate getDate() {
        return date;
    }
    //normal setter
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }
    //normal setter
    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
