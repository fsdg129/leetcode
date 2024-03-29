package binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,4,5};
		System.out.println(binarySearch(nums, 3));
		System.out.println(binarySearch(nums, 10));
	}
	
	public static int binarySearch(int[] nums, int target) {
		
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while(left <= right) {
			mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] < target){
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return -1;
	}
	
}
