package sender;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestSender {
	private IStreamData streamData;
	ArrayList dataList;
	int readingLimit;
	
	@Before
	public void executedBeforeEach() {
		streamData = new RandomValues();
		readingLimit = 5;		
	}

	@Test
	public void givenData_whenNull_thenReturnNull() {
		assertNull(SendData.getData(null, readingLimit));
	}
	
	@Test
	public void givenReadingLimit_whenZero_thenReturnNull() {
		dataList = SendData.getData(streamData, 0);
		assertEquals(0,dataList.size());
	}
	
	@Test
	public void givenReadingLimit_whenGivenValue_thenReturnDataWithSizeOfGivenValue() {
		dataList = SendData.getData(streamData, 5);
		assertEquals(5,dataList.size());
	}
	

}
