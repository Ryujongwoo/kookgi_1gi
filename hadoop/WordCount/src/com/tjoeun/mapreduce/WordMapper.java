package com.tjoeun.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private Logger logger = Logger.getLogger(WordMapper.class); // log4j Logger
	private final IntWritable one = new IntWritable(1);

//	iKey: 숫자, ivalue: 1라인의 문장, context: map 과정의 결과를 저장한다.
	public void map(LongWritable ikey, Text ivalue, Context context) throws IOException, InterruptedException {
		// hadoop 문자열 타입인 Text 타입의 객체를 String 타입으로 변경한 후 공백을 경계로 분할해 배열에 단어별로 저장한다.
		String line = ivalue.toString();
		String words[] = line.split(" ");
		// 각 단어에 단어의 개수 1을 붙인다.
		for (String word : words) {
			context.write(new Text(word), one);
			logger.info("word: " + word + ", one: " + one);
		}
	}

}













