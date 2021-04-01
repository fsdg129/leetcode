package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

	private List<Integer> tree = new ArrayList<>();
	
	public static void main(String[] args) {
		int[] nums = new int[] { 49, 38, 65, 97, 76, 13, 27, 49 };
		MinHeap heap = new MinHeap();
		for(int num : nums) {
			heap.add(num);
		}
		for(int i=0; i<nums.length; i++) {
			nums[i] = heap.remove();
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public MinHeap() {
		super();
	}
	
	public void clear() {
		this.tree.clear();
	}
	
	public Integer peek() {
		if(this.tree.size() == 0)
			return null;
		return this.tree.get(0);
	}
	
	public void add(Integer number) {
		this.tree.add(number);
		int currentIndex = this.tree.size() - 1;
		int parentIndex = this.parentIndex(currentIndex);
		while(this.tree.get(currentIndex) < this.tree.get(parentIndex)) {
			this.swap(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = this.parentIndex(currentIndex);
		}
		
		return;
	}
	
	public Integer remove() {
		if(this.tree.size() == 0)
			return null;
		if(this.tree.size() == 1)
			return this.tree.remove(0);
		
		this.swap(0, this.tree.size() - 1);
		Integer min = this.tree.remove(this.tree.size() - 1);
		heapify(0);
		
		return min;
	}
	
	private void heapify(int index) {
		int leftIndex = this.leftChildIndex(index);
		Integer left = leftIndex > this.tree.size() - 1? Integer.MAX_VALUE : this.tree.get(leftIndex);
		int rightIndex = this.rightChildIndex(index);
		Integer right = rightIndex > this.tree.size() - 1? Integer.MAX_VALUE : this.tree.get(rightIndex);
		
		int smallIndex;
		Integer small;
		if(left.compareTo(right) <= 0) {
			smallIndex = leftIndex;
			small = left;
		} else {
			smallIndex = rightIndex;
			small = right;
		}
		
		if(this.tree.get(index).compareTo(small) <= 0)
			return;
		this.swap(index, smallIndex);
		this.heapify(smallIndex);
		
		return;
	}
	
	private int parentIndex(int childIndex) {
		if(childIndex == 0)
			return childIndex;
		if(childIndex % 2 == 0)
			return childIndex / 2 - 1;
		else
			return ( childIndex - 1 ) / 2;
	}
	
	private int leftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	private int rightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	private void swap(int a, int b) {
		Integer tmp = this.tree.get(a);
		this.tree.set(a, this.tree.get(b));
		this.tree.set(b, tmp);		
	}
	
}
