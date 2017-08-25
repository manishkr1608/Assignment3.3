
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class Mapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	public void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String[] lineArray = value.toString().split(",");
		
		String company = lineArray[0];
		String product = lineArray[1];
		Text outputKey = new Text(company);
		IntWritable outputValue = new IntWritable(1);
		
		if(company.equals("NA") == false && product.equals("NA") == false)
		{
			context.write(outputKey, outputValue);
		}
	}
}
