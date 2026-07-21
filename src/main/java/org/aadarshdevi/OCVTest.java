package org.aadarshdevi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class OCVTest {

    public static final Logger logger = LogManager.getLogger(OCVTest.class);

    static class ImageTest {

        /**
         * load an image
         */
        public static Mat loadImage(String fileName) {
            return Imgcodecs.imread(fileName);
        }

        /**
         * save an image
         */
        public static void saveImage(Mat image, String fileName) {
            Imgcodecs.imwrite(fileName, image);
        }
    }

    static class ImageFaceDetection {
        public static void detectFace() throws URISyntaxException {
            // load image
            Mat imgLoaded = OCVTest.ImageTest.loadImage("D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/src/main/resources/org/aadarshdevi/test_img/PXL_20260711_222338052.jpg");
            logger.info("Image loaded");

            // store faces in a MatOfRect obj
            MatOfRect facesDetected = new MatOfRect();

            // CascadeClassifier detects the faces
            CascadeClassifier cc = new CascadeClassifier();
            int minFaces = Math.round(imgLoaded.rows() * 0.1f);

            // url to the face detection config file
            URL url = Launcher.class.getResource("haarcascade_frontalface_default.xml");
            logger.info(url);

            // filepath of the image
            String filename = Paths.get(url.toURI()).toString();

            // load image to face detector
            cc.load(filename);

            // detect and draw rectangles on faces
            cc.detectMultiScale(
                    imgLoaded,
                    facesDetected,
                    1.1,
                    3,
                    Objdetect.CASCADE_SCALE_IMAGE,
                    new Size(minFaces, minFaces),
                    new Size()
            );

            // store the data of the faces
            Rect[] facesArray = facesDetected.toArray();

            // draw a red border around the faces
            for (Rect face : facesArray) {
                Imgproc.rectangle(imgLoaded, face.tl(), face.br(), new Scalar(0, 0, 255), 10);
            }

            // save the image
            OCVTest.ImageTest.saveImage(imgLoaded, "D:/College/Miramar Community College/Clubs/Miramar Engineering Club/2027_RoboSub/RoboSub/output/boxed.jpg");
        }
    }


}
