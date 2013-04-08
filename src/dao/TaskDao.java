package dao;

import java.util.List;

import model.ModelPersistenty;
import model.Task;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class TaskDao extends Dao
{
	public TaskDao()
	{
		super();
	}
	
	
	public boolean insertTask(Task task) 
	{
		try 
		{
			ModelPersistenty object = (ModelPersistenty) task;
			return save(object);
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> getTask() 
	{
		List<Task> result = null;
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Task u");
			result = query.list();
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
