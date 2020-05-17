package fle.toolBox;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public final class MapToJson {

	
	private final static JSONArray Converter(Map<String,? extends Object>toconvert) {
		JSONArray array = new JSONArray();
		toconvert.forEach((key, value) -> {
			JSONObject jSonObject = new JSONObject();
			jSonObject.put(key, value);
			array.put(jSonObject);
		});	
		return array;
	}
	
	public final static JSONArray ConvertMapToJson(LinkedHashMap<String,? extends Object>toconvert) {
		Map<String,? extends Object> map = new LinkedHashMap<>(toconvert);
		return Converter(map);
	}
	
	public final static JSONArray ConvertMapToJson(HashMap<String,? extends Object>toconvert) {
		Map<String,? extends Object> map = new HashMap<>(toconvert);
		return Converter(map);
	}
	
	
}
