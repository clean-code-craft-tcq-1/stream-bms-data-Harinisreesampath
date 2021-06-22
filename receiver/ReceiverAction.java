package receiver;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReceiverAction {
	
	public void performAction(Map<String, List<Double>> dataList) 
	{
		ReceiverAction receiver = new ReceiverAction();
		receiver.performReceiverOperation(dataList);
		Result.printToConsole();
		
	}

	public void performReceiverOperation(Map<String, List<Double>> readings) {
		readings.forEach((paramName,readingList) -> {
			getMinAndMaxReadings(paramName,readingList);
				getSimpleMovingAverage(paramName,readingList);
		});
	}

	public static void getSimpleMovingAverage(String paramName, List<Double> readingList) {
		try{
			double average = readingList.subList(readingList.size()-5, readingList.size()).stream()
	        .mapToDouble(d -> d)
	        .average()
	        .orElse(0.0);
			Result.setAverageMessage(paramName,average);
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException();
		}
	}

	public static void getMinAndMaxReadings(String paramName,List<Double> readingList) {
		Double minValue = readingList.stream().sorted().collect(Collectors.toList()).get(0);
		Double maxValue = readingList.stream().sorted().collect(Collectors.toList()).get(readingList.size() - 1);
		Result.setMaxAndMinValueMessage(paramName, minValue, maxValue);
	}
}
