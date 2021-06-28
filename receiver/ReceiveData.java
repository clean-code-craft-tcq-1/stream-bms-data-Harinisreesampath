package receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReceiveData {
	Map<String, List<Double>> dataMap = new HashMap<>();

	public static void main(String args[]) throws IOException {
		int incomingCount = 14;
		String incomingData = "";
		int count = 0;
		try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				String line = lineReader.readLine();
				incomingData = incomingData.concat(line);
				System.out.println(incomingData);
				count++;
				if (incomingCount == count)
					break;
				
			}
		}
		System.out.println(incomingData);
		PrepareMap prepareMap = new PrepareMap();
		Map<String, List<Double>> map = prepareMap.prepareDataMap(incomingData);
		ReceiverAction receiver = new ReceiverAction();
		receiver.performAction(map);
	}

}
