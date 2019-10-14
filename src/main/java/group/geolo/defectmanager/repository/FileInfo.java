package group.geolo.defectmanager.repository;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/14
 */
public interface FileInfo {

    String getId();

    String getFilename();

    String getContentType();

    long getLength();

    InputStream getInputStream() throws IOException;
}
