package leetcodeByCategory.jacob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileLineByLine {

    public void test(File file) throws Exception{
        try (BufferedReader  br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
            }
        }
    }
}
