package sendingemail;

import java.io.File;

//Windows solution to view a PDF file

/**
 *
 * @author Hossam
 */
public class OpenPdf {

	public static void open(String name) {

	  try {

		if ((new File(name+".pdf")).exists()) {

			Process p = Runtime
			   .getRuntime()
			   .exec("mina.pdf");
			p.waitFor();

		} else {

			System.out.println("File is not exists");

		}

		System.out.println("Done");

  	  } catch (Exception ex) {
		ex.printStackTrace();
	  }

	}
}