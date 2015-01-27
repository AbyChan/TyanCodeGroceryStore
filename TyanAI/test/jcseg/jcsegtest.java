package jcseg;

import java.io.IOException;
import java.io.StringReader;

import org.lionsoul.jcseg.ASegment;
import org.lionsoul.jcseg.core.ADictionary;
import org.lionsoul.jcseg.core.DictionaryFactory;
import org.lionsoul.jcseg.core.IWord;
import org.lionsoul.jcseg.core.JcsegException;
import org.lionsoul.jcseg.core.JcsegTaskConfig;
import org.lionsoul.jcseg.core.SegmentFactory;

public class jcsegtest {
	public static void main(String[] args) throws IOException, JcsegException {
		JcsegTaskConfig config = new JcsegTaskConfig("bin/jcseg.properties");
		//创建默认词库(即: com.webssky.jcseg.Dictionary 对象)
		//并且依据给定的 JcsegTaskConfig 配置实例自主完成词库的加载
		ADictionary dic = DictionaryFactory
		.createDefaultDictionary(config);
		//依据给定的ADictionary和JcsegTaskConfig来创建ISegment
		//通常使用SegmentFactory#createJcseg来创建ISegment对象
		//将config和dic组成一个Object数组给SegmentFactory.createJcseg方法
		//JcsegTaskConfig.COMPLEX_MODE表示创建ComplexSeg复杂ISegment分词对象
		//JcsegTaskConfig.SIMPLE_MODE表示创建SimpleSeg简易Isegmengt分词对象.
		ASegment seg = (ASegment) SegmentFactory.createJcseg(JcsegTaskConfig.COMPLEX_MODE,
		new Object[]{config, dic});
		//设置要分词的内容
		String str = "研究生命起源的四分之一。";
		seg.reset(new StringReader(str));
		//获取分词结果
		IWord word = null;
		while ( (word = seg.next()) != null ) {
		System.out.println(word.getValue());
		System.out.println(word.getPinyin());
		}

	}

}
