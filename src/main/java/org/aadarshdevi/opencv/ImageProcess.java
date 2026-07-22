package org.aadarshdevi.opencv;

import org.aadarshdevi.Launcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageProcess {

    public static final Logger logger = LogManager.getLogger(ImageProcess.class);

    public static void saveImage(Mat image, Path path) {
        Imgcodecs.imwrite(path.toAbsolutePath().toString(), image);
    }

    public static Mat loadImage(Path path) {
        return Imgcodecs.imread(path.toAbsolutePath().toString());
    }

    public static Mat detectFace(@NotNull Mat image) throws URISyntaxException {
        MatOfRect facesDetected = new MatOfRect();

        CascadeClassifier cc = new CascadeClassifier();
        int minFaces = Math.round(image.rows() * 0.1f);

        // url to the face detection config file
        URL url = Launcher.class.getResource("haarcascade_frontalface_default.xml");

        if (url == null) {
            return null;
        }

        // filepath of the image
        String classifierUrl = Paths.get(url.toURI()).toString();

        // load image to face detector
        cc.load(classifierUrl);

        // detect and draw rectangles on faces
        cc.detectMultiScale(
                image,
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
            Imgproc.rectangle(image, face.tl(), face.br(), new Scalar(0, 0, 255), 10);
        }

        return image;
    }

}
