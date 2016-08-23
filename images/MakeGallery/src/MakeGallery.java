import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * A simple Java program to generate {@code gallery.html}
 * 
 * @author cgerman
 *
 */
public class MakeGallery {
	private static String PRE_GALLERY_HTML;
	private static String POST_GALLERY_HTML;

	/**
	 * entry point for program
	 * 
	 * @param args
	 *            unused
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// get start time
		System.out.println("Generating gallery page...");
		long startTime = System.nanoTime();

		// build html
		String html = buildHTML();

		// open file for writing, clear previous contents
		File galleryFile = new File("../gallery.html");
		PrintWriter out = new PrintWriter(new FileWriter(galleryFile));

		// write html to file
		out.write(html);

		// close resource
		out.close();

		// get end time
		long endTime = System.nanoTime();
		System.out.println("done.");

		// display information to user
		long elapsedTimeMS = (endTime - startTime) / 1000000;
		System.out.println("Generated " + galleryFile + " in " + elapsedTimeMS + " ms.");
	}

	/**
	 * build the html for the new gallery.html page
	 * 
	 * @return an object containing the generated html code
	 */
	private static String buildHTML() {
		// set up variables
		String[] gallerySubdirs;
		String[] subdirFiles;
		StringBuilder html;
		initNonGalleryHTML(); // set up the private members

		// start building html before the gallery
		html = new StringBuilder(PRE_GALLERY_HTML);

		// get all subdirectories of "gallery/"
		gallerySubdirs = getSubDirs(new File("gallery/"));
		Arrays.sort(gallerySubdirs);

		// iterate across each subdirectory
		for (String dir : gallerySubdirs) {
			System.out.print("Making gallery for '" + dir + "'...");
			// start html for subdir
			html.append("<h3>" + dir + "</h3>\n");
			html.append("<div class=\"galleria\">\n");

			// get files in subdirectory
			subdirFiles = getDirFiles(new File("gallery/" + dir));
			Arrays.sort(subdirFiles);
			for (String file : subdirFiles) {
				// example: src="images/gallery/ACM2002/radford-02a.jpg"
				html.append("<img src=\"images/gallery/" + dir + "/" + file + "\">\n");
			}

			// close html for subdir
			html.append("</div>\n");
			System.out.println("done");
		}

		// add gallery scripts
		html.append("<script>\n");
		html.append("Galleria.loadTheme('galleria/themes/classic/galleria.classic.min.js');\n");
		html.append("Galleria.run('.galleria');\n");
		html.append("</script>\n");

		// build html after the gallery
		html.append(POST_GALLERY_HTML);

		return html.toString();
	}

	/**
	 * get subdirectories of given directory
	 * 
	 * @param dir
	 *            the directory to examine
	 * @return all the subdirectories of the given directory (individual files
	 *         are ignored)
	 */
	private static String[] getSubDirs(File dir) {
		return dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
	}

