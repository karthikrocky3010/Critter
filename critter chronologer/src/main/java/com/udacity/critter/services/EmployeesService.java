package com.udacity.critter.services;

import com.udacity.critter.entities.Employee;
import com.udacity.critter.repositories.EmployeesRepository;
import com.udacity.critter.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employee getEmployeeById(long employeeId) {
        return employeesRepository.getOne(employeeId);
    }

    public List<Employee> getEmployeesForService(LocalDate date, Set<EmployeeSkill> skills) {
        List<Employee> availableEmployees = employeesRepository.getAllByDaysAvailableContains(date.getDayOfWeek());
        List<Employee> matchingEmployees = new ArrayList<>();

        for (Employee employee : availableEmployees) {
            if (employee.getSkills().containsAll(skills)) {
                matchingEmployees.add(employee);
            }
        }

        return matchingEmployees;
    }


    public Employee saveEmployee(Employee employee) {
        return employeesRepository.save(employee);
    }

    public void setEmployeeAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeesRepository.getOne(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeesRepository.save(employee);
    }
}
