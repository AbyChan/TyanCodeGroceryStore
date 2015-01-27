package com.tyan.ai.frame.context;

import java.io.IOException;

import com.tyan.ai.frame.centerPerceptron.Perceptron;
import com.tyan.ai.frame.message.Message;
import com.tyan.ai.frame.Model.AIModel;;

public class Context {
	Perceptron perceptron;
	AIModel model;
	ContextInfo contextinfo;
	
	public Context() {
		perceptron = new Perceptron();
		model = new AIModel();
		contextinfo = new ContextInfo();
	}
	
	public String question(String sentence) throws IOException{
		String msg = perceptron.echo(sentence, contextinfo, model);
		return msg;
	}

}
