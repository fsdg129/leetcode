package sort;

import java.util.Random;

public class KthLargestElementInAnArray215 {

	private String name = "215. Kth Largest Element in an Array";
	private String url = "https://leetcode.com/problems/kth-largest-element-in-an-array/";
	
    public int findKthLargest(int[] nums, int k) {
        
    	return quickSearchApi(nums, nums.length + 1 - k);
    }
    
    //Find the Kth least number in an array and return its value
    public static int quickSearchApi(int[] nums, int k) {
    	
    	Random r = new Random();
    	return quickSearchIterative(nums, 0, nums.length - 1, k, r); 	
    }
       
    private static int quickSearchIterative(int[] nums, int left, int right, int k, Random r) {
    	
    	int pivotIndex = (int) (left + (right - left) * r.nextDouble());
    	int partitionIndex = partition(nums, left, right, pivotIndex);
    	if(partitionIndex + 1 == k) {
    		return nums[partitionIndex];
    	} else if(partitionIndex + 1 > k) {
    		return quickSearchIterative(nums, left, partitionIndex - 1, k, r);
    	} else {
    		return quickSearchIterative(nums, partitionIndex + 1, right, k, r);
    	}

    }
    
    private static int partition(int[] nums, int left, int right, int pivotIndex) {
    	
    	swap(nums, right, pivotIndex);
    	
    	int pivot = nums[right];
    	//The element before this index is lower than pivot
    	int partitionIndex = left;
    	
    	for(int i=left; i<right; i++) {
    		if(nums[i] < pivot) {
    			swap(nums, i, partitionIndex);
    			partitionIndex++;
    		}
    	}
    	swap(nums, partitionIndex, right);
    	
    	return partitionIndex;
    }
    
    private static void swap(int[] nums, int a, int b) {
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    	
    	return;
    }
}
