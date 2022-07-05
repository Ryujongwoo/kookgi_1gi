package com.tjoeun.hadoop;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class WordCount {

	// Map
	public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
		
		// Map이 적용된 후 저장된 value 값 => 무조건 1이므로 final static
		private final static IntWritable one = new IntWritable(1);
		// Map이 적용된 후 저장될 key 값
        private Text word = new Text();
        
        // 입력 데이터 분석을 위해 Mapper 인터페이스의 map 메소드를 override 한다.
        @Override
        // map 메소드의 첫 번째 인수는 입력키, 두 번째 인수는 입력값으로 변수 타입은 Mapper 인터페이스 구현시 지정된 타입과 같아야 한다.
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
        	String line = value.toString();
        	// value를 공백 또는 탭을 구분자로 사용해서 분리한다.
        	StringTokenizer tokenizer = new StringTokenizer(line);
        	while (tokenizer.hasMoreTokens()) {
        		// 공백으로 분리된 value의 데이터를 OutputCollector 객체에 추가하기 위해서 저장한다.
        		word.set(tokenizer.nextToken());
        		// mapper의 출력 데이터에 key가 word 이고 value가 one인 데이터를 추가한다.
        		output.collect(word, one);
        	}
        }
        
	}

	// Reducer
	public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
		
		// 입력 데이터 분석을 위해 Reducer 인터페이스의 reduce 메소드를 override 한다.
        @Override
		public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
			int sum = 0;
			while (values.hasNext()) {
				sum += values.next().get();
			}
			output.collect(key, new IntWritable(sum));
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		// Job 객체의 라이브러리를 지정한다.
		JobConf conf = new JobConf(WordCount.class);
		conf.setJobName("wordcount");
		// Map 클래스 지정한다.
		conf.setMapperClass(Map.class);
		// Combine 클래스 지정한다.(Reduce 작업을 미리 진행하여 Reduce 작업을 최소화 한다.)
		conf.setCombinerClass(Reduce.class);
		// Reducer 클래스 지정한다.
		conf.setReducerClass(Reduce.class);
		// Reducer 클래스의 출력 데이터 key, value 타입을 설정한다.
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);
		// input, output에 대해 설정한다.
		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);
		// 입출과 출력 파일의 경로를 지정한다.
		FileInputFormat.setInputPaths(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		// Job을 실행한다.
		JobClient.runJob(conf);
		
	}
		
}




















