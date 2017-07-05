import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

import com.github.lwhite1.tablesaw.api.Table;
import org.apache.commons.math3.*;

import static com.github.lwhite1.tablesaw.api.QueryHelper.column;

/**
 * Created by Aliaksandr_Lashkov on 30.06.2017.
 */
public class test {

    public static void main(String... args) throws IOException, NoSuchAlgorithmException {
        //        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\trainLabels.csv.gz");
        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\train.csv.gz");
//        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\test.csv.gz");
        FileInputStream finput = new FileInputStream(f);
        GZIPInputStream gzipStream = new GZIPInputStream(finput);

        Table tornadoes = Table.createFromCsv("D:/RPA/cleartk_2/cleartk-examples/data/Tradeshift/train.csv");
//        Table tornadoes = Table.createFromStream(String.class[], "D:/RPA/cleartk_2/cleartk-examples/data/Tradeshift/train.csv");

        System.out.println(tornadoes.columnNames());
        System.out.println(tornadoes.shape());
        System.out.println(tornadoes.structure());
        System.out.println(tornadoes.structure().selectWhere(column("Column Type").isEqualTo("INTEGER")));
        System.out.println(tornadoes.first(3).toString());
    }
}
