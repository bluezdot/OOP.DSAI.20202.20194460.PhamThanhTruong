package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Buffer or Builder?
public class NoGarbage {
	public static void main(String[] args) throws IOException {
		String filename = "test.txt";
		byte[] inputBytes = { 0 };

		inputBytes = Files.readAllBytes(Paths.get(filename));
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append((char) b);
		}
	}

}
