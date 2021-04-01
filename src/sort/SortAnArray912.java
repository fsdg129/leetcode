package sort;

import java.util.Arrays;

public class SortAnArray912 {

	private String name = "912. Sort an Array";
	private String url = "https://leetcode.com/problems/sort-an-array/";
	
    public int[] sortArray(int[] nums) {
        
    	Arrays.sort(nums);
    	return nums;
    }
    
	//Merge Sort
    public int[] sortArrayMergeSort(int[] nums) {
    	
    	mergeSortApi(nums);
    	return nums;
    }
    
    public static void mergeSortApi(int[] nums) {
    	
    	int[] copyArray = Arrays.copyOf(nums, nums.length);
    	mergeSort(copyArray, 0, nums.length, nums);
    	
    	return;
    }
    
    private static void mergeSort(int[] source, int start, int end, int[] target) {
        
    	if(end - start == 1) {
    		return;
    	}
    	
    	int mid = (start + end) / 2;
    	mergeSort(target, start, mid, source);
    	mergeSort(target, mid, end, source);
    	
    	merge(source, start, mid, end, target);
    	
    	return;	
    }
    
    private static void merge(int[] source, int start, int mid, int end, int[] target) {
    	
    	//index for the left array
    	int i = start;
    	//index for the right array
    	int j = mid;
    	//index for the target array
    	int k = start;
    	
    	while(k < end) {
    		
    		if(i >= mid || (j < end && source [j] < source[i]) ) {
    			target[k] = source [j];
    			j++;
    		} else {
    			target[k] = source [i];
    			i++;
    		}
    		k++;
    	}
    	
    	return;
    	
    }
}
