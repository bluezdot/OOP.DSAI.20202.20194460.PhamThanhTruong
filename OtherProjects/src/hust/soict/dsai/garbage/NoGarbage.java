package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Buffer or Builder?
public class NoGarbage {
	public static void main(String[] args) throws IOException {
		String filename = "D:\\Savage\\DS & AI - 20202\\OOP\\Work\\OOP.DSAI.20202.20194460.PhamThanhTruong\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.txt";
		byte[] inputBytes = { 0 };

		inputBytes = Files.readAllBytes(Paths.get(filename));
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append((char) b);
		}
	}
}