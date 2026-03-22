package collection_count_of_elements;

import java.util.HashMap;
import java.util.Map;

public class CollectionCountOfElements {
	
	public Map<Object, Object> countCollectionElement(Object[] a){
		
		Map<Object, Object> newMap=new HashMap<>();
		
		for(Object s:a) {
			
			if(newMap.containsKey(s)) {
                int count = (int) newMap.get(s);
                newMap.put(s, count + 1);
            } else {
                newMap.put(s, 1);
            }
		}

		
		return newMap;
		
	}

	public static void main(String[] args) {
		
		CollectionCountOfElements colleOfElements=new CollectionCountOfElements();
		
		Integer []a= {2,1,2,3,3,3,7,7,9,4,4,4,4};
		
		Map<Object, Object> newMap=colleOfElements.countCollectionElement(a);
		
		for(Map.Entry<Object, Object> sadf:newMap.entrySet()) {
			
			System.out.println("key"+" "+sadf.getKey()+"    "+"value"+" "+sadf.getValue());
			
		}
		
	}
	
}
