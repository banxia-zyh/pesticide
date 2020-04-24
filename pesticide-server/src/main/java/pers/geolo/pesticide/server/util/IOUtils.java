package pers.geolo.pesticide.server.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/14
 */
public class IOUtils {

    public static void connectStream(InputStream inputStream, OutputStream outputStream,
                                     int bufferSize) throws IOException {
        byte[] buffer = new byte[bufferSize];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    public static void connectStream(InputStream inputStream, OutputStream outputStream)
            throws IOException {
        connectStream(inputStream, outputStream, 1024);
    }
}
