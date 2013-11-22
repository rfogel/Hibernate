package test;

import java.util.ArrayList;
import java.util.List;

import model.Departamento;
import model.Empregado;
import model.Ferias;
import model.Projeto;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import dao.Dao;

public class UnitTest2 
{
	@Test
	public void populaTabela()
	{
		Dao dao = new Dao();
		
		Departamento dep1 = new Departamento();
		Departamento dep2 = new Departamento();
		
		dep1.setNomeDepartamento("A");		
		dep2.setNomeDepartamento("B");
				
		Empregado emp1 = new Empregado();
		Empregado emp2 = new Empregado();
		Empregado emp3 = new Empregado();
		
		emp1.setNomeEmpregado("rafael"); 
		emp1.setNumeroDependentes(3); 
		emp1.setSalario(1000); 
		emp1.setDepartamento(dep2);
		emp1.setIdEmpregado(1);
		
		emp2.setNomeEmpregado("fogel"); 
		emp2.setNumeroDependentes(1); 
		emp2.setSalario(3000); 
		emp2.setDepartamento(dep1);
		emp2.setIdEmpregado(2);
		
		emp3.setNomeEmpregado("rafael fogel"); 
		emp3.setNumeroDependentes(5); 
		emp3.setSalario(3000); 
		emp3.setDepartamento(dep2);
		emp3.setIdEmpregado(3);
		
		Ferias fef1 = new Ferias();
		Ferias fef2 = new Ferias();
		
		fef1.setAno(2012);
		fef1.setMes(12);
		fef1.setEmpregado(emp1);
		
		fef2.setAno(2000);
		fef2.setMes(12);
		fef2.setEmpregado(emp2);
		
		List<Ferias> ferias1 = new ArrayList<Ferias>();
		List<Ferias> ferias2 = new ArrayList<Ferias>();
		
		ferias1.add(fef1);
		ferias2.add(fef2);
		
		emp1.setFerias(ferias1);
		emp2.setFerias(ferias2);
		
		Projeto pro1 = new Projeto();
		Projeto pro2 = new Projeto();
		Projeto pro3 = new Projeto();
		
		dao.save(dep1);
		dao.save(dep2);
		dao.save(emp1);
		dao.save(emp2);
		dao.save(emp3);
		
		//--------------------------------------------------
		
		List<Empregado> empregados1 = new ArrayList<Empregado>();
		List<Empregado> empregados2 = new ArrayList<Empregado>();
		List<Empregado> empregados3 = new ArrayList<Empregado>();
		
		empregados1.add(emp1);
		empregados1.add(emp2);
		
		empregados2.add(emp3);
		empregados2.add(emp1);
		
		pro1.setIdProjeto(1);
		pro1.setNomeProjeto("P1");
		pro1.setEmpregados(empregados1);	
		
		pro2.setIdProjeto(2);
		pro2.setNomeProjeto("P2");
		pro2.setEmpregados(empregados2);
		
		pro3.setIdProjeto(3);
		pro3.setNomeProjeto("P3");
		pro3.setEmpregados(empregados3);
		
		dao.save(pro1);
		dao.save(pro2);
		dao.save(pro3);				
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getTabela()
	{
		System.out.println("getTabela");
		
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
		Configuration configuration;
		
		configuration = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = null;
		
		List<Empregado> result = new ArrayList<Empregado>();

		try
		{
			session = sessionFactory.openSession();
			Query query = session.createQuery("select nomeEmpregado, salario from Empregado");
			result = query.list();
			session.close();
			
			for ( Empregado e : result ){
				System.out.println(e.getNomeEmpregado());
			}

		} catch (HibernateException e) {
			System.out.println("erro");
			e.printStackTrace();
			session.close();
		}
		
		

	}
}

