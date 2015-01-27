package com.tyan.ai.tool;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.tyan.ai.tool.*;
import com.tyan.ai.frame.Knowledge.Knowledge;
import com.tyan.ai.frame.message.AskMessage;
import com.tyan.ai.frame.message.Message;

public class HibernateTool {
	
	public static void saveMessage(AskMessage msg){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
        session.save(msg);
        tx.commit();
	}
	
	public static void save(Object oj){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
        session.save(oj);
        tx.commit();
	}
	
	public static void saveObject(Object oj){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(oj);
			tx.commit();
		} catch (RuntimeException e) {
			 if (tx != null) tx.rollback();
			 e.printStackTrace();
		} finally {
		}
	}
	
	public static void releaseSeesion(){
		HibernateUtil.getSessionFactory().close();
	}
	
	public static Knowledge directFindAnster(long directHash){
      Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
      Transaction tx = session.beginTransaction();
        
        long qstHash = directHash;
        
        Criteria c=session.createCriteria(Knowledge.class);
        c.add(Restrictions.eq("qstHash",qstHash));//eq是等于，gt是大于，lt是小于,or是或
		if (c.list().size() != 0) {
			Knowledge klg = (Knowledge) c.list().get(0);
			tx.commit();
			return klg;
		} else
			tx.commit();
			return null;
	}

}
