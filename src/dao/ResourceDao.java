package dao;

import java.util.List;

import model.Developer;
import model.ModelPersistenty;
import model.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class ResourceDao extends Dao
{
	public ResourceDao()
	{
		super();
	}
	
	public boolean insertResource(Resource res) 
	{
		try 
		{
			ModelPersistenty object = (ModelPersistenty) res;
			return save(object);
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Developer> getResource() 
	{
		List<Developer> result = null;
		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Resource u");
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
