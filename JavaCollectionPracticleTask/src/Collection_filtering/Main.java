package Collection_filtering;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Integer []arr= {1,2,5,9,8};
		Integer newArr[]=ArrayUtils.filter(arr, new Filter<Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t*2;
			}
			
		});
		
		Iterable<Integer> as=Arrays.asList(newArr);
		
		// print the new array
		
		System.out.println(as);
		
	}
}
