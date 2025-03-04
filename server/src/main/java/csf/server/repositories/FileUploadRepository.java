package csf.server.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import csf.server.models.Post;

@Repository
public class FileUploadRepository {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    private DataSource dataSource;

    private static final String INSERT_POST = """
            INSERT INTO posts (post_id, comments, picture) VALUES (?, ?, ?)
            """;

    private static final String SELECT_POST_BY_ID = """
            SELECT post_id, comments, picture FROM posts WHERE post_id = ?
            """;
    
    public String upload(MultipartFile file, String comments) throws SQLException, IOException {
        try(Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT_POST)) {
                String postId = UUID.randomUUID().toString()
                    .replace("-", "").substring(0, 8);
                ps.setString(1, postId);
                ps.setString(2, comments);
                ps.setBytes(3, file.getBytes());
                ps.executeUpdate();
                return postId;
        }
    }

    public Optional<Post> getPostById(String postId) {
        return template.query(
            SELECT_POST_BY_ID, 
            (ResultSet rs) -> {
                if(rs.next()) {
                    return Optional.of(Post.populate(rs));
                } else {
                    return Optional.empty();
                }
            }
        , postId);
    }
}
