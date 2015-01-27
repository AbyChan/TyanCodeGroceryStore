package com.tyan.ai.frame.centerPerceptron;

import java.io.IOException;

import com.tyan.ai.frame.Model.AIModel;
import com.tyan.ai.frame.context.ContextInfo;
import com.tyan.ai.frame.filter.InputFilter;
import com.tyan.ai.frame.message.AnsterMessage;
import com.tyan.ai.frame.message.Message;

public class Perceptron {

	public String echo(String sentence, ContextInfo contextinfo, AIModel model)
			throws IOException {
		return MsgtoString(reaction(sentence, contextinfo, model));
	}

	public Message reaction(String sentence, ContextInfo contextinfo,
			AIModel model) throws IOException {
		Anster anster = new Anster();
		if (InputFilter.isChinese(sentence)) {
			return anster.reaction(sentence, contextinfo, model);
		} else if (contextinfo.isAngry()) {
			return anster.angry();
		} else {
			return anster.languageError();
		}
	}

	public String MsgtoString(Message msg) {
		return msg.getMessage();
	}

}
