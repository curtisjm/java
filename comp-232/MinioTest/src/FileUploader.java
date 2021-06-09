import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileUploader {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            MinioClient minioClient = MinioClient.builder()
                            .endpoint("http://localhost:9000")
                            .credentials("minioadmin", "minioadmin")
                            .build();

            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("test-bucket")
                            .object("UnitCircle.png")
                            .filename("\\Users\\curti\\Desktop\\Unit Circle.gif")
                            .build());
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }
    }
}