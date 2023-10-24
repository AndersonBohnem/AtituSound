package br.edu.atitus.atitusound.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.atitus.atitusound.entities.ArtistEntity;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, UUID>{

	boolean existsByNameAndUuidNot(String name, UUID uuid);
	
	boolean existsByName(String name);
	
	Page<List<ArtistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name);
}
