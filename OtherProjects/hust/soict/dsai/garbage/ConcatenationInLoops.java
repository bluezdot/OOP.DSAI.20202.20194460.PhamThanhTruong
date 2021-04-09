package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConcatenationInLoops {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "test.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime, startTime2, endTime2, startTime3, endTime3;

		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b : inputBytes) {
			outputString += (char) b;
		}
		endTime = System.currentTimeMillis();
		System.out.println("Time using + operator: " + (endTime - startTime));

		startTime2 = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append((char) b);
		}
		endTime2 = System.currentTimeMillis();
		System.out.println("Time using StringBuilder: " + (endTime2 - startTime2));

		startTime3 = System.currentTimeMillis();
		StringBuffer outputStringBuffer = new StringBuffer();
		for (byte b : inputBytes) {
			outputStringBuffer.append((char) b);
		}
		endTime3 = System.currentTimeMillis();
		System.out.println("Time using StringBuffer: " + (endTime3 - startTime3));

	}

}
