package br.edu.atitus.atitusound.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.atitus.atitusound.entities.ArtistEntity;
import br.edu.atitus.atitusound.repositories.ArtistRepository;
import br.edu.atitus.atitusound.services.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

	private final ArtistRepository artistrepository;

	public ArtistServiceImpl(ArtistRepository artistrepository) {
		super();
		this.artistrepository = artistrepository;
	}
	
	protected void validateFindByName(Pageable pageable, String name) {
		
		
	}
	
	protected void validateSave(ArtistEntity entidade)throws Exception{
		if (entidade.getName() == null || entidade.getName().isEmpty())
			throw new Exception("Campo Name Invalido");

		if (entidade.getUuid() == null) {
			if (artistrepository.existsByName(entidade.getName()))
				throw new Exception("Ja existe registro com este nome!");
		} else {
			if(!artistrepository.existsById(entidade.getUuid()))
				throw new Exception("Registro não encontrado com esse UUID");
			
			if (artistrepository.existsByNameAndUuidNot(entidade.getName(), entidade.getUuid()))
				throw new Exception("Ja existe registro com este nome!");
			
		}}

	
	
	@Override
	public ArtistEntity save(ArtistEntity entidade) throws Exception {
		
		validateSave(entidade);

		artistrepository.save(entidade);

		return entidade;
	}
	

	@Override
	public List<ArtistEntity> findAll() throws Exception {
		
		return artistrepository.findAll();
	}

	@Override
	public Page<List<ArtistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) {
		validateFindByName(pageable, name);
		return artistrepository.findByNameContainingIgnoreCase(pageable, name);
	}

	@Override
	public Page<List<ArtistEntity>> findByNameContainingIgnoreCase1(Pageable pageable, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	protected void validateFindById(UUID uuid) {
		
	}
	
	@Override
	public Optional<ArtistEntity> findById(UUID uuid) throws Exception {
		validateFindById(uuid);
		return artistrepository.findById(uuid);
	}
	
	protected void validateDeleteById(UUID uuid)throws Exception {
		
	}
	
	@Override
	public void deleteById(UUID uuid) throws Exception {
		validateDeleteById(uuid);
		artistrepository.deleteById(uuid);
		
	}

}