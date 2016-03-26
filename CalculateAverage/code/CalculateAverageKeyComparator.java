package calculateaverage;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class CalculateAverageKeyComparator extends WritableComparator {

    public CalculateAverageKeyComparator() {
        super(Text.class, true);
    }

    public int compare(WritableComparable o1, WritableComparable o2) {
        Text key1 = (Text) o1;
        Text key2 = (Text) o2;

        char c1 = key1.toString().charAt(0);
        char c2 = key2.toString().charAt(0);
        if (c1 == c2)
            return 0;
        else {
            if (c1 > c2)
                return 1;
            else
                return -1;
        }
    }
}
