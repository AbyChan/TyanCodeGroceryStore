package ik;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Iktest {
	public static void main(String[] args) throws IOException {
		Reader text = new StringReader("味精对某些人，会有敏感症状，这是肯定的，但像有人对花生也产生过敏是一样的，原因怎么研究也研究不出来。 ");
		IKSegmenter iks = new IKSegmenter(text,true);
		Lexeme token;
		while ((token = iks.next()) != null)
        {
			System.out.println(token.getLexemeText());
        }
	}

}
