package com.tyan.ai.hadoop;

import java.io.IOException;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.tyan.ai.frame.Knowledge.ZhidaoKnowledge;
import com.tyan.ai.synonymy.SynoConversion;
import com.tyan.ai.tool.HashTool;
import com.tyan.ai.tool.HibernateTool;
import com.tyan.ai.tool.nlp.NNVVFilter;

public class ParseZhidaoData {
	
	public static class ParseMap extends
			Mapper<Object, Text, Text, IntWritable> {

		//private final static IntWritable one = new IntWritable(1);
		//private Text word = new Text();

		public void map(Object key, Text value, Context context)
				throws IOException, InterruptedException {

			byte[] bt = value.getBytes();
			String vv = new String(bt);
			String[] cells = vv.split("','");
			
			for(String cell : cells)
				if(cell.equals("null"))
					cell = null;
			String questiontitle = cells[1];
			String fullquestion = cells[2];
			String bestanster = cells[4];
			String sanster1 = cells[5];
			String sanster2 = cells[6];
			String sanster3 = cells[7].substring(0, cells[7].length()-1);
			
			String fuzzQT = NNVVFilter.getNNVV(questiontitle);
			String synQT = SynoConversion.getSynoSentence(fuzzQT);
			
			long qstHash = HashTool.BKDRHash(questiontitle);
			long qstSynHash = HashTool.BKDRHash(synQT);
			long qstFuzzyHash = HashTool.BKDRHash(fuzzQT);
			ZhidaoKnowledge zklg = new ZhidaoKnowledge(questiontitle, qstHash, qstSynHash, qstFuzzyHash, bestanster, sanster1, sanster2, null, null);
			
			/*if(bestanster.equals("null"))
				bestanster = null;
			String simpleAnster = null;
			if(!sanster1.equals("null"))
				simpleAnster = sanster1;
			else if(!sanster2.equals("null"))
				simpleAnster = sanster2;
			else if(!sanster3.equals("null"))
				simpleAnster = sanster3;
			*/
			//ZhidaoKnowledge zklg = new ZhidaoKnowledge(questiontitle, qstHash, qstSynHash, qstFuzzyHash, bestanster, simpleAnster, null);
			HibernateTool.saveObject(zklg);
			
			
			
			System.out.println(questiontitle);
			System.out.println(fullquestion);
			System.out.println(bestanster);
			System.out.println(sanster1);
			System.out.println(sanster2);
			System.out.println(sanster3);
		}
	}
	
	public static class IntSumReducer extends
			Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();

		public void reduce(Text key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : values) {
				sum += val.get();
			}
			result.set(sum);
			context.write(key, result);
		}
	}

	 public static void main(String[] args) throws Exception {

           Random random = new Random();
		 
		    Configuration conf = new Configuration();
		    String[] otherArgs = {"hdfs://localhost:9000/user/mysqldata2",
		    "hdfs://localhost:9000/usr/local/hadoop/output/"+random.nextInt()};
		    
		    if (otherArgs.length != 2) {
		      System.err.println("Usage: wordcount <in> <out>");
		      System.exit(2);
		    }
		    Job job = new Job(conf, "word count");
		    
		    job.setJarByClass(ParseZhidaoData.class);
		    job.setMapperClass(ParseMap.class);
		  //job.setCombinerClass(IntSumReducer.class);
		//    job.setReducerClass(IntSumReducer.class);
		//    job.setOutputKeyClass(Text.class);
		//    job.setOutputValueClass(IntWritable.class);
		    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		    System.exit(job.waitForCompletion(true) ? 0 : 1);
		  }
}
