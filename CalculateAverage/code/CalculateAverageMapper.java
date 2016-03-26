package calculateaverage;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CalculateAverageMapper extends Mapper<LongWritable, Text, Text, SumCountPair> {

	private IntWritable one = new IntWritable(1);

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		// we simply use StringTokenizer to split the words for us.
		StringTokenizer itr = new StringTokenizer(value.toString());
		String k = itr.nextToken();
		int v = Integer.parseInt(itr.nextToken());
		context.write(new Text(k), new SumCountPair(v, 1));
		// create <K, V> pair
		// context.write(K,V);
	}
}
