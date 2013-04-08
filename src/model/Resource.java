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
@Table(name = "Resource")
public class Resource implements ModelPersistenty
{
	private int idResource;
	private String name;
	private List<Project> projects = new ArrayList<Project>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdResource() {
		return idResource;
	}
	
	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name="Project_Resource", joinColumns={@JoinColumn(name="idProject")}, inverseJoinColumns={@JoinColumn(name="idResource")})
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
}
