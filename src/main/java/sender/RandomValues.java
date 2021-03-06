package sender;

import java.util.Random;
import java.text.DecimalFormat;

public class RandomValues implements IStreamData {
	/**
	 * Generated random float values
	 */
	@Override
	public float getBMSData() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return Float.parseFloat(decimalFormat.format(new Random().nextFloat() * 100));
	    }

}
