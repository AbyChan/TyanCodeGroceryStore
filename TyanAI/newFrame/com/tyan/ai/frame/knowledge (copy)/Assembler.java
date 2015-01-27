package com.tyan.ai.frame.knowledge;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tyan.ai.frame.segMap.InputEntry;

public class Assembler {
	private static HashMap<String, String> attribute;
	static{
		attribute = new HashMap<String, String>(); 
		try {
			loadAttribute();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadAttribute() throws DocumentException {
		SAXReader reader = new SAXReader();
		// 通过read方法读取一个文件 转换成Document对象
		Document document = reader.read(new File(
				"newFrame/com/tyan/ai/frame/knowledge/attribute.xml"));
		Element root = document.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> nodes = root.elements("attribute");
		for (Element node : nodes) {
			attribute.put(node.element("name").getText(), node.element("feature").getText());
		}
	}

	
	public static KnowledgeModel makeKlgModel(String modelClass,String name, List<Entry<String, String>> input) {
		KnowledgeModel model = null;
		switch (modelClass) {
		case "People":
			model = new PeopleModel(name);
			putAttribute(model, input);
			break;
		default:
			break;
		}
		return model;
	}
	
	
	public static void putAttribute(KnowledgeModel model, List<Entry<String, String>> input){
		for(Entry<String, String> ie : input){
			if(attribute.containsKey(ie.getKey())){
				model.addAttribute(ie.getKey(), ie.getValue());
			}else{
				System.out.println("Attribute input error : " + model.getClass() + model.getName());
			}
		}
	}
	
	public static void main(String[] args) throws DocumentException {
		loadAttribute();
	}
}
