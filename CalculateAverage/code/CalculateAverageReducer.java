package calculateaverage;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CalculateAverageReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        // agrregate the amount of same starting character
        for (IntWritable val: values) {
            count += val.get();
        }
        // write the result
        context.write(key, new IntWritable(count));
    }
}
