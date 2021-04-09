package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "test.txt";
		byte[] inputBytes = { 0 };

		inputBytes = Files.readAllBytes(Paths.get(filename));
		String outputString = "";
		for (byte b : inputBytes) {
			outputString += (char) b;
		}
	}

}
