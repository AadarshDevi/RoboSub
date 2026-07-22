package org.aadarshdevi;

import org.aadarshdevi.learn.opencv.ImageRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {
    public static final Logger logger = LogManager.getLogger(Launcher.class);

    static void main(String[] args) {
        ImageRunner.run();
    }


}