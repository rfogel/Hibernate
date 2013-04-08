package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Developer")
public class Developer implements ModelPersistenty 
{
	private int idDeveloper;
	private String name;
	private List<Project> projects = new ArrayList<Project>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdDeveloper() {
		return idDeveloper;
	}
	
	public void setIdDeveloper(int idDeveloper) {
		this.idDeveloper = idDeveloper;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name="Project_Developer", joinColumns={@JoinColumn(name="idProject")}, inverseJoinColumns={@JoinColumn(name="idDeveloper")})
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
