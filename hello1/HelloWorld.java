import edu.duke.*;

public class HelloWorld {
	public void runHello () {
		FileResource res = new FileResource("gene.txt");
		//URLResource res = new URLResource("http://nytimes.com");
		// for (String line : res.words()) {
			// System.out.println(line);
		// }
		String alexa = res.asString();
		System.out.println(alexa);
	}
}
