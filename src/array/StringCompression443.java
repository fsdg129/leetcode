package array;

public class StringCompression443 {

	private String name = "443. String Compression";
	private String url = "https://leetcode.com/problems/string-compression/";

	public int compress(char[] chars) {
		int readIndex = chars.length - 2;
		int writeIndex = chars.length - 1;
		char pre = chars[chars.length - 1];
		int count = 1;
		int offset;
		while (readIndex >= 0) {
			if (chars[readIndex] == pre) {
				readIndex--;
				count++;
				continue;
			}
			offset = writeTimes(pre, writeIndex, count, chars);
			writeIndex -= offset;
			count = 1;
			pre = chars[readIndex];
			readIndex--;
		}
		offset = writeTimes(pre, writeIndex, count, chars);
		writeIndex -= offset;

		for (int i = writeIndex + 1; i < chars.length; i++) {
			chars[i - writeIndex - 1] = chars[i];
		}

		return chars.length - writeIndex - 1;
	}

	private static int writeTimes(char letter, int writeIndex, int count, char[] chars) {
		if (count == 1) {
			chars[writeIndex] = letter;
			return 1;
		}
		char[] countNumber = String.valueOf(count).toCharArray();
		for (int i = 0; i < countNumber.length; i++) {
			chars[i + writeIndex - countNumber.length + 1] = countNumber[i];
		}
		chars[writeIndex - countNumber.length] = letter;
		return countNumber.length + 1;
	}

}
