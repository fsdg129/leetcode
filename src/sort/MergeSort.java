package sort;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSortApi(int[] nums) {
		int[] copy = Arrays.copyOf(nums, nums.length);
		mergeSort(copy, nums, 0, nums.length);
		
		return;
	}
	
	private static void mergeSort(int[] source, int[] target, int left, int right) {
		
		if(right - left <= 1)
			return;
		
		int mid = (left + right) / 2;
		mergeSort(target, source, left, mid);
		mergeSort(target, source, mid, right);
		
		merge(source, target, left, mid, right);
		
		return;
	}
	
	private static void merge(int[] source, int[] target, int left, int mid, int right) {
		
		int i=left, j=mid, k=left;
		
		while(k < right) {
			if(j >= right || (i < mid && source[i] < source[j])) {
				target[k] = source[i];
				i++;
			} else {
				target[k] = source[j];
				j++;
			}
			k++;
		}
		
		return;
	}
	
}
