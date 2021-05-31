package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SendData {
	public static String TEMPERATURE = "Temperature";
	public static String SOC = "State of Charge";
	
	public static float getRandomValue(IStreamData readings) {
		return readings.getBMSData();
	}

	public static ArrayList<HashMap<String, Float>> getData(IStreamData readings, int readingLimit) {
		if(readings == null)
			return null;
		
			ArrayList dataList = new ArrayList();
			while(readingLimit > 0) {
				HashMap<String, Float> bmsParams = new HashMap<String, Float>();
				bmsParams.put(SendData.TEMPERATURE, getRandomValue(readings));
				bmsParams.put(SendData.SOC, getRandomValue(readings));
				dataList.add(bmsParams);
				printToConsole(bmsParams);
				readingLimit--;
		}
			return dataList;
	}
	
	public static void printToConsole(HashMap<String, Float> bmsParams) {
		System.out.println(bmsParams);
	}

	public static void main(String[] args) {
		IStreamData streamData = new RandomValues();
		int readingLimit = 15;
		getData(streamData, readingLimit);
	}

}
