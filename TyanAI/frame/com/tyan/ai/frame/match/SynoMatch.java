package com.tyan.ai.frame.match;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.tyan.ai.frame.Knowledge.ZhidaoKnowledge;
import com.tyan.ai.frame.Model.AIModel;
import com.tyan.ai.frame.context.ContextInfo;
import com.tyan.ai.frame.message.AskMessage;
import com.tyan.ai.frame.message.Message;
import com.tyan.ai.math.TRandom;
import com.tyan.ai.tool.HibernateUtil;

public class SynoMatch extends Match {
	
	public SynoMatch(AskMessage msg, ContextInfo contextinfo, AIModel model) {
		this.msg = msg;
		long qstSynHash = msg.getSynonymousHash();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		Criteria c = session.createCriteria(ZhidaoKnowledge.class);
		c.add(Restrictions.eq("qstSynHash", qstSynHash));// eq是等于，gt是大于，lt是小于,or是或
		if (c.list().size() != 0) {
			int r = TRandom.getRandomInt(c.list().size());
			ZhidaoKnowledge zklg = (ZhidaoKnowledge) c.list().get(r);
			ismatch = true;
			anster = super.chooseAnster(zklg, contextinfo);
		}
		session.getTransaction().commit();
	}

}
