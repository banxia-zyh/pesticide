package group.geolo.defectmanager.entity;

import group.geolo.defectmanager.repository.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/14
 */
public class MultipartFileInfo implements FileInfo {

    private MultipartFile multipartFile;

    public MultipartFileInfo(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getFilename() {
        return multipartFile.getOriginalFilename();
    }

    @Override
    public String getContentType() {
        return multipartFile.getContentType();
    }

    @Override
    public long getLength() {
        return multipartFile.getSize();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return multipartFile.getInputStream();
    }
}
