package br.edu.unirv.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unirv.petshop.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

}
