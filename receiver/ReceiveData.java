package receiver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReceiveData 
{
	
	public static void main(String arg[]) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
		{
			String incomingData = reader.readLine();
			PrepareMap prepareMap = new PrepareMap();
			HashMap<String, List<Double>> map = prepareMap.prepareDataMap(incomingData);
			ReceiverAction receiver = new ReceiverAction();
			receiver.performAction(map);
			
		} 
		catch (Exception e) 
		{
			System.err.println(e);
		}
	}
}
