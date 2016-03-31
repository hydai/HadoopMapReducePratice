package calculateaverage;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CalculateAverageMapper extends Mapper<LongWritable, Text, Text, SumCountPair> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		StringTokenizer itr = new StringTokenizer(value.toString());
		String k = itr.nextToken();
		int v = Integer.parseInt(itr.nextToken());
		context.write(new Text(k), new SumCountPair(v, 1));
	}
}
