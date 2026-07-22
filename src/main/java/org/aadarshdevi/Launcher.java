package org.aadarshdevi;

import javafx.application.Platform;
import nu.pattern.OpenCV;
import org.aadarshdevi.opencv.CameraProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {
    public static final Logger logger = LogManager.getLogger(Launcher.class);

    static void main(String[] args) {
        logger.info("Project Running");

        OpenCV.loadLocally();
        logger.info("OpenPNP Initialized");

//        save and load image
//        Mat img = OCVTest.ImageTest.loadImage("D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/src/main/resources/org/aadarshdevi/test_img/PXL_20260711_222452843.MP.jpg");
//        OCVTest.ImageTest.saveImage(img, "D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/output/image.jpg");
//        logger.info("Image Saved and Written to Disk");

//         face detection
//         Mat imgLoaded = OCVTest.ImageTest.loadImage("D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/src/main/resources/org/aadarshdevi/test_img/PXL_20260711_222338052.jpg");
//         OCVTest.ImageFaceDetection.detectFace(imgLoaded);

        // real time face detection
        Platform.startup(() -> {
            // Put any code that creates JavaFX components (like Scene) in here
            CameraProcess cameraProcess = new CameraProcess();
            cameraProcess.displayImage(cameraProcess.captureImage());

            logger.info("JavaFX Initialized");
        });


    }


}