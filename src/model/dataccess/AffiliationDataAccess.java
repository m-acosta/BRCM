package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Affiliation;
import resources.HibernateUtil;

public class AffiliationDataAccess 
{
	public void saveAffiliation(Affiliation affiliation)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(affiliation);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
	}
	
	public void updateAffiliation(Affiliation affiliation)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(affiliation);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
	}
	
	public Affiliation getAffiliationById(String title)
	{
		Transaction transaction = null;
		Affiliation affiliation = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			affiliation = session.get(Affiliation.class, title);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return affiliation;
	}
	
	public List<Affiliation> getAllAffiliations()
	{
		Transaction transaction = null;
		List<Affiliation> affiliations = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			affiliations = session.createQuery("from affiliation").list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return affiliations;
	}

	public Affiliation deleteAffiliation(String title)
	{
		Transaction transaction = null;
		Affiliation affiliation = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			affiliation = session.get(Affiliation.class, title);
			session.delete(affiliation);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return affiliation;
	}
}
