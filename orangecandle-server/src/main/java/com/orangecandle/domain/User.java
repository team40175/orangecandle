package com.orangecandle.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id @Column(name = "id") Long id;
	private @Column(name = "username") String username;
	private @Column(name = "password") String password;
	private @Column Boolean isPartTime = false;
	private @ManyToMany List<Group> groups;
	private transient @ManyToMany List<Constraint> constraints;
	private @ManyToMany List<Lecture> takenLectures;
	private @ManyToMany List<Lecture> assignedLectures;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, ArrayList<Lecture> lectures, boolean isPartTime) {
		this.username = username;
		this.isPartTime = isPartTime;
		assignLectures(lectures);
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

	public void removeAllGroups() {
		groups = new ArrayList<Group>();
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

	public void setPassword(String password) {
		this.password = password;
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

	public Long getId() {
		return id;
	}

	public void pickLecture(Lecture... lectures) {
		if (takenLectures == null) {
			takenLectures = new LinkedList<Lecture>();
		}
		takenLectures.addAll(Arrays.asList(lectures));
	}

	public void dropLecture(Lecture... lectures) {
		takenLectures.removeAll(Arrays.asList(lectures));
	}

	public void assignLecture(Lecture... lectures) {
		if (assignedLectures == null) {
			assignedLectures = new LinkedList<Lecture>();
		}
		assignedLectures.addAll(Arrays.asList(lectures));
	}

	public void assignLectures(List<Lecture> lectures) {
		if (assignedLectures == null) {
			assignedLectures = new LinkedList<Lecture>();
		}
		assignedLectures.addAll(lectures);
	}

	public boolean isPartTime() {
		return isPartTime;
	}

	public void setPartTime(boolean isPartTime) {
		this.isPartTime = isPartTime;
	}
}
