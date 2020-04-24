package pers.geolo.pesticide.repository;

import java.io.IOException;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/14
 */
public interface FileRepository {

    FileInfo getFile(String id) throws IOException;

    String saveFile(FileInfo fileInfo) throws IOException;

    void removeFile(String id) throws IOException;
}
