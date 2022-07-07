package com.tjoeun.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

public class WordReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	private Logger logger = Logger.getLogger(WordMapper.class); // log4j Logger

	public void reduce(Text _key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		logger.info("_key: " + _key + ", values: " + values);
		int total = 0;
		for (IntWritable val : values) {
			total += val.get();
			logger.info("val: " + val + ", values: " + total);
		}
		context.write(_key, new IntWritable(total));
	}

}
