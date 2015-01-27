package com.tyan.ai.frame.context;

import java.util.ArrayList;
import java.util.List;

import com.tyan.ai.frame.message.AALog;
import com.tyan.ai.frame.message.AskMessage;

public class ContextInfo {
	private  List<AALog> aalogs = new ArrayList<AALog>();
	private  boolean isWaitSet = false;
	private AskMessage bam;
	private int angryValue = 0;
	
	public AskMessage getBeSetAM(){
		return bam;
	}
	
	public boolean isAngry(){
		if(angryValue > 3)
			return true;
		return false;
	}
	
	public void forgive(){
		angryValue = 0;
	}
	
	public void angryUp(){
		angryValue++;
	}
	
	public boolean isWaitSet(){
		return isWaitSet;
	}
	
	public void setWaitSet(){
		isWaitSet = true;
	}
	
	public void setBeSetAM(AskMessage am){
		bam = am;
	}
	
	public void putAALog(AALog aalog){
		aalogs.add(aalog);
		isWaitSet = false;
		bam = null;
		if(aalogs.size() > 10)
			aalogs.remove(0);
	}
}
