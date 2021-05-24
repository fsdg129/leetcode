package sort;

public class MergeSortedArray88 {

	private String name = "88. Merge Sorted Array";
	private String url = "https://leetcode.com/problems/merge-sorted-array/";
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for(int i=m-1; i>=0; i--) {
			nums1[i + n] = nums1[i];
		}
		
        int i=n, j=0, k=0;
        int fullLength = m + n;
        while(k < fullLength) {
        	if(i >= fullLength || (j < n && nums1[i] > nums2[j])) {
        		nums1[k] = nums2[j];
        		j++;
        	} else {
        		nums1[k] = nums1[i];
        		i++;
        	}
        	k++;
        }
        
        return;
    }
}
