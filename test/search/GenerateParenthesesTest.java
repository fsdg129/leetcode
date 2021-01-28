package search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class GenerateParenthesesTest {

	@Test
	void test() {
		GenerateParentheses22 gp = new GenerateParentheses22();
		List<String> result = gp.generateParenthesis(2);
		assertEquals(2, result.size());
	}
	
	@Test
	void testDFS() {
		GenerateParentheses22 gp = new GenerateParentheses22();
		List<String> result = gp.generateParenthesisDFS(2);
		assertEquals(2, result.size());
	}
	
	@Test
	void testDFS2() {
		GenerateParentheses22 gp = new GenerateParentheses22();
		List<String> result = gp.generateParenthesisDFS2(2);
		System.out.println(String.join(";", result));
		assertEquals(2, result.size());
	}

}