	/**
	 * get the files of the given directory
	 * 
	 * @param dir
	 *            the directory to examine
	 * @return all of the files in the directory (subdirectories are ignored)
	 */
	private static String[] getDirFiles(File dir) {
		return dir.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isFile();
			}
		});
	}

	/**
	 * initialize the non-gallery html (stored in private members). these are
	 * some VERY long strings, which is why the method for initializing them is
	 * way down here. if you want to reconstruct these in an HTML file, then
	 * just call {@code System.out.println(PRE_GALLERY_HTML);}
	 */
	private static void initNonGalleryHTML() {
		PRE_GALLERY_HTML = "<!DOCTYPE HTML>\n" + "<!--\n" + "    Arcana by HTML5 UP\n" + "    html5up.net | @n33co\n"
				+ "    Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)\n"
				+ "  -->\n" + "<html>\n" + "  <head>\n" + "    <title>BC3 - Gallery</title>\n"
				+ "    <meta charset=\"utf-8\" />\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n"
				+ "    <!--[if lte IE 8]><script src=\"assets/js/ie/html5shiv.js\"></script><![endif]-->\n"
				+ "    <link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n"
				+ "    <!--[if lte IE 8]><link rel=\"stylesheet\" href=\"assets/css/ie8.css\" /><![endif]-->\n"
				+ "    <!--[if lte IE 9]><link rel=\"stylesheet\" href=\"assets/css/ie9.css\" /><![endif]-->\n"
				+ "    \n" + "    <!-- image gallery scripts-->\n"
				+ "    <script src=\"assets/js/jquery.min.js\"></script><!-- Arcana jQuery -->\n"
				+ "    <script src=\"galleria/galleria-1.4.2.min.js\"></script>\n" + "\n"
				+ "    <!-- image gallery styling -->\n" + "    <style>\n"
				+ "      .galleria { width: 700px; height: 400px; background #000 }\n" + "    </style>\n"
				+ "  </head>\n" + "  <body>\n" + "    <div id=\"page-wrapper\">\n" + "\n" + "      <!-- Header -->\n"
				+ "      <div id=\"header\">\n" + "\n" + "	<!-- Logo -->\n"
				+ "	<h1><a href=\"index.html\" id=\"logo\">Bridgewater College Computing Club</a></h1>\n" + "\n"
				+ "	<!-- Nav -->\n" + "	<nav id=\"nav\">\n" + "	  <ul>\n" + "	    <li>\n"
				+ "	      <a href=\"index.html\">Home</a>\n" + "	    </li>\n" + "	    <li>\n"
				+ "	      <a href=\"about.html\">About Us</a>\n" + "	    </li>\n"
				+ "	    <li class=\"current\">\n" + "	      <a href=\"gallery.html\">Image Gallery</a>\n"
				+ "	    </li>\n" + "	    <li>\n" + "	      <a href=\"calendar.html\">Calendar</a>\n" + "	    </li>\n"
				+ "	  </ul>\n" + "	</nav>\n" + "\n" + "      </div>\n" + "\n" + "      <!-- Main -->\n"
				+ "      <section class=\"wrapper style1\">\n" + "	<div class=\"container\">\n"
				+ "	  <div id=\"content\">\n" + "\n" + "	    <!-- Content -->\n" + "\n" + "	    <article>\n"
				+ "	      <header>\n" + "		<h2>Image Gallery</h2>\n" + "	      </header>\n";
		POST_GALLERY_HTML = "	    </article>\n" + "\n" + "	  </div>\n" + "	</div>\n" + "      </section>\n" + "\n"
				+ "      <!-- Footer -->\n" + "      <div id=\"footer\">\n" + "	<div class=\"container\">\n"
				+ "	  <div class=\"row\">\n" + "	    <section class=\"3u 6u(narrower) 12u$(mobilep)\">\n"
				+ "	      <h3>Links</h3>\n" + "	      <ul class=\"links\">\n" + "		<li>\n"
				+ "		  <a href=\"http://www.bridgewater.edu\">Bridgewater College</a>\n" + "		</li>\n"
				+ "		<li>\n" + "		  <a href=\"http://www.codechef.com\">CodeChef</a>\n" + "		</li>\n"
				+ "		<li>\n" + "		  <a href=\"http://www.acm.org\">ACM</a>\n" + "		</li>\n"
				+ "	      </ul>\n" + "	    </section>\n" + "\n" + "	    <!-- get in touch -->\n"
				+ "	    <section class=\"6u 12u(narrower)\">\n" + "	      <h3>Get In Touch</h3>\n"
				+ "	      <form action=\"MAILTO:bccomputingclub@gmail.com\">\n" + "		<div class=\"row 50%\">\n"
				+ "		  <div class=\"6u 12u(mobilep)\">\n"
				+ "		    <input type=\"text\" name=\"name\" id=\"name\" placeholder=\"Name\" />\n"
				+ "		  </div>\n" + "		  <div class=\"6u 12u(mobilep)\">\n"
				+ "		    <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Email\" />\n"
				+ "		  </div>\n" + "		</div>\n" + "		<div class=\"row 50%\">\n"
				+ "		  <div class=\"12u\">\n"
				+ "		    <textarea name=\"message\" id=\"message\" placeholder=\"Message\" rows=\"5\"></textarea>\n"
				+ "		  </div>\n" + "		</div>\n" + "		<div class=\"row 50%\">\n"
				+ "		  <div class=\"12u\">\n" + "		    <ul class=\"actions\">\n" + "		      <li>\n"
				+ "			<input type=\"submit\" class=\"button alt\" value=\"Send Message\" />\n"
				+ "		      </li>\n" + "		    </ul>\n" + "		  </div>\n" + "		</div>\n"
				+ "	      </form>\n" + "	    </section>\n" + "	  </div>\n" + "	</div>\n" + "\n"
				+ "	<!-- Icons -->\n" + "	<ul class=\"icons\">\n" + "	  <!--\n" + "	      <li>\n"
				+ "		<a href=\"#\" class=\"icon fa-twitter\"><span class=\"label\">Twitter</span></a>\n"
				+ "	      </li>\n" + "	  <li>\n"
				+ "	    <a href=\"#\" class=\"icon fa-facebook\"><span class=\"label\">Facebook</span></a>\n"
				+ "	  </li>-->\n" + "	  <li>\n"
				+ "	    <a href=\"https://github.com/BCComputingClub\" class=\"icon fa-github\"><span class=\"label\">GitHub</span></a>\n"
				+ "	  </li>\n" + "	  <li>\n" + "	    <!--\n"
				+ "		<a href=\"#\" class=\"icon fa-linkedin\"><span class=\"label\">LinkedIn</span></a>\n"
				+ "	  </li>\n" + "	  <li>\n"
				+ "	    <a href=\"#\" class=\"icon fa-google-plus\"><span class=\"label\">Google+</span></a>\n"
				+ "	  </li>-->\n" + "	</ul>\n" + "\n" + "	<!-- Copyright -->\n" + "	<div class=\"copyright\">\n"
				+ "	  <ul class=\"menu\">\n" + "	    <li>\n"
				+ "	      &copy; 2016 Bridgewater College. All rights reserved\n" + "	    </li>\n" + "	    <li>\n"
				+ "	      Design: <a href=\"http://html5up.net\">HTML5 UP</a>\n" + "	    </li>\n" + "	  </ul>\n"
				+ "	</div>\n" + "\n" + "      </div>\n" + "\n" + "    </div>\n" + "\n" + "    <!-- Scripts -->\n"
				+ "    <script src=\"assets/js/jquery.dropotron.min.js\"></script>\n"
				+ "    <!--<script src=\"assets/js/jquery.min.js\"></script> loaded in <head> -->\n"
				+ "    <script src=\"assets/js/skel.min.js\"></script>\n"
				+ "    <script src=\"assets/js/util.js\"></script>\n"
				+ "    <!--[if lte IE 8]><script src=\"assets/js/ie/respond.min.js\"></script><![endif]-->\n"
				+ "    <script src=\"assets/js/main.js\"></script>\n" + "\n" + "  </body>\n" + "</html>";
	}
}