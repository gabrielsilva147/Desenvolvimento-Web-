package br.edu.unirv.petshop.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unirv.petshop.entity.Pet;
import br.edu.unirv.petshop.repository.PetRepository;
import br.edu.unirv.petshop.service.PetService;

@RestController
public class RestAPI {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetService petService;

	@GetMapping("/pet")
	public List<Pet> getAll() {
		return petService.findAll();
	}

		
	@GetMapping("/pet/{id}")
	public ResponseEntity <Pet> getPet (@PathVariable(value ="id")Long id) {
		Optional<Pet>pet = petRepository.findById(id);
		if(pet.isPresent()) {
			return new ResponseEntity<Pet>(pet.get(),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping("/pet")
	public Pet addPet(@RequestParam(value ="name")String name) {
           	System.out.println(name);
             return petService.save(name);
	
	}
	@DeleteMapping("pet/{id}")
	public ResponseEntity <Pet> delete(@PathVariable(value ="id")Long id) {
			Optional<Pet>pet=petRepository.findById(id);
			if(pet.isPresent()){
				petRepository.deleteById(id);
				return new  ResponseEntity<Pet>(HttpStatus.OK);
				}
			else {
					return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
				}
			}
	@PutMapping("/pet/{id}")
    public ResponseEntity<Pet> update(@RequestParam(value = "id") long id, @RequestBody Pet novoPet){
        Optional<Pet> antigoPet = petService.findById(id);
        if(antigoPet.isPresent()){
            Pet pet = antigoPet.get();
            pet.setName(novoPet.getName());
            petRepository.save(pet);
            return new ResponseEntity<Pet>(pet, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	}
		
	
	  
	


