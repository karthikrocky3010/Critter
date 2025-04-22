package com.udacity.critter.services;

import com.udacity.critter.entities.Customer;
import com.udacity.critter.entities.Pet;
import com.udacity.critter.repositories.CustomersRepository;
import com.udacity.critter.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private PetsRepository petsRepository;

    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
    }

    public Customer getCustomerByPetId(long petId) {
        return petsRepository.getOne(petId).getCustomer();
    }

    public Customer saveCustomer(Customer customer, List<Long> petIds) {
        List<Pet> pets = new ArrayList<>();
        if (petIds != null && !petIds.isEmpty()) {
            for (Long petId : petIds) {
                Pet pet = petsRepository.getOne(petId);
                pets.add(pet);
            }
        }
        customer.setPets(pets);
        return customersRepository.save(customer);
    }

}
