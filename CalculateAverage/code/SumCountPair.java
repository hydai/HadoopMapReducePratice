package calculateAverage;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class SumCountPair implements Writable {

	private int sum;
	private int count;

	public SumCountPair() {
		
	}
	
	public SumCountPair(int sum, int count) {
		//TODO: constructor
	}

	@Override 
	public void write(DataOutput out) throws IOException {
		// out.writeInt()
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// in.readInt()
	}
	
	public int getSum() {
		return sum;
	}
	
	public int getCount() {
		return count;
	}
	
}
