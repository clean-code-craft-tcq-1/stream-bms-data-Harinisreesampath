package receiver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareMap 
{
	Map<String, List<Double>> dataMap = new HashMap<>();
	
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
		for(int i=0;i<paramList.size();i++)
		{
			String[] data = paramList.get(i).split("=");
			dataMap.get(data[0]).add(Double.parseDouble(data[1]));
		}
		
	}

	public void setMapKey(List<String> paramList)
	{
		paramList.forEach(param -> {
			dataMap.put(param.split("=")[0], new ArrayList<>());
		});
	}

}