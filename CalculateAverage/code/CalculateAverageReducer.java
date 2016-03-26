package calculateaverage;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CalculateAverageReducer extends Reducer<Text,SumCountPair,Text,DoubleWritable> {
    public void reduce(Text key, Iterable<SumCountPair> values, Context context) throws IOException, InterruptedException {
			  double sum = 0;
        double count = 0;
        // agrregate the amount of same starting character
        for (SumCountPair val: values) {
            sum += val.getSum();
            count += val.getCount();
        }
        // write the result
        context.write(key, new DoubleWritable(sum/count));
    }
}
