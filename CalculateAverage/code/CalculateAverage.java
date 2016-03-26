package calculateAverage;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CalculateAverage {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = Job.getInstance(conf, "CalculateAverage");
		job.setJarByClass(CalculateAverage.class);
		
		// set the class of each stage in mapreduce
		job.setMapperClass(CalculateAverageMapper.class);
		job.setCombinerClass(CalculateAverageCombiner.class);
		job.setPartitionerClass(CalculateAveragePartitioner.class);
		job.setSortComparatorClass(CalculateAverageKeyComparator.class);
		job.setReducerClass(CalculateAverageReducer.class);
		
		// set the output class of Mapper and Reducer
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(SumCountPair.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(SumCountPair.class);
		
		// set the number of reducer
		job.setNumReduceTasks(2);
		
		// add input/output path
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
