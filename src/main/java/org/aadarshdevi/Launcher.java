package org.aadarshdevi;

import nu.pattern.OpenCV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opencv.core.Mat;

public class Launcher {
    public static final Logger logger = LogManager.getLogger(Launcher.class);

    static void main(String[] args) {
        logger.info("Project Running");

        OpenCV.loadLocally();
        logger.info("OpenCV Initialized");

        Mat img = OCVTest.ImageTest.loadImage("C:/Users/CryosArtic/Downloads/Photos-1-001/PXL_20260711_222452843.MP.jpg");
        OCVTest.ImageTest.saveImage(img, "D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/output/image.jpg");
        logger.info("Image Saved and Written to Disk");
    }


}
