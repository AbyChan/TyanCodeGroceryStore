/*package com.tyan.ai.frame.Knowledge;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.NaturalId;

import com.tyan.ai.tool.HibernateUtil;
@Entity
public class Ansterkng {
	@NaturalId
	long ansterHash;
	long synHash;
	long fuzzyHash;
	String fullAnster;
	String simpleAnster;
	String smartAnster;
	public static void main(String[] args) {
		Ansterkng l = new Ansterkng();
		l.setAnsterHash(4);
		l.setSynHash(5);
		l.setFuzzyHash(6);
		l.setFullAnster("fuck you");
		l.setSimpleAnster("fuck");
		l.setSmartAnster("happly fuck");
	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
        session.save(l);
        tx.commit();
	}

	public long getSynHash() {
		return synHash;
	}

	public void setSynHash(long synHash) {
		this.synHash = synHash;
	}

	public long getFuzzyHash() {
		return fuzzyHash;
	}

	public void setFuzzyHash(long fuzzyHash) {
		this.fuzzyHash = fuzzyHash;
	}

	public long getAnsterHash() {
		return ansterHash;
	}

	public void setAnsterHash(long ansterHash) {
		this.ansterHash = ansterHash;
	}

	public String getFullAnster() {
		return fullAnster;
	}

	public void setFullAnster(String fullAnster) {
		this.fullAnster = fullAnster;
	}

	public String getSimpleAnster() {
		return simpleAnster;
	}

	public void setSimpleAnster(String simpleAnster) {
		this.simpleAnster = simpleAnster;
	}

	public String getSmartAnster() {
		return smartAnster;
	}

	public void setSmartAnster(String smartAnster) {
		this.smartAnster = smartAnster;
	}

}
*/