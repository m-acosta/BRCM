package model.dataccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.entities.OrderActivity;
import model.entities.OrderActivityId;
import resources.HibernateUtil;

public class OrderActivityDataAccess {
	public void saveOrderActivity(OrderActivity order_activity)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.save(order_activity);
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
	
	public void updateOrderActivity(OrderActivity order_activity)
	{
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(order_activity);
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
	
	public OrderActivity getOrderActivityById(OrderActivityId order_id_name)
	{
		Transaction transaction = null;
		OrderActivity order_activity = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			order_activity = session.get(OrderActivity.class, order_id_name);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return order_activity;
	}
	
	public List<OrderActivity> getAllOrderActivities()
	{
		Transaction transaction = null;
		List<OrderActivity> order_activities = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			order_activities = session.createQuery("from order_item").list();
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return order_activities;
	}

	public OrderActivity deleteOrderActivity(OrderActivityId order_id_name)
	{
		Transaction transaction = null;
		OrderActivity order_activity = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			order_activity = session.get(OrderActivity.class, order_id_name);
			session.delete(order_activity);
			transaction.commit();
		}
		catch (Exception e)
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
		}
		return order_activity;
	}

}
