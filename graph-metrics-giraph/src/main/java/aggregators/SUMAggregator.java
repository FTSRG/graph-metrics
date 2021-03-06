package aggregators;

import org.apache.giraph.aggregators.Aggregator;
import org.apache.hadoop.io.LongWritable;

public class SUMAggregator implements Aggregator<LongWritable> {

	LongWritable myValue;

	public void aggregate(LongWritable value) {
		myValue.set(myValue.get() + value.get());
	}

	public LongWritable createInitialValue() {
		return new LongWritable(0);
	}

	public LongWritable getAggregatedValue() {
		return myValue;
	}

	public void setAggregatedValue(LongWritable value) {
		myValue.set(value.get());
	}

	public void reset() {
		if (myValue == null) {
			myValue = new LongWritable(0);
		} else {
			myValue.set(0);
		}
	}
}
