package group.geolo.defectmanager.repository;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import group.geolo.defectmanager.exception.FileNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/10/14
 */
//@Component
public class MongoDBFileRepository implements FileRepository {

    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private GridFSBucket gridFSBucket;

    @Override
    public FileInfo getFile(String id) throws IOException {
        Query query = Query.query(Criteria.where("_id").is(id));
        GridFSFile fsFile = gridFsTemplate.findOne(query);
        if (fsFile == null) {
            throw new FileNotFoundException("the file of id = " + id + " is not found.");
        }
        return new FileInfo() {
            @Override
            public String getId() {
                return fsFile.getObjectId().toString();
            }

            @Override
            public String getFilename() {
                return fsFile.getFilename();
            }

            @Override
            public String getContentType() {
                return fsFile.getMetadata().get("_contentType").toString();
            }

            @Override
            public long getLength() {
                return fsFile.getLength();
            }

            @Override
            public InputStream getInputStream() throws IOException {
                GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(fsFile.getObjectId());
                GridFsResource resource = new GridFsResource(fsFile, gridFSDownloadStream);
                return resource.getInputStream();
            }
        };
    }

    @Override
    public String saveFile(FileInfo fileInfo) throws IOException {
        ObjectId objectId = gridFsTemplate.store(fileInfo.getInputStream(), fileInfo.getFilename(), fileInfo.getContentType());
        return objectId.toString();
    }

    @Override
    public void removeFile(String id) throws IOException {
        Query query = Query.query(Criteria.where("_id").is(id));
        gridFsTemplate.delete(query);
    }
}
