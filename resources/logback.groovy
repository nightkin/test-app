import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender

import static ch.qos.logback.classic.Level.INFO
import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.ERROR

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%date{dd MMM yyyy HH:mm:ss.SSS} %-7relative [%-20thread] %-5level %logger - %msg %n"
    }
}

appender("FILE", FileAppender) {
    file = "logging.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%date{dd MMM yyyy HH:mm:ss.SSS} %-7relative [%-20thread] %-5level %logger - %msg %n"
    }
}

root(INFO, ["STDOUT"])
root(ERROR, ["STDOUT", "FILE"])

logger("org.hibernate.SQL", INFO);
logger("org.apache.commons.httpclient.HttpMethodBase", ERROR);