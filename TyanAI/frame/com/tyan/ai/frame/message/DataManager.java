package com.tyan.ai.frame.message;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tyan.ai.tool.HibernateUtil;



public class DataManager {
	
	public static void saveMessage(Message msg){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
        session.save(msg);
  //      tx.commit();

	}
	
	public static void main(String[] args) {
	//	Message xx = new AskMessage("fxucxkx");
	//	saveMessage(xx);
	}

}
