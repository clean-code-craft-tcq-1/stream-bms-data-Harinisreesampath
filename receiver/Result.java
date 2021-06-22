package receiver;

import java.util.ArrayList;
import java.util.List;

public class Result {
	
	static List<String> message = new ArrayList<>();
	
	public static void setAverageMessage(String paramName, Double average) {
		message.add(String.format("Average of last 5 values for %s : %s%n",paramName,average));
	}
	
	public static void setMaxAndMinValueMessage(String paramName, Double minValue, Double maxValue) {
		message.add(String.format("Minimum %s : %s %nMaximum %s : %s%n", paramName,minValue,paramName,maxValue));
	}
	
	public static void printToConsole() {
		for(String msg : message)
			System.out.println(msg);
	}
	
}
