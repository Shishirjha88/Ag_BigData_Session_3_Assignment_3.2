package question_1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class FilterInvalidMapper extends Mapper<LongWritable,Text,NullWritable,Text> {
	
	NullWritable key;
	Text line;
	
	public void setup(Context context){
		//key = new NullWritable();
		line = new Text();
	}
	
	public void map(LongWritable key1, Text v1, Context context)
	 				throws IOException, InterruptedException{
		String lineArray = v1.toString();
		
		line = new Text(lineArray);
		
		if(!lineArray.contains("NA")){
			context.write(key,line);
		}
	}

}