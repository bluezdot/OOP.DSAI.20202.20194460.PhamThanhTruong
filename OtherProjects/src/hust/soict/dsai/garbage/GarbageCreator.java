package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "D:\\Savage\\DS & AI - 20202\\OOP\\Work\\OOP.DSAI.20202.20194460.PhamThanhTruong\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.txt";
		byte[] inputBytes = { 0 };

		inputBytes = Files.readAllBytes(Paths.get(filename));
		String outputString = "";
		for (byte b : inputBytes) {
			outputString += (char) b;
		}
	}

}