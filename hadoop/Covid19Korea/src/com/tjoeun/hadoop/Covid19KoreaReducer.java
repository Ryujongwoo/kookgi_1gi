package com.tjoeun.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

public class Covid19KoreaReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	static Logger logger = Logger.getLogger(Covid19KoreaReducer.class);

	public void reduce(Text _key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		
		int maxValue = Integer.MIN_VALUE; // 최대값을 기억할 기억 장소를 만들고 초기화한다.
		
		for (IntWritable val : values) {
			// 최대값을 계산한다.
			maxValue = Math.max(maxValue, val.get());
		}
		context.write(_key, new IntWritable(maxValue));
		
	}

}
