package recommender;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.similarity.*;
import org.slf4j.impl.StaticLoggerBinder;

import java.io.*;
import java.util.*;

public class RecommenderIntro {

	public static void main(String[] args) throws TasteException, IOException {
		DataModel model = new FileDataModel(new File("intro.csv"));
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,
				similarity, model);
		Recommender recommender = new GenericUserBasedRecommender(model,
				neighborhood, similarity);
		List<RecommendedItem> recommendations = recommender.recommend(1, 1);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
	}
}
