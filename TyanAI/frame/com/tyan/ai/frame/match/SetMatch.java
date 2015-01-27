package com.tyan.ai.frame.match;

import java.io.IOException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.tyan.ai.frame.Knowledge.ZhidaoKnowledge;
import com.tyan.ai.frame.message.AskMessage;
import com.tyan.ai.tool.HibernateTool;
import com.tyan.ai.tool.HibernateUtil;

public class SetMatch extends Match {
	public SetMatch(AskMessage am, AskMessage bam) {
		record(am, bam);
	}
	
	public void record(AskMessage am, AskMessage bam){
		String smartAnster = am.getMessage();
		Long qstHash = bam.getHashValue();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria c = session.createCriteria(ZhidaoKnowledge.class);
		c.add(Restrictions.eq("qstHash", qstHash));// eq是等于，gt是大于，lt是小于,or是或
		if (c.list().size() != 0) {
			ZhidaoKnowledge klg = (ZhidaoKnowledge) session.load(ZhidaoKnowledge.class, qstHash);
			klg.setSmartAnster(smartAnster);
		} else{
			ZhidaoKnowledge klg = new ZhidaoKnowledge(bam.getMessage(), bam.getHashValue(), bam.getSynonymousHash(), bam.getFuzzyHash(), null, null, null, null, smartAnster);
			session.save(klg);
		}
		tx.commit();
	}
	
	public static void main(String[] args) throws IOException {
		//test
		AskMessage a1 = new AskMessage("fuck");
		AskMessage a2 = new AskMessage("y");
		SetMatch s = new SetMatch(a1, a2);
		HibernateTool.releaseSeesion();
	}
}
