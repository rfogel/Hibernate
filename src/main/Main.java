package main;

import model.Developer;
import model.Project;
import model.Task;
import dao.DeveloperDao;
import dao.ProjectDao;
import dao.TaskDao;

public class Main 
{
	public static void main(String[] args) 
	{
		//salvar();
		recuperar();
	}
	
	public static void recuperar()
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
	
	public static void salvar()
	{		
		TaskDao taskDao = new TaskDao();
		DeveloperDao devDao = new DeveloperDao();
		ProjectDao projectDao = new ProjectDao();
		
		Project project = new Project();
		project.setName("Projeto01");
		
		Developer dev = new Developer();
		dev.setName("Rafael Fogel");
		
		Task task1 = new Task();
		task1.setName("task1");
		
		Task task2 = new Task();
		task2.setName("task2");
		
		Task task3 = new Task();
		task3.setName("task3");
		
		Task task4 = new Task();
		task4.setName("task4");

		project.setOwner(dev);
		task1.setProject(project);
		task2.setProject(project);
		task3.setProject(project);
		task4.setProject(project);

		devDao.save(dev);
		projectDao.save(project);
		taskDao.save(task1);
		taskDao.save(task2);
		taskDao.save(task3);
		taskDao.save(task4);	
	}
}


/*
EntityManagerFactory factory = Persistence.createEntityManagerFactory("lojavirtualDB"); 
EntityManager em = factory.createEntityManager();

em.getTransaction().begin();

em.persist(project);	
em.persist(task1);
em.persist(task2);		
em.persist(dev);
		
em.getTransaction().commit();

em.close();
*/	