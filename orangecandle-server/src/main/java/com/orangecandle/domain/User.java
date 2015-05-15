package com.orangecandle.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "xuser")
public class User implements UserDetails {
	private static final long serialVersionUID = 7641630718022679710L;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") Long id;

	private @Column(name = "username") String username;
	private @Column(name = "password") String password;
	private @ManyToMany(fetch = FetchType.LAZY) List<Group> groups = new ArrayList<Group>();;
	private @ManyToMany List<Constraint> constraints;

	public User() {
	}

	public User(String userName) {
		this.username = userName;
	}

	public void addConstraint(Constraint c) {
		if (constraints == null)
			constraints = new ArrayList<Constraint>();
		constraints.add(c);
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}

	public void addGroup(Group g) {
		if (groups == null)
			groups = new ArrayList<Group>();
		groups.add(g);
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setUserName(String name) {
		this.username = name;
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + username + "\"}";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new LinkedList<GrantedAuthority>();
		auths.add(Role.Student);// this will change
		return auths;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
