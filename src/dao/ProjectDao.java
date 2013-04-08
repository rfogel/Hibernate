package dao;

import java.util.List;

import model.ModelPersistenty;
import model.Project;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class ProjectDao extends Dao
{
	public ProjectDao()
	{
		super();
	}
	
	
	public boolean insertProject(Project project) 
	{
		try 
		{
			ModelPersistenty object = (ModelPersistenty) project;
			return save(object);
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Project> getProject() 
	{
		List<Project> result = null;
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Project u");
			result = query.list();
			
			for ( Project pro : result )
			{
				Hibernate.initialize(pro.getDevelopers());
				Hibernate.initialize(pro.getResources());
			}
			
			session.close();
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			session.close();
		}

		return result;
	}
}
