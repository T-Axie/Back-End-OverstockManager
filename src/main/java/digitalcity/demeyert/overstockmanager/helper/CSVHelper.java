package digitalcity.demeyert.overstockmanager.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.model.entity.Language;
import digitalcity.demeyert.overstockmanager.model.entity.Rarity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "cardmarketid", "name", "expansion", "language", "count", "foil", "signed", "playset", "rarity", "comment" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Card> csvToCards(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Card> tutorials = new ArrayList<Card>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Card tutorial = new Card(
                        Integer.parseInt(csvRecord.get("cardmarketid")),
                        csvRecord.get("name"),
                        csvRecord.get("expansion"),
                        Language.valueOf(csvRecord.get("language")),
                        Integer.parseInt(csvRecord.get("count")),
                        Boolean.parseBoolean(csvRecord.get("Foil")),
                        Boolean.parseBoolean(csvRecord.get("Signed")),
                        Boolean.parseBoolean(csvRecord.get("Playset")),
                        Rarity.valueOf(csvRecord.get("rarity")),
                        csvRecord.get("comment")
                );

                tutorials.add(tutorial);
            }

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}