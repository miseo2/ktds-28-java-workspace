package com.ktdsuniversity.edu.oop.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTest {

	public static void main(String[] args) {
		
		//내가 읽고싶은 파일을 저장한다.
		File textFile = new File("/User/codemar");
		
		
		if (textFile.exists() && textFile.isFile()) {
			
			//파일을 읽어주는 객체를 선언한다.
			//java.io.FileReader
			FileReader reader = null;
			BufferedReader bufferedReader = null;

			
			BufferedReader bufferedReader = new BufferedReader(reader);
			try {
				reader = new FileReader(textFile);
				
				bufferedReader = new BufferedReader(reader);
				String line = null;
				while ( (line = bufferedReader.readLine()) != null ) {
					System.out.println(line);

				}

			} catch(FileNotFoundException fnfn){
				System.out.println(fnfn.getMessage());
				fnfn.printStackTrace();
			} catch(IOException ioe) {
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			} finally {
				try {
					befferedReader.close();					
				} catch(IOException ioe) {}
				try {
					reader.close();										
				} catch (IOEIOException ioe) {}
				
			}
			
			
		}
	}
}
