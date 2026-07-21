package org.aadarshdevi;

import nu.pattern.OpenCV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Launcher {
    public static final Logger logger = LogManager.getLogger(Launcher.class);

    static void main(String[] args) throws MalformedURLException, URISyntaxException {
        logger.info("Project Running");

        OpenCV.loadLocally();
        logger.info("OpenCV Initialized");

        // save and load image
        /*

        Mat img = OCVTest.ImageTest.loadImage("D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/src/main/resources/org/aadarshdevi/test_img/PXL_20260711_222452843.MP.jpg");
        OCVTest.ImageTest.saveImage(img, "D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/output/image.jpg");
        logger.info("Image Saved and Written to Disk");
        */

        // face detection
        // OCVTest.ImageFaceDetection.detectFace();

    }


}