package url.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class UrlTest {

	private static URLClassLoader urlClassLoader;

	public static void main(String[] args) throws MalformedURLException {
		// Getting the jar URL which contains target class
		URL[] classLoaderUrls = new URL[]{new URL("file:///files/test.json")};
		urlClassLoader = new URLClassLoader(classLoaderUrls);
		
				
	}

}
