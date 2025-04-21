package com.udacity.critter.entities;

import com.udacity.critter.pet.PetType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private PetType type;

    private String name;

    @ManyToOne(targetEntity = Customer.class, optional = false)
    private Customer customer;

    private LocalDate birthDate;

    private String notes;

    public Pet setType(PetType type) {
        this.type = type;
        return this;
    }

    public Pet setName(String name) {
        this.name = name;
        return this;
    }
    public Pet setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
    public Pet setNotes(String notes) {
        this.notes = notes;
        return this;
    }
}
