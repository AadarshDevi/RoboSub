#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};

#end
#parse("File Header.java")
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ${NAME} {

    public static final Logger logger = LogManager.getLogger(${NAME}.class);

}
