package receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReceiveData {
	Map<String, List<Double>> dataMap = new HashMap<>();

	public static void main(String args[]) throws IOException {
		int incomingCount = 15;
		String incomingData = "";
		int count = 0;
		try (BufferedReader lineReader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				String line = lineReader.readLine();
				if(line != null && line.contains("{Temperature"))
				{
					incomingData = incomingData.concat(line);
					count++;
				}
				if (incomingCount == count)
					break;
				
			}
		}
		PrepareMap prepareMap = new PrepareMap();
		Map<String, List<Double>> map = prepareMap.prepareDataMap(incomingData);
		System.out.println("Temp:"+map.get("Temperature"));
		System.out.println("State of Charge:"+map.get("State of Charge"));
		ReceiverAction receiver = new ReceiverAction();
		receiver.performAction(map);
	}
}
