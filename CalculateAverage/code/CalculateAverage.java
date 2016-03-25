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
		//job.setMapperClass(xxx.class);
		//job.setCombinerClass(xxx.class);
		//job.setPartitionerClass(xxx.class);
		//job.setSortComparatorClass(xxx.class);
		//job.setReducerClass(xxx.class);
		
		// set the output class of Mapper and Reducer
		//job.setMapOutputKeyClass(Text.class);
		//job.setMapOutputValueClass(SumCountPair.class);
		//job.setOutputKeyClass(xxx.class);
		//job.setOutputValueClass(xxx.class);
		
		// set the number of reducer
		//job.setNumReduceTasks(xxx);
		
		// add input/output path
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
