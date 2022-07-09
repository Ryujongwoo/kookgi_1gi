package com.tjoeun.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

//	Mapper<입력키, 입력값, 출력키, 출력값>
//	하둡은 최적화된 직렬화를 위해서 내장된 java 타입 대신에 자체적으로 기본 typeset을 가지고 있다.
//	입력키, 입력값: 입력 데이터, 초기 데이터 셋
//	출력키, 출력값: 입력 데이터로 map() 메소드에서 처리된 결과를 기억시킨다.
public class Covid19KoreaMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	static Logger logger = Logger.getLogger(Covid19KoreaMapper.class);
	int iCaseTotal = 0;
	
	// ikey에는 입력키가 넘어오고 ivalue에는 입력값이 넘어온다.
	// context에는 reduce로 넘기기 위한 데이터를 저장한다.
	public void map(LongWritable ikey, Text ivalue, Context context) throws IOException, InterruptedException {

		logger.info("ikey: " + ikey + ", ivalue: "+ ivalue);
		PropertyConfigurator.configure("log4j.properties");
		
		Text date; // 입력 데이터 중 날짜를 기억할 객체를 선언한다.
		String str_caseTotal; // 입력 데이터 중 날짜별 발병자 수를 기억할 객체를 선언한다.
		
		String line = ivalue.toString(); // 입력값을 문자열로 변환한다.
		String CovidData[] = line.split(","); // 문자열로 변환된 입력값을 ","를 경계로 나눈다.
		
		date = new Text(CovidData[0]); // 날짜를 저장한다.
		str_caseTotal = CovidData[2]; // 발병자 수를 저장한다.
		
		// covid19-download.csv 파일의 첫 줄은 데이터가 아니라 컬럼 이름이므로 처리하지 않는다.
		if(isNumberic(str_caseTotal) == true) {
			iCaseTotal = Integer.parseInt(str_caseTotal);
			context.write(date, new IntWritable(iCaseTotal));
		}
		
	}

	public static boolean isNumberic(String strNum) {
		if(strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
}
