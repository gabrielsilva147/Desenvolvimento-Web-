package br.edu.unirv.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.unirv.petshop.entity.Pet;
import br.edu.unirv.petshop.repository.PetRepository;

@Service
public class PetService {
	@Autowired
	private PetRepository petRepository;
	
	
		public List <Pet> findAll(){
			return petRepository.findAll();
		}
		public Pet save(String name) {
			Pet pet = new Pet ();
			pet.setName(name);
			System.out.println(name);
			return petRepository.save(pet);
		}
		public Optional<Pet> deletePet(@PathVariable(value = "id") Long id){
	        Optional<Pet> pet = petRepository.findById(id);
			return pet;
		}
		

		public Optional<Pet> findById(Long id) {
			Optional<Pet> pet = petRepository.findById(id);
			return pet;
		}
		public Optional<Pet> Put(@RequestParam(value = "id") long id, @RequestBody Pet novoPet){
	        Optional<Pet> antigoPet = petRepository.findById(id);
			return antigoPet;
		}
		public Optional<Pet> update(@RequestParam(value = "id") long id, @RequestBody Pet novoPet){
	        Optional<Pet> antigoPet = petRepository.findById(id);
			return antigoPet;
		}
		
}
