package Collection_filtering;

public class ArrayUtils {

	public static <T> T[] filter(T[] input, Filter<T> filter) {

	    if (input == null || filter == null) {
	        return null; 
	    }

	    // Create new array of same type and size
	    T[] result = input.clone();

	    for (int i = 0; i < input.length; i++) {
	        result[i] = filter.apply(input[i]); // apply logic
	    }

	    return result;
	}
}
