package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.ActivityPrice;
import model.entities.ActivityPriceId;
import model.business.HibernateUtil;

public class ActivityPriceDataAccess {
	public void saveActivityPrice(ActivityPrice activity_price)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(activity_price);
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
	
	public void updateActivityPrice(ActivityPrice activity_price)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(activity_price);
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
	
	public ActivityPrice getActivityPriceById(ActivityPriceId primary_key)
	{
		Transaction transaction = null;
		ActivityPrice activity_price = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_price = session.get(ActivityPrice.class, primary_key);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_price;
	}
	
	public List<ActivityPrice> getAllActivityPrices()
	{
		Transaction transaction = null;
		List<ActivityPrice> activity_prices = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_prices = session.createQuery("from activity_price").list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_prices;
	}

	public ActivityPrice deleteActivityPrice(ActivityPriceId primary_key)
	{
		Transaction transaction = null;
		ActivityPrice activity_price = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_price = session.get(ActivityPrice.class, primary_key);
			session.delete(activity_price);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_price;
	}
}
