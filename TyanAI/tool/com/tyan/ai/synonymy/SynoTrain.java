package com.tyan.ai.synonymy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SynoTrain {

	
	public  static HashMap<String, String> train(String filename){
		String context = "";
		
		//List<String> syno = new ArrayList<String>();
		HashMap<String, String> syno = new HashMap<String, String>();
		try {

			String encoding = "utf-8";
			File file = new File(filename);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String wordcs = "";
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println(lineTxt);
					String[] words = lineTxt.split(" ");
					String head = words[0].substring(0, words[0].length()-1);
					if(containsChinese(head)){
						for(int i=0; i<words.length; i++){
							syno.put(words[i], wordcs);
						}
						
					}else{
						for(int i=1; i<words.length-1; i++){
							wordcs = head;
							syno.put(words[i], wordcs);
						}
					}
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		} finally {
			//System.out.println(syno);
		}
		return syno;
	}
	
/*	public static void main(String[] args) {
		SynoTrain test = new SynoTrain("/home/ub/Corpus/HIT-CIR_LTP_Sharing_Package_Full_v2.0.1/HIT_CIR_LTP_Corpora_v2.0/HIT-CIR Tongyici/HIT-CIRTongyiciCilin(Extended).txt");
		HashMap<String, String> syno = test.train();
		for(int i=0; i<1000; i++){
			System.out.println(syno.keySet().toArray()[i]);
			System.out.println(syno.get(syno.keySet().toArray()[i]));
		}
	}*/
	
	public static HashMap<String, String> getSynoHM(){
		return train("/home/ub/Corpus/HIT-CIR_LTP_Sharing_Package_Full_v2.0.1/HIT_CIR_LTP_Corpora_v2.0/HIT-CIR Tongyici/HIT-CIRTongyiciCilin(Extended).txt");
	}
	
	public static boolean isChinese(char a) {
		int v = (int) a;
		return (v >= 19968 && v <= 171941);
	}

	public static boolean containsChinese(String s) {
		if (null == s || "".equals(s.trim()))
			return false;
		for (int i = 0; i < s.length(); i++) {
			if (isChinese(s.charAt(i)))
				return true;
		}
		return false;
	}

}
