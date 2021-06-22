package sender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SendData {
	public static String TEMPERATURE = "Temperature";
	public static String SOC = "State of Charge";
	
	/**
	 * Gets the random float values
	 * @param readings
	 * @return random float value
	 */
	public static float getRandomValue(IStreamData readings) {
		return readings.getBMSData();
	}

	/**
	 * Reads the generated random float value and structures the readings as temperature and soc
	 * @param readings - random value generator interface object
	 * @param readingLimit - number of readings to process 
	 * @return sender value (temperature & soc) with the specified limit
	 */
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
	
	/**
	 * Prints the generated random float values to the console
	 * In the format "{Temperature=85.88, State of Charge=49.51}
					  {Temperature=21.42, State of Charge=14.84}.."
	 * @param bmsParams - the float random data readings
	 */
	public static void printToConsole(HashMap<String, Float> bmsParams) {
		System.out.println(bmsParams);
	}

	public static void main(String[] args) {
		IStreamData streamData = new RandomValues();
		int readingLimit = 15;
		getData(streamData, readingLimit);
	}

}
