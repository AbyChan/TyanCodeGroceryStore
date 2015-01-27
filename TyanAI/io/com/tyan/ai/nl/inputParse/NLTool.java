package com.tyan.ai.nl.inputParse;
import org.lionsoul.jcseg.ASegment;
import org.lionsoul.jcseg.core.ADictionary;
import org.lionsoul.jcseg.core.DictionaryFactory;
import org.lionsoul.jcseg.core.JcsegException;
import org.lionsoul.jcseg.core.JcsegTaskConfig;
import org.lionsoul.jcseg.core.SegmentFactory;

import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class NLTool {
	public static JcsegTaskConfig config = new JcsegTaskConfig(
			"bin/jcseg.properties");
	public static ADictionary dic = DictionaryFactory
			.createDefaultDictionary(config);
	public static ASegment seg;

	static {
		try {
			 seg = (ASegment) SegmentFactory.createJcseg(
					JcsegTaskConfig.COMPLEX_MODE, new Object[] { config, dic });
		} catch (JcsegException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MaxentTagger tagger = new MaxentTagger(
			"chinese-distsim.tagger");
	public static LexicalizedParser lp = LexicalizedParser
			.loadModel("edu/stanford/nlp/models/lexparser/chinesePCFG.ser.gz");

}
