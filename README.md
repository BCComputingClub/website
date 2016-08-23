# website
The BC Computing Club Website

# Updating the gallery page
To update `gallery.html` when you add new images, simply run the `make-gallery` script located in `images/`

To update *how* `gallery.html` is generated, modify the java code in `images/MakeGallery`, generate a runnable JAR file at `images/MakeGallery/MakeGallery.jar`. All subsequent runs of `make-gallery` will use the new JAR file you created.
