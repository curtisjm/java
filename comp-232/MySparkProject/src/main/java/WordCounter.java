import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import org.apache.spark.*;

import java.util.Arrays;

public class WordCounter {

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir","C:\\Hadoop\\" );
        String inputPath = "../input.txt";
        String outputPath = "C:\\Users\\curti\\Desktop\\SparkJ1";
        JavaSparkContext sparkContext = new JavaSparkContext(new SparkConf().setAppName("Word Count"));
        JavaRDD<String> lines = sparkContext.textFile(inputPath);
        JavaRDD<String> words = lines.flatMap(
                (String line) -> Arrays.asList(line.split(" ")).iterator()
        );
        JavaPairRDD<String, Integer> wordCounts = words.mapToPair(
                (String word) -> new Tuple2<>(word, 1)
        ).reduceByKey(
                (Integer count1, Integer count2) -> count1 + count2
        );
        wordCounts.saveAsTextFile(outputPath);

    }
}
