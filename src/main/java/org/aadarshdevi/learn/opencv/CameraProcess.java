package org.aadarshdevi.learn.opencv;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import java.io.ByteArrayInputStream;
import java.net.URISyntaxException;

public class CameraProcess {

    public static final Logger logger = LogManager.getLogger(CameraProcess.class);
    public VideoCapture videoCapture;
    public ImageView imageView;
    public BorderPane borderPane;
    public Scene scene;
    public Stage stage;
    public MatOfByte matOfByte;
    public Mat mat;
    @Getter
    @Setter
    private long TARGET_FPS = 15;

    public CameraProcess() {
        videoCapture = new VideoCapture(0);
        imageView = new ImageView();
        borderPane = new BorderPane(imageView);
        scene = new Scene(borderPane);
        stage = new Stage();
        matOfByte = new MatOfByte();
        mat = new Mat();

        videoCapture.set(Videoio.CAP_PROP_FRAME_WIDTH, 1280);
        videoCapture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 720);

        stage.setScene(scene);
        stage.setTitle("CameraView");
        stage.show();
    }

    public Image captureImage() {
        mat.release();
        videoCapture.read(mat);
        if (mat.empty())
            return null;
        return mat2img(mat);
    }

    public Image mat2img(Mat mat) {
        matOfByte.release();
        Imgcodecs.imencode(".png", mat, matOfByte);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(matOfByte.toArray());
        return new Image(byteArrayInputStream);
    }

    public void displayImage() {
        AnimationTimer animationTimer = new AnimationTimer() {

            // Set target FPS (e.g., 30 FPS = ~33.3ms interval, 15 FPS = ~66.6ms)

            private final long INTERVAL_NS = 1_000_000_000L / TARGET_FPS;
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {

                if (now - lastUpdate < INTERVAL_NS) {
                    return;
                }

                lastUpdate = now;

                try {
                    Image image = faceDetectImage();

                    if (image != null) {
                        imageView.setImage(image);
                    }

                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        animationTimer.start();
    }

    public Image faceDetectImage() throws URISyntaxException {
        mat.release();
        videoCapture.read(mat);
        if (mat.empty())
            return null;
        Mat haarClassifiedImage = ImageProcess.detectFace(mat);
        logger.info("Processed Image");
        return mat2img(haarClassifiedImage);
    }

}
