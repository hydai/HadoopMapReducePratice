package calculateaverage;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class CalculateAveragePartitioner extends Partitioner<Text, SumCountPair> {
	@Override
		public int getPartition(Text key, SumCountPair value, int numReduceTasks) {
			// customize which <K ,V> will go to which reducer
			if (numReduceTasks == 0)
				return 0;
			String s = key.toString();
			if (s.charAt(0) >= 'a' && s.charAt(0) <= 'g')
				return 0 % numReduceTasks;
			else
				return 1 % numReduceTasks;
		}
}
