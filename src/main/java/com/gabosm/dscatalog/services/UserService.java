package com.gabosm.dscatalog.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabosm.dscatalog.dto.RoleDTO;
import com.gabosm.dscatalog.dto.UserDTO;
import com.gabosm.dscatalog.dto.UserInsertDTO;
import com.gabosm.dscatalog.entities.Role;
import com.gabosm.dscatalog.entities.User;
import com.gabosm.dscatalog.repositories.RoleRepository;
import com.gabosm.dscatalog.repositories.UserRepository;
import com.gabosm.dscatalog.services.exceptions.DatabaseException;
import com.gabosm.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository RoleRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> Users = repository.findAll(pageable);
		return Users.map(x -> new UserDTO(x));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User User = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(User);
	}
	
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		
		return new UserDTO(entity);
	}
	

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			
			return new UserDTO(entity);																																																																						
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+ id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found "+ id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integration violeded");
		}
	}
	
	private User copyDtoToEntity(UserDTO dto, User entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		
		entity.getRoles().clear();
		
		for (RoleDTO roleDTO : dto.getRoles()) {
			Role role = RoleRepository.getReferenceById(roleDTO.getId());
			entity.getRoles().add(role);
		}
		
		return repository.save(entity);

	}
}
