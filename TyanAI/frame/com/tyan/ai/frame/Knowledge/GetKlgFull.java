/*package com.tyan.ai.frame.Knowledge;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tyan.ai.tool.HibernateUtil;


public class GetKlgFull implements GetKlg {

	@Override
	public String getKlg(long hash) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(hash);
		//tx.begin();
	    Ansterkng ak =  (Ansterkng) session.byId(Ansterkng.class).getReference( hash );
	    tx.commit();
	    return ak.getFullAnster();
		
	}
	

}
*/