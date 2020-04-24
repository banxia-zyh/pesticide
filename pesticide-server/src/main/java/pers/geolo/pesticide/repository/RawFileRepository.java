package pers.geolo.pesticide.repository;

import pers.geolo.pesticide.exception.ConfigurationException;
import pers.geolo.pesticide.exception.FileNotFoundException;
import pers.geolo.pesticide.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.UUID;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/14
 */
@Component
public class RawFileRepository implements FileRepository {

    @Value("${fileUpdatePath}")
    private String fileUpdatePath = null;

    /**
     * 根据当前年月日生成文件路径：年月/日
     *
     * @return 生成的文件路径
     */
    private String makeFilePath(String fileType) {
        StringBuilder fileNameBuilder = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        fileNameBuilder.append(calendar.get(Calendar.YEAR))
                .append(calendar.get(Calendar.MONTH) + 1)
                .append("/" + calendar.get(Calendar.DATE))
                .append("/")
                .append(UUID.randomUUID())
                .append(".")
                .append(fileType);
        return fileNameBuilder.toString();
    }

    private String getSavePath(String id) {
        if (fileUpdatePath == null) {
            throw new ConfigurationException("can not find properties 'fileUpdatePath' in configuration file");
        }
        return fileUpdatePath + id;
    }

    @Override
    public FileInfo getFile(String id) throws IOException {
        File file = new File(getSavePath(id));
        if (!file.exists()) {
            throw new pers.geolo.pesticide.exception.FileNotFoundException("the file of path = " + id + " is not found.");
        }
        return new FileInfo() {
            @Override
            public String getId() {
                return id;
            }

            @Override
            public String getFilename() {
                return file.getName();
            }

            @Override
            public String getContentType() {
                FileNameMap fileNameMap = URLConnection.getFileNameMap();
                String contentType = fileNameMap.getContentTypeFor(file.getPath());
                return contentType;
            }

            @Override
            public long getLength() {
                return file.length();
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return new FileInputStream(file);
            }
        };
    }

    @Override
    public String saveFile(FileInfo fileInfo) throws IOException {
        String filename = fileInfo.getFilename();
        String fileType = filename.substring(filename.lastIndexOf(".") + 1);
        String id = makeFilePath(fileType);
        File file = new File(getSavePath(id));
        if (!file.getParentFile().exists()) {
            boolean success = file.getParentFile().mkdirs();
            if (!success) {
                throw new IOException("can not make directory to save file:" + file.getPath());
            }
        }
        if (!file.exists()) {
            boolean success = file.createNewFile();
            if (!success) {
                throw new IOException("can not create file:" + file.getPath());
            }
        }
        IOUtils.connectStream(fileInfo.getInputStream(), new FileOutputStream(file));
        return id;
    }

    @Override
    public void removeFile(String id) throws IOException {
        File file = new File(getSavePath(id));
        if (!file.exists()) {
            throw new FileNotFoundException("the file of path = " + id + " is not found.");
        }
        boolean success = file.delete();
        if (!success) {
            throw new IOException("can not delete file:" + file.getPath());
        }
    }
}
