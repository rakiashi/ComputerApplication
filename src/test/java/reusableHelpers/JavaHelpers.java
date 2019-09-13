package reusableHelpers;

import itRunner.InitConstants;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class JavaHelpers extends InitConstants {

//    --- Java Helpers -------------------------------------------------------------------------------------------------

    public static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream(FilenameUtils.normalize("src/test/resources/application.properties")));
        return prop;
    }

    public static JSONObject getJsonData(String fileName) throws IOException {
        String filepath = (prop.getProperty("jsonData") + fileName + ".json");
        File file = new File(filepath);
        String JSONdata = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(JSONdata);
    }

    public static JSONObject getComputerDetails(String userReference) throws JSONException, IOException {
        return getJsonData("testData").getJSONObject("computerDetails").getJSONObject(userReference);
    }


    public static String dateFormat(String dateFormat) {
        try {
            DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = srcDf.parse(dateFormat);
            DateFormat destDf = new SimpleDateFormat("dd MMM yyyy");
            String formatDate = destDf.format(date);
            return formatDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat;
    }

    //    --- Java Helpers --------------------------------------------------------------------------------------------
}
