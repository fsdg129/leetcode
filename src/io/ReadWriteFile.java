package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ReadWriteFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("./testfiles/test");
		System.out.println( file.getCanonicalPath() );
		//file.mkdirs();
		
		byte[] content = new byte[10];
		content[0] = 0x01;
		content[1] = 0x7f;
		content[2] = 13;
		content[3] = -11;
		
		try(OutputStream output = new FileOutputStream(file)) {
			
			output.write(content);
		}
		
		byte[] buffer = new byte[20];
		try(InputStream input = new FileInputStream(file)){
			int result = 0;
			while(true) {
				result = input.read(buffer);
				if(result < 0) {
					break;
				}
				System.out.println(result);
				System.out.println(Arrays.toString(buffer));
			}
			 
		}
		
		File textFile = new File("./testfiles/test.txt");
		FileReader reader = new FileReader(textFile, StandardCharsets.UTF_8);		
		try(reader){
			int result = 0;
			while(true) {
				char[] bufferReader = new char[20];
				result = reader.read(bufferReader);
				if(result < 0)
					break;
				System.out.println(Arrays.toString(bufferReader));
			}			
		}
		
		return;
	}

}
