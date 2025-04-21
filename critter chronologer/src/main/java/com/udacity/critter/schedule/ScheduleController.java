package com.udacity.critter.schedule;

import com.udacity.critter.entities.Employee;
import com.udacity.critter.entities.Pet;
import com.udacity.critter.entities.Schedule;
import com.udacity.critter.services.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private SchedulesService schedulesService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule()
                .setDate(scheduleDTO.getDate())
                .setActivities(scheduleDTO.getActivities());
        return getScheduleDTO(schedulesService.saveSchedule(schedule, scheduleDTO.getEmployeeIds(), scheduleDTO.getPetIds()));
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> schedules = schedulesService.getAllSchedules();
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        int i = 0;
        while (i < schedules.size()) {
            ScheduleDTO dto = getScheduleDTO(schedules.get(i));
            scheduleDTOs.add(dto);
            i++;
        }
        return scheduleDTOs;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<Schedule> schedules = schedulesService.getAllSchedulesForPet(petId);
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleDTO dto = getScheduleDTO(schedule);
            scheduleDTOs.add(dto);
        }
        return scheduleDTOs;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<Schedule> schedules = schedulesService.getAllSchedulesForEmployee(employeeId);
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleDTO dto = getScheduleDTO(schedule);
            scheduleDTOs.add(dto);
        }
        return scheduleDTOs;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<Schedule> schedules = schedulesService.getAllSchedulesForCustomer(customerId);
        List<ScheduleDTO> scheduleDTOs = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleDTO dto = getScheduleDTO(schedule);
            scheduleDTOs.add(dto);
        }

        return scheduleDTOs;
    }


    private ScheduleDTO getScheduleDTO(Schedule schedule) {
        List<Long> employeeIds = new ArrayList<>();
        for (Employee employee : schedule.getEmployees()) {
            employeeIds.add(employee.getId());
        }

        List<Long> petIds = new ArrayList<>();
        for (Pet pet : schedule.getPets()) {
            petIds.add(pet.getId());
        }

        return new ScheduleDTO()
                .setIdMC(schedule.getId())
                .setEmployeeIdMC(employeeIds)
                .setPetIdMC(petIds)
                .setDateMC(schedule.getDate())
                .setActivitiesMC(schedule.getActivities());
    }
}
