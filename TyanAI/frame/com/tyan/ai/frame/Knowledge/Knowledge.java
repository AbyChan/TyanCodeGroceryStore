package com.tyan.ai.frame.Knowledge;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tyan.ai.tool.*;

public class Knowledge {
	long qstHash;
	long qstSynHash;
	long astFuzzyHash;
	long ansterHash;
	public static void main(String[] args) {
		Knowledge l = new Knowledge();
		l.setQstHash(1);
		l.setQstSynHash(2);
		l.setAstFuzzyHash(3);
		l.setAnsterHash(4);
	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
        session.save(l);
        tx.commit();
	}

	public long getQstHash() {
		return qstHash;
	}
	public void setQstHash(long qstHash) {
		this.qstHash = qstHash;
	}
	public long getQstSynHash() {
		return qstSynHash;
	}
	public void setQstSynHash(long qstSynHash) {
		this.qstSynHash = qstSynHash;
	}
	public long getAstFuzzyHash() {
		return astFuzzyHash;
	}
	public void setAstFuzzyHash(long astFuzzyHash) {
		this.astFuzzyHash = astFuzzyHash;
	}
	public long getAnsterHash() {
		return ansterHash;
	}
	public void setAnsterHash(long ansterHash) {
		this.ansterHash = ansterHash;
	}
	
	

}
