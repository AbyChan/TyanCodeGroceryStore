/*package clustering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.clustering.Cluster;
import org.apache.mahout.clustering.kmeans.KMeansDriver;
import org.apache.mahout.common.distance.EuclideanDistanceMeasure;
import org.apache.mahout.math.RandomAccessSparseVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.math.VectorWritable;

import com.thoughtworks.xstream.io.path.Path;

public class SimpleKMeansClustering {
	public static final double[][] points = { {1, 1}, {2, 1}, {1, 2},
		{2, 2}, {3, 3}, {8, 8}, {9, 8}, {8, 9}, {9, 9}};
		public static void writePointsToFile(List<Vector> points,
		String fileName, FileSystem fs, Configuration conf)
		throws IOException {
		Path path = new Path(fileName);
		SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf,
		path, LongWritable.class, VectorWritable.class);
		long recNum = 0;
		VectorWritable vec = new VectorWritable();
		for (Vector point : points) {
		vec.set(point);
		writer.append(new LongWritable(recNum++), vec);
		}
		writer.close();
		}
		public static List<Vector> getPoints(double[][] raw) {
		List<Vector> points = new ArrayList<Vector>();
		for (int i = 0; i < raw.length; i++) {
		double[] fr = raw[i];
		Vector vec = new RandomAccessSparseVector("vector: "
		+ String.valueOf(i), fr.length);
		vec.assign(fr);
		points.add(vec);
		}
		return points;
		}
		public static void main(String args[]) throws Exception {
		int k = 2;

		List<Vector> vectors = getPoints(points);
		File testData = new File("testdata");
		if (!testData.exists()) {
		testData.mkdir();
		}
		testData = new File("testdata/points");
		if (!testData.exists()) {
		testData.mkdir();
		}
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		writePointsToFile(vectors, "testdata/points/file1", fs, conf);
		Path path = new Path("testdata/clusters/part-00000");

		SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf,
		path, Text.class, Cluster.class);
		for (int i = 0; i < k; i++) {
		Vector vec = vectors.get(i);
		Cluster cluster = new Cluster(vec, i);
		cluster.addPoint(cluster.getCenter());
		writer.append(new Text(cluster.getIdentifier()), cluster);
		}
		writer.close();
		KMeansDriver.runJob("testdata/points", "testdata/clusters",
		"output", EuclideanDistanceMeasure.class.getName(), 0.001,
		10, 1);

		SequenceFile.Reader reader = new SequenceFile.Reader(fs,
		new Path("output/points/part-00000"), conf);
		Text key = new Text();
		Text value = new Text();
		while (reader.next(key, value)) {
		System.out.println(key.toString() + " belongs to cluster "
		+ value.toString());
		}
		reader.close();

		}



}
*/