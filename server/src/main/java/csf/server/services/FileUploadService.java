package csf.server.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import csf.server.models.Post;
import csf.server.repositories.FileUploadRepository;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepo;

    public String upload(MultipartFile file, String comments) throws SQLException, IOException {
        return fileUploadRepo.upload(file, comments);
    }

    public Optional<Post> getPostById(String postId) {
        return fileUploadRepo.getPostById(postId);
    }
    
}
