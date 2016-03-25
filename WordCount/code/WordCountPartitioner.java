package wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner<Text, IntWritable> {
	@Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks) {
		// customize which <K ,V> will go to which reducer
        if (numReduceTasks == 0)
            return 0;
        String s = key.toString();
        if (s[0] >= 'A' && s[0] <= 'Z')
            return 1 % numReduceTasks;
        else
            return 2 % numReduceTasks;

		return 0;
	}
}
