package info.sanaulla.model;

import java.util.HashMap;

public class CustomMap<T> extends HashMap<String, T>{

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		String uKey = key.toString().toUpperCase();
		return super.containsKey(uKey);
	}

	@Override
	public T put(String key, T value) {
		// TODO Auto-generated method stub
		String uKey = key.toUpperCase();
		if ( containsKey(uKey)){
			return super.get(uKey);
		}else{
			return super.put(uKey, value);
		}
		
	}
	
}
