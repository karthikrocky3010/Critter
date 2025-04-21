package com.udacity.critter.user;

import com.udacity.critter.entities.*;
import com.udacity.critter.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomersService customersService;

    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
        List<Long> AssociatedPetIds = customerDTO.getPetIds();
        Customer customer = new Customer()
                .setName(customerDTO.getName())
                .setPhoneNumber(customerDTO.getPhoneNumber())
                .setNotes(customerDTO.getNotes());
        return getCustomerDTO(customersService.saveCustomer(customer, AssociatedPetIds));
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customersService.getAllCustomers();
        List<CustomerDTO> customerDTOs = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO dto = getCustomerDTO(customer);
            customerDTOs.add(dto);
        }

        return customerDTOs;
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId) {
        return getCustomerDTO(customersService.getCustomerByPetId(petId));
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee()
            .setName(employeeDTO.getName())
            .setSkills(employeeDTO.getSkills())
            .setDaysAvailable(employeeDTO.getDaysAvailable());
        return getEmployeeDTO(employeesService.saveEmployee(employee));
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        return getEmployeeDTO(employeesService.getEmployeeById(employeeId));
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeesService.setEmployeeAvailability(daysAvailable, employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        List<Employee> employees = employeesService.getEmployeesForService(employeeDTO.getDate(), employeeDTO.getSkills());

        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (Employee employee : employees) {
            employeeDTOs.add(getEmployeeDTO(employee));
        }

        return employeeDTOs;
    }

    private CustomerDTO getCustomerDTO(Customer customer) {

        List<Long> petIds = new ArrayList<>();
        for (Pet pet : customer.getPets()) {
            petIds.add(pet.getId());
        }

        return new CustomerDTO()
                .setIdMC(customer.getId())
                .setNameMC(customer.getName())
                .setPhoneNumberMC(customer.getPhoneNumber())
                .setNotesMC(customer.getNotes())
                .setPetIdMC(petIds);
    }

    private EmployeeDTO getEmployeeDTO(Employee employee) {
        return new EmployeeDTO()
                .setIdMC(employee.getId())
                .setNameMC(employee.getName())
                .setSkillsMC(employee.getSkills())
                .setDaysAvailableMC(employee.getDaysAvailable());
    }
}
