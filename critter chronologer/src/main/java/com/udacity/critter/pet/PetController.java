package com.udacity.critter.pet;

import com.udacity.critter.entities.Pet;
import com.udacity.critter.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetsService petsService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = new Pet()
                .setType(petDTO.getType())
                .setName(petDTO.getName())
                .setBirthDate(petDTO.getBirthDate())
                .setNotes(petDTO.getNotes());
        return getPetDTO(petsService.savePetAndReturnIt(pet, petDTO.getOwnerId()));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return getPetDTO(petsService.getPetByPetId(petId));
    }

    @GetMapping
    public List<PetDTO> getPets() {
        List<Pet> pets = petsService.getAllPets();
        List<PetDTO> petDTOs = new ArrayList<>();
        for (Pet pet : pets) {
            PetDTO dto = getPetDTO(pet);
            petDTOs.add(dto);
        }
        return petDTOs;
    }


    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> pets = petsService.getAllPetsByCustomerId(ownerId);
        List<PetDTO> petDTOs = new ArrayList<>();
        for (Pet pet : pets) {
            PetDTO dto = getPetDTO(pet);
            petDTOs.add(dto);
        }
        return petDTOs;
    }


    private PetDTO getPetDTO(Pet pet) {
        return new PetDTO()
                .setIdMC(pet.getId())
                .setNameMC(pet.getName())
                .setTypeMC(pet.getType())
                .setOwnerIdMC(pet.getCustomer().getId())
                .setBirthDateMC(pet.getBirthDate())
                .setNotesMC(pet.getNotes());
    }
}
