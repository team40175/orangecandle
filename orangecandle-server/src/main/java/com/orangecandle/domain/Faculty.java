package com.orangecandle.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {
	private @Id @Column(name = "id") Integer id;
	private @Column(name = "facultyname") String name;
	private @OneToMany List<Department> departments;
	
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getDepartmentName(){
		return this.name;
	}
	public void setDepartmentName(String name){
		this.name=name;
	}
	public void addDepartment(Department dep){
		if(departments==null) departments=new ArrayList<Department>();
		departments.add(dep);
	}
	public List<Department> getDepartments(){
		return departments;
	}
}
