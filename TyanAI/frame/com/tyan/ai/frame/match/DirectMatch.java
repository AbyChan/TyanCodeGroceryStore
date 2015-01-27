package com.tyan.ai.frame.match;

import org.hibernate.Session;

import com.tyan.ai.frame.Knowledge.ZhidaoKnowledge;
import com.tyan.ai.frame.Model.AIModel;
import com.tyan.ai.frame.context.ContextInfo;
import com.tyan.ai.frame.message.AskMessage;
import com.tyan.ai.frame.message.Message;
import com.tyan.ai.tool.HibernateUtil;

public class DirectMatch extends Match {
	
	
	//需要整改
	public DirectMatch(AskMessage msg, ContextInfo contextinfo, AIModel model) {
		this.msg = msg;
		long directhash = msg.getHashValue();

		
		Session session  = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        ZhidaoKnowledge zklg = (ZhidaoKnowledge) session.get(ZhidaoKnowledge.class, directhash);
        if(zklg != null){
			ismatch = true;
			anster = super.chooseAnster(zklg, contextinfo);
		}
        session.getTransaction().commit();
        
	}
}
