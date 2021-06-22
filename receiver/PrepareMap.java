package receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrepareMap 
{
	HashMap<String, List<Double>> dataMap = new HashMap<>();
	
	public HashMap<String, List<Double>> prepareDataMap(String incomingData) 
	{
		incomingData = incomingData.replaceAll("[{]", "").replaceAll("}", ", ");
		List<String> paramList = Arrays.asList(incomingData.split(", "));
		setMapKey(paramList);
		setMapValue(paramList);
		return dataMap;
	}
	
	public void setMapValue(List<String> paramList) 
	{
		paramList.forEach(param -> {
			String[] data = param.split("=");
			dataMap.get(data[0]).add(Double.parseDouble(data[1]));
		});
		
	}

	public void setMapKey(List<String> paramList)
	{
		paramList.forEach(param -> {
			dataMap.put(param.split("=")[0], new ArrayList<>());
		});
		
	}

}