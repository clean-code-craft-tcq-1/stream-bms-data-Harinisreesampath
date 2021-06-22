import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import receiver.ReceiverAction;

public class ReceiverTest {

	@Test(expected = IndexOutOfBoundsException.class)
	public void givenEmptyListPassedWhenGetMaxMin_thenThrowsInIndexOutOfBoundsException() throws IndexOutOfBoundsException {
		// when
		String paramName = "Temperature";
		Double[] valueArray = {};
		List<Double> valueList = Arrays.asList(valueArray);
		// then
		ReceiverAction.getMinAndMaxReadings(paramName, valueList);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullValuePassedWhenGetMaxMin_givenValueListPassedWhenGetAverage_thenOutPutMessage() throws NullPointerException {
		// then
		ReceiverAction.getMinAndMaxReadings(null, null);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void givenEmptyListPassedWhenGetaverage_thenThrowsInIndexOutOfBoundsException() throws IndexOutOfBoundsException {
		// when
		String paramName = "Temperature";
		Double[] valueArray = {};
		List<Double> valueList = Arrays.asList(valueArray);
		// then
		ReceiverAction.getSimpleMovingAverage(paramName, valueList);
	}

	@Test(expected = NullPointerException.class)
	public void givenNullValuePassedWhenGetAverage_givenValueListPassedWhenGetAverage_thenOutPutMessage() throws NullPointerException {
		// then
		ReceiverAction.getSimpleMovingAverage(null, null);
	}

}