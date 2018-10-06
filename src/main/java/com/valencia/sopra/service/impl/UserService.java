package com.valencia.sopra.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.valencia.sopra.entity.UserRole;
import com.valencia.sopra.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	/** INYECTAMOS NUESTRO 'UserRepository' */
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	/** 
	 *  ESTA CLASE COMPROBARA EL USUARIO USANDO LA CLASE 'SecurityConfiguration' Y DESPUES
	 *  CONSTRUIRA AL USUARIO EN BASE AL USUARIO, PASSWORD Y SUS ROLES O PERMISOS CONCEDIDOS
	 *  Y NOS LO RETORNARA CON EL ACCESO AL SISTEMA CONCEDIDO
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.valencia.sopra.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}

		private User buildUser(com.valencia.sopra.entity.User user, List<GrantedAuthority>authorities) {
			return new User(user.getUsername(), user.getPasssword(), user.isEnabled(),
					true, true, true, authorities);
		}
		
		private List<GrantedAuthority> buildAuthorities (Set<UserRole> userRoles){
			Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
			
			for(UserRole userRole : userRoles) {
				auths.add(new SimpleGrantedAuthority(userRole.getRole()));
			}
			
			return new ArrayList<GrantedAuthority>(auths);
		}
}
