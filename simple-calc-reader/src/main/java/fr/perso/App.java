package fr.perso;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.github.miachm.sods.Range;
import com.github.miachm.sods.Sheet;
import com.github.miachm.sods.SpreadSheet;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {

            URL url = App.class.getResource("/sample.ods");
            String absoluteDiskPath = url.getPath();
            System.out.println(absoluteDiskPath);

            SpreadSheet spread = new SpreadSheet(new File(absoluteDiskPath));
            System.out.println("Number of sheets: " + spread.getNumSheets());

            List<Sheet> sheets = spread.getSheets();

            for (Sheet sheet : sheets) {
                System.out.println("In sheet " + sheet.getName());

                Range range = sheet.getDataRange();
                System.out.println(range.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
