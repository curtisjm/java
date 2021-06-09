import io.minio.*;
import io.minio.errors.MinioException;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

public class GetObject {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            MinioClient minioClient = MinioClient.builder()
                        .endpoint("http://localhost:9000")
                        .credentials("minioadmin", "minioadmin")
                        .build();

            minioClient.downloadObject(DownloadObjectArgs.builder().bucket("test-bucket").object("UnitCircle.png").filename("UnitCircle.png").build());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
