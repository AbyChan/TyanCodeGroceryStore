package com.tyan.ai.frame.centerPerceptron;

import java.io.IOException;
import java.util.Date;

import com.tyan.ai.frame.Model.AIModel;
import com.tyan.ai.frame.context.ContextInfo;
import com.tyan.ai.frame.filter.PreSetFilter;
import com.tyan.ai.frame.match.DirectMatch;
import com.tyan.ai.frame.match.FuzzMatch;
import com.tyan.ai.frame.match.Match;
import com.tyan.ai.frame.match.SetMatch;
import com.tyan.ai.frame.match.SynoMatch;
import com.tyan.ai.frame.message.AALog;
import com.tyan.ai.frame.message.AnsterMessage;
import com.tyan.ai.frame.message.AskMessage;
import com.tyan.ai.frame.message.Message;
import com.tyan.ai.tool.HibernateTool;

public class Anster {

	public AnsterMessage reaction(String sentence, ContextInfo contextinfo,
			AIModel model) throws IOException {
		// AskMessage am = new AskMessage(sentence);
		AskMessage am = null;
		AnsterMessage astm = null;
		Date date = new Date();
		if (PreSetFilter.isSetQuestion(sentence)) {
			sentence = sentence.substring(1);
			am = new AskMessage(sentence);
			Match m = new SetMatch(am, contextinfo.getBeSetAM());
			return (new AnsterMessage("谢谢，我会在后台理解处理并收录。^_^"));
		} else {
			am = new AskMessage(sentence);
			Match m = new DirectMatch(am, contextinfo, model);

			if (m.match()) {
				astm = m.anster();
			} else {
				m = new FuzzMatch(am, contextinfo, model);
				if (m.match())
					astm = m.anster();
				else{
					m = new SynoMatch(am, contextinfo, model);
					if(m.match())
						astm = m.anster();
				}
			}
		}
		if(astm != null){
			HibernateTool.saveObject(new AALog(date, am, astm));
			return astm;
		}
		contextinfo.setWaitSet();
		contextinfo.setBeSetAM(am);
		return (new AnsterMessage("对不起，我理解不了您的意思，如果您想教我怎么回答，请回复@+答案，谢谢。"));
	}
	
	public AnsterMessage angry() {
		AnsterMessage m = new AnsterMessage(
				"I am angry!I will not answer your questions.");
		return m;
	}

	public AnsterMessage languageError() {
		AnsterMessage m = new AnsterMessage(
				"Sorry, this system does not support non-Chinese language now.");
		return m;
	}

}
