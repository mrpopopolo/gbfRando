package fr.pops.gbfRando.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.pops.gbfRando.business.entity.User;
import fr.pops.gbfRando.persistence.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	public void createChara(User user) {
		this.userRepository.save(user);
	}
	
	public boolean validate(User user) {
		if(this.userRepository.getOne(user.getId()).getPassword().equals(user.getPassword()))
				{return true;}
		return false;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepository.findOneByUsername(username);
	}
	
}
