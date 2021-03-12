package parser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public abstract class Util {

	static String readFile(String path)  throws IOException{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}

}
