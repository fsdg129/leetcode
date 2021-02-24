package sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = new int[] { 49, 38, 65, 97, 76, 13, 27, 49 };
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	
	public static void sort(int[] nums) {
		
		boolean swapped;
		int tmp;
		for(int i = 0; i<nums.length; i++) {
			
			swapped = false;
			
			for(int j = 0; j<nums.length - i - 1; j++) {
				
				if(nums[j] > nums[j+1]) {
					swapped = true;
					tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
			
			if(!swapped) {
				break;
			}
		}
		
		return;		
	}
}
