package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project implements ModelPersistenty
{
	private int idProject;
	private String name;
	private Developer owner;
	private List<Task> tasks;
	private List<Resource> resources = new ArrayList<Resource>();
	private List<Developer> developers = new ArrayList<Developer>();
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdProject() {
		return idProject;
	}
	
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne
	@JoinColumn(name="idDeveloper")
	public Developer getOwner() {
		return owner;
	}
	
	public void setOwner(Developer owner) {
		this.owner = owner;
	}
	
	@OneToMany(targetEntity=Task.class, mappedBy="project", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@ManyToMany
	@JoinTable(name="Project_Resource", joinColumns={@JoinColumn(name="idResource")}, inverseJoinColumns={@JoinColumn(name="idProject")})
	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	@ManyToMany
	@JoinTable(name="Project_Developer", joinColumns={@JoinColumn(name="idDeveloper")}, inverseJoinColumns={@JoinColumn(name="idProject")})
	public List<Developer> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<Developer> developers) {
		this.developers = developers;
	}

}
