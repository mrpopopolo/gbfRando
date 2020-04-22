package fr.pops.gbfRando.business.entity;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 20)
	private String username;
	
	@Column(nullable = false, length = 20)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	public Role getRole() {return role;}

	public void setRole(Role role) {this.role = role;}

	public Long getId() {return id;}

	public void setUsername(String username) {this.username = username;}

	public void setPassword(String password) {this.password = password;}

	@Override
	public Collection<Role> getAuthorities() {
		return Arrays.asList(this.getRole());
	}

	@Override
	public String getPassword() {return this.password;}

	@Override
	public String getUsername() {return username;}

	@Override
	public boolean isAccountNonExpired() {return true;}

	@Override
	public boolean isAccountNonLocked() {return true;}

	@Override
	public boolean isCredentialsNonExpired() {return true;}

	@Override
	public boolean isEnabled() {return true;}

}
