package br.edu.atitus.atitusound.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.atitusound.entities.UserEntity;
import br.edu.atitus.atitusound.repositories.GenericRepository;
import br.edu.atitus.atitusound.repositories.UserRepository;
import br.edu.atitus.atitusound.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}



	@Override
	public GenericRepository<UserEntity> getRepository() {
		return repository;
	}

}
