package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.Activity;
import model.entities.ActivityPurchase;
import model.entities.Purchase;
import model.business.HibernateUtil;

public class ActivityDataAccess {
	public void saveActivity(Activity activity)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(activity);
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
	
	public void updateActivity(Activity activity)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(activity);
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
	
	public Activity getActivityById(int activity_id)
	{
		Transaction transaction = null;
		Activity activity = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity = session.get(Activity.class, activity_id);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity;
	}
	public Activity getActivityPriceByName(String name)
	{
		Transaction transaction = null;
		List<Activity> activity_prices = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity_prices = session.createQuery("FROM Activity WHERE activity = '" + name + "' ORDER BY date DESC").list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity_prices.get(0);
	}
	
	public List<Activity> getAllActivities()
	{
		Transaction transaction = null;
		List<Activity> activities = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activities = (List<Activity>)session.createQuery("FROM Activity", Activity.class).list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activities;
	}
	
	public List<String> getAllActivitiesByDate()
	{
		Transaction transaction = null;
		List<String> activities = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activities = (List<String>)session.createQuery("SELECT DISTINCT(activity) FROM Activity").list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activities;
	}

	public Activity deleteActivity(String name)
	{
		Transaction transaction = null;
		Activity activity = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			activity = session.get(Activity.class, name);
			session.delete(activity);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return activity;
	}

}
