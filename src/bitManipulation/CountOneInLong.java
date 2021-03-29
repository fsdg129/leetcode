package bitManipulation;

import java.util.Scanner;

public class CountOneInLong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long number = sc.nextLong();
		System.out.println(countOne(number));

	}

	public static int countOne(long number) {
		int counter = 0;
		long current = number;
		while(current > 0) {
			counter += ( (current & 1) == 1 ? 1 : 0 );
			current = current >> 1;
		}
		
		return counter;
	}
}
