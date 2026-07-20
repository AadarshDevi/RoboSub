package org.aadarshdevi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class OCVTest {

    public static final Logger logger = LogManager.getLogger(OCVTest.class);

    class ImageTest {

        // store an image
        public static Mat loadImage(String fileName) {
            return Imgcodecs.imread(fileName);
        }

        // write an image
        public static void saveImage(Mat image, String fileName) {
            Imgcodecs.imwrite(fileName, image);
        }
    }


}
