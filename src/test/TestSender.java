package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import main.IStreamData;
import main.RandomValues;
import main.SendData;

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
