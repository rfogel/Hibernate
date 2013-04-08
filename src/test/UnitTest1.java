package test;

import model.Developer;
import model.Project;
import model.Resource;
import model.Task;

import org.junit.Test;

import dao.DeveloperDao;
import dao.ProjectDao;
import dao.ResourceDao;
import dao.TaskDao;

public class UnitTest1 
{		
	@Test
	public void listarProjeto()
	{
		ProjectDao projectDao = new ProjectDao();
		
		for ( Project project : projectDao.getProject() )
		{
			System.out.println("Projeto: " + project.getName());
			System.out.println("Owner: " + project.getOwner().getName());
			
			for ( Task task : project.getTasks() )
			{
				System.out.println("Task: " + task.getName());
			}
			
			for ( Developer dev : project.getDevelopers() )
			{
				System.out.println("Developer: " + dev.getName());
			}
			
			for ( Resource res : project.getResources() )
			{
				System.out.println("Resource: " + res.getName());
			}
		}
	}
	
	//@Test
	public void salvar()
	{		
		TaskDao taskDao = new TaskDao();
		DeveloperDao devDao = new DeveloperDao();
		ProjectDao projectDao = new ProjectDao();
		ResourceDao resourceDao = new ResourceDao();
		
		Project project1 = new Project();
		project1.setName("Projeto01");
		
		Project project2 = new Project();
		project2.setName("Projeto02");
		
		Project project3 = new Project();
		project3.setName("Projeto03");
		
		Developer dev1 = new Developer();
		dev1.setName("Rafael Fogel");
		
		Developer dev2 = new Developer();
		dev2.setName("Rodrigo Silva");
		
		Developer dev3 = new Developer();
		dev3.setName("Bal Hana");
		
		Task task1 = new Task();
		task1.setName("task1");
		
		Task task2 = new Task();
		task2.setName("task2");
		
		Task task3 = new Task();
		task3.setName("task3");
		
		Resource resource1 = new Resource();
		resource1.setName("PC 1");
		
		Resource resource2 = new Resource();
		resource2.setName("PC 2");
		
		Resource resource3 = new Resource();
		resource3.setName("PC 3");

		project1.setOwner(dev1);		
		project2.setOwner(dev2);		
		project3.setOwner(dev3);
		
		project1.getDevelopers().add(dev2);
		project1.getDevelopers().add(dev3);
		
		project2.getDevelopers().add(dev1);
		project2.getDevelopers().add(dev3);
		
		project3.getDevelopers().add(dev1);
		project3.getDevelopers().add(dev2);
		
		project1.getResources().add(resource1);
		project1.getResources().add(resource2);
		
		project2.getResources().add(resource1);
		project2.getResources().add(resource3);
		
		project3.getResources().add(resource2);
		project3.getResources().add(resource3);
		
		task1.setProject(project1);
		task2.setProject(project2);
		task3.setProject(project3);

		devDao.save(dev1);
		devDao.save(dev2);
		devDao.save(dev3);
		
		resourceDao.save(resource1);
		resourceDao.save(resource2);
		resourceDao.save(resource3);
		
		projectDao.save(project1);
		projectDao.save(project2);
		projectDao.save(project3);
		
		taskDao.save(task1);
		taskDao.save(task2);
		taskDao.save(task3);	
	}
		
	//@Test
	public void atualizar()
	{
		TaskDao taskDao = new TaskDao();
		
		int counter = 1;
		
		for ( Task task : taskDao.getTask() )
		{
			System.out.println(task.getName());
			
			task.setName("Tarefa" + counter++);
			
			taskDao.saveOrUpdate(task);
		}
	}	
	
	//@Test
	public void listar() 
	{
		TaskDao taskDao = new TaskDao();
		
		for ( Task task : taskDao.getTask() )
		{
			System.out.println(task.getName());
		}
		
		DeveloperDao devDao = new DeveloperDao();
		
		for ( Developer dev : devDao.getDeveloper() )
		{
			System.out.println(dev.getName());
		}
		
		ProjectDao projectDao = new ProjectDao();
		
		for ( Project project : projectDao.getProject() )
		{
			System.out.println(project.getName());
		}
	}

}
