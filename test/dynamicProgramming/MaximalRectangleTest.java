package dynamicProgramming;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximalRectangleTest {

	@Test
	void test() {
		char[][] matrix = new char[][] {
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'}
		};
		
		MaximalRectangle85 mr = new MaximalRectangle85();
		
		int maxArea = mr.maximalRectangle(matrix);
		assertEquals(6, maxArea);
		
	}

}
