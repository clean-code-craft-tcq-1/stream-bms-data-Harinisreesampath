package receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareMap 
{
	HashMap<String, List<Double>> dataMap = new HashMap<>();
	
	public Map<String, List<Double>> prepareDataMap(String incomingData) 
	{
		incomingData = incomingData.replaceAll("[{]", "").replaceAll("}", ", ");
		List<String> paramList = Arrays.asList(incomingData.split(", "));
		setMapKey(paramList); 
		setMapValue(paramList);
		return dataMap;
	}
	
	public void setMapValue(List<String> paramList) 
	{
		for(String param : paramList)
		{
			String[] data = param.split("=");
			dataMap.get(data[0]).add(Double.parseDouble(data[1]));
		}
		
	}

	public void setMapKey(List<String> paramList)
	{
		for(int i=0;i<paramList.size();i++)
			dataMap.put(paramList.get(i).split("=")[0], new ArrayList<>());
		
	}

}
