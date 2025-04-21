package com.udacity.critter.pet;

import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Represents the form that pet request and response data takes. Does not map
 * to the database directly.
 */
@NoArgsConstructor
public class PetDTO {
    private long id;
    private PetType type;
    private String name;
    private long ownerId;
    private LocalDate birthDate;
    private String notes;

    public PetDTO setIdMC(long id) {
        this.id = id;
        return this;
    }
    public PetDTO setTypeMC(PetType type) {
        this.type = type;
        return this;
    }
    public PetDTO setNameMC(String name) {
        this.name = name;
        return this;
    }
    public PetDTO setOwnerIdMC(long ownerId) {
        this.ownerId = ownerId;
        return this;
    }
    public PetDTO setBirthDateMC(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
    public PetDTO setNotesMC(String notes) {
        this.notes = notes;
        return this;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
