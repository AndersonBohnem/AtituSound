package br.edu.atitus.atitusound.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.atitusound.entities.PlaylistEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.atitusound.services.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	private final PlaylistRepository repository;
	
	public PlaylistServiceImpl(PlaylistRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public GenericRepository<PlaylistEntity> getRepository() {
		return repository;
	}

	
}
