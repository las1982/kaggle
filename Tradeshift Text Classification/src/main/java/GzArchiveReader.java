import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * Created by Aliaksandr_Lashkov on 30.06.2017.
 */
public class GzArchiveReader {

    public static void main(String... args) throws IOException {
//        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\trainLabels.csv.gz");
        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\train.csv.gz");
//        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\test.csv.gz");
        FileInputStream finput = new FileInputStream(f);
        GZIPInputStream gzipStream = new GZIPInputStream(finput);

        Scanner sc = new Scanner(gzipStream);
//        List<String[]> ls = new ArrayList<String[]>(1700001);
        int i = 0;
        while (sc.hasNextLine() && i <= 1000000) {
//        while (sc.hasNextLine()) {
            i++;
//            sc.nextLine();
            if (i > 999500) {
                System.out.println(sc.nextLine());
            } else {
                sc.nextLine();
                if (i % 10000 == 0) {
                    System.out.println(i);
                }
            }
//            ls.add(sc.nextLine().split(","));
        }
//        System.out.println(i);
//        System.out.println(ls.get(10));
    }
}
