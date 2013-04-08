package dao;

import java.util.List;

import model.Developer;
import model.ModelPersistenty;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class DeveloperDao extends Dao 
{
	public DeveloperDao()
	{
		super();
	}
	
	public boolean insertDeveloper(Developer dev) 
	{
		try 
		{
			ModelPersistenty object = (ModelPersistenty) dev;
			return save(object);
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Developer> getDeveloper() 
	{
		List<Developer> result = null;
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Developer u");
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
