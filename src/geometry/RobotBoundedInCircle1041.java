package geometry;

public class RobotBoundedInCircle1041 {

	private String name = "1041. Robot Bounded In Circle";
	private String url = "https://leetcode.com/problems/robot-bounded-in-circle/";
	
	public static void main(String[] args) {
		String instructions = "RLLGLRRRRGGRRRGLLRRR";
		isRobotBounded(instructions);
	}
	
	public static boolean isRobotBounded(String instructions) {
		Point p = new Point();
        for(char c : instructions.toCharArray())
        	p.step(c);
        return p.comeBack();
    }
	
	private static class Point {
		private int x = 0;
		private int y = 0;
		private int xDelta = 0;
		private int yDelta = 1;
		
		public void step(char c) {
			if(c == 'G')
				forward();
			else if(c == 'L')
				turnLeft();
			else if(c == 'R')
				turnRight();
			else
				;
			
//			System.out.printf("x: %d, y: %d, xDelta: %d, yDelta: %d, step: %s\n", x, y, 
//					xDelta, yDelta, String.valueOf(c));
			return;
		}
		
		public boolean comeBack() {
			
			return ( x == 0 && y == 0 ) || yDelta != 1;
		}
		
		
		private void forward() {
			this.x += this.xDelta;
			this.y += this.yDelta;
			
			return;
		}
		
		private void turnLeft() {
			int originalXDelta = this.xDelta;
			this.xDelta = -this.yDelta;
			this.yDelta = originalXDelta;
			
			return;
		}
		
		private void turnRight() {
			int originalXDelta = this.xDelta;
			this.xDelta = this.yDelta;
			this.yDelta = -originalXDelta;
		}
		
	}
}
