import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;

import java.util.ArrayList;

public class ListObjects {

    private ArrayList<String> objectNames = new ArrayList<>();

    private MinioClient minioClient = MinioClient.builder()
            .endpoint("http://localhost:9000")
            .credentials("admin", "Nelsondog7")
            .build();

    private void listObjects() {
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket("test-bucket").recursive(true).build());
            for(Result<Item> i : results) {
                objectNames.add(i.get().objectName());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void printList() {
        for(String s : objectNames) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        ListObjects lo = new ListObjects();
        lo.listObjects();
        lo.printList();
    }
}
