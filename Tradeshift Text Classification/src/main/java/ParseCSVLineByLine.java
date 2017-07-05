import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;

import au.com.bytecode.opencsv.CSVReader;

public class ParseCSVLineByLine
{
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception
    {
//      reads gz archive by openCSV.CSVReader directly without unpacking it

//        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\trainLabels.csv.gz");
        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\train.csv.gz");
//        File f = new File("D:\\Projects\\Kaggle\\Tradeshift Text Classification\\data\\test.csv.gz");

        FileInputStream finput = new FileInputStream(f);
        GZIPInputStream zipReader = new GZIPInputStream(finput);
        InputStreamReader streamReader = new InputStreamReader(zipReader);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        CSVReader reader = new CSVReader(bufferedReader, ',' , '"' , 1);

//        //Read CSV line by line and use the string array as you want
//        String[] nextLine;
//        while ((nextLine = reader.readNext()) != null) {
//            if (nextLine != null) {
//                //Verifying the read data here
//                System.out.println(Arrays.toString(nextLine));
//            }
//        }

        //Read all rows at once
        List<String[]> allRows = reader.readAll();

        //Read CSV line by line and use the string array as you want
        for(String[] row : allRows){
            System.out.println(Arrays.toString(row));
        }
    }
}