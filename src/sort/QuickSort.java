package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] nums = new int[] { 49, 38, 65, 97, 76, 13, 27, 49 };
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	
	public static void sort(int[] nums) {
		
		quickSort(nums, 0, nums.length - 1);	
	}
	
	private static void quickSort(int[] nums, int left, int right) {
		
		if(left >= right)
			return;
		
		int partition = partition(nums, left, right);
		quickSort(nums, left, partition);
		quickSort(nums, partition + 1, right);
		
		return;	
	}
	
	private static int partition(int[] nums, int left, int right) {
		
		int mid = (left + right) / 2;
		int pivot = nums[mid];
		
		int i = left - 1;
		int j = right + 1;
		int tmp;
		
		while(true) {
			
			while(true) {
				i++;
				if(nums[i] >= pivot) {
					break;
				}
			}
			
			while(true) {
				j--;
				if(nums[j] <= pivot) {
					break;
				}
			}
			
			if(i >= j) {
				return j;
			}
			
			tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			
		}
		
	}
}
