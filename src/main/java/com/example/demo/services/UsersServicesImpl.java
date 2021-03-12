package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;

@Transactional
@Service("usersServices")
public class UsersServicesImpl implements UsersServices {
	
	@Autowired
	private UsersRepository repo;

	@Override
	public List<Users> findAll() {
		return repo.findAll();
	}

	public void save(Users user) {
		repo.save(user);		
	}
	public Users get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }

}
