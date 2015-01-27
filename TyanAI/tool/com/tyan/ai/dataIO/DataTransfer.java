package com.tyan.ai.dataIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.tyan.ai.frame.Knowledge.ZhidaoKnowledge;
import com.tyan.ai.synonymy.SynoConversion;
import com.tyan.ai.tool.HashTool;
import com.tyan.ai.tool.HibernateTool;
import com.tyan.ai.tool.nlp.NNVVFilter;

public class DataTransfer {
	public static void main(String[] args) throws IOException {
		File file = new File("/home/ub/part-m-00009");
		BufferedReader br = new BufferedReader(new FileReader(file),
				5 * 1024 * 1024);
		String line = null;// = br.readLine();
		// int i = 0;
		while (true) {
			// i++;
			line = br.readLine();
			if (line == null)
				break;
			String[] cells = line.split("','");
			if (cells.length < 8)
				continue;

			for (String cell : cells)
				if (cell.equals("null"))
					cell = null;
			String questiontitle = cells[1];
			int qtm = questiontitle.indexOf("?");
			if(qtm < 0)
				qtm = questiontitle.indexOf("？");
			if(qtm > 0)
				questiontitle = questiontitle.substring(0, qtm);
			// String fullquestion = cells[2];
			String bestanster = cells[4];
			String sanster1 = cells[5];
			String sanster2 = cells[6];
			String sanster3 = cells[7].substring(0, cells[7].length() - 1);

			String fuzzQT = NNVVFilter.getNNVV(questiontitle);
			String synQT = SynoConversion.getSynoSentence(fuzzQT);

			long qstHash = HashTool.BKDRHash(questiontitle);
			if (qstHash == 0)
				continue;
			long qstSynHash = HashTool.BKDRHash(synQT);
			long qstFuzzyHash = HashTool.BKDRHash(fuzzQT);
			ZhidaoKnowledge zklg = new ZhidaoKnowledge(questiontitle, qstHash,
					qstSynHash, qstFuzzyHash, bestanster, sanster1, sanster2,
					sanster3, null);
			HibernateTool.saveObject(zklg);
			System.out.println(cells[0] + " finished");

		}
	}
}
