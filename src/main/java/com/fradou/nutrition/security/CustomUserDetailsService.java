package com.fradou.nutrition.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fradou.nutrition.mvc.dao.UserDAOImpl;
import com.fradou.nutrition.mvc.entity.CustomUser;

@Service
@Transactional(rollbackFor = Exception.class)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDAOImpl userDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		CustomUser user;
		
		try {
			user = userDao.findUniqueBy("username", username);
			
			if(user == null) {
				throw new UsernameNotFoundException("user not found");
			}
		}
		catch(Exception ex) {
			System.out.println("Foirage : " + ex.getMessage());
			throw new UsernameNotFoundException("DB error");
		}
		System.out.println("user trouvé");
		return convertToSpringUser(user);
	}

	private UserDetails convertToSpringUser(CustomUser user) {
		
		User sprUser = new User(
				user.getUsername(),
				user.getPassword(),
				user.isEnabled(),
				true,
				true,
				true,
				user.getAuthorities()
		);
		return sprUser;
	}

}
