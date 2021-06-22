package receiver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReceiveData {

	public static void main(String arg[]) throws IOException 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			String incomingData = "";
			//read data from console as a string
			while (sc.hasNext()) {
				incomingData = incomingData.concat(sc.nextLine());
			}
			
			PrepareMap prepareMap = new PrepareMap();
			Map<String, List<Double>> map = prepareMap.prepareDataMap(incomingData);
			System.out.println(map.get("Temperature"));
			ReceiverAction receiver = new ReceiverAction();
			receiver.performAction(map);

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
