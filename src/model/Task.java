package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Task")
public class Task implements ModelPersistenty
{
	private int idTask;
	private String name;
	private Project project;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdTask() {
		return idTask;
	}
	
	public void setIdTask(int idTask) {
		this.idTask = idTask;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name="idProject")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
