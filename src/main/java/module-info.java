module robosub {
    requires javafx.graphics;
    requires opencv;
    requires org.apache.logging.log4j;
    requires org.jetbrains.annotations;
    requires static lombok;

    opens org.aadarshdevi.opencv to org.jetbrains.annotations;

    exports org.aadarshdevi.opencv;
    exports org.aadarshdevi;
}