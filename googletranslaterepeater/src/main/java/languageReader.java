import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class languageReader
{
    public static ArrayList<String> codes = new ArrayList();
    public static ArrayList<String> names = new ArrayList();

    /**
     * Gets the array size from the json we just read
     * @return the size of the amount of language options we have
     */
    public int getArraySize() {
        if(codes.isEmpty() || names.isEmpty()){
            readJson("C:\\Users\\neneb\\Documents\\GitHub\\googletranslate\\googletranslaterepeater\\src\\main\\java\\languages.json");
        }
        if(codes.size() == 0){
            return 104;
        }
        return codes.size();
    }

    /**
     * This method will read the Json from the file we downloaded earlier but can also be replaced just a url of all the
     * language codes
     *
     * @param file in put the file the json is stored and read it to get all the codes
     */
    public static void readJson(String file)
    {
        JSONParser parser = new JSONParser();
        try
        {
            JSONArray langs = (JSONArray) parser.parse(new FileReader(file));

            for (Object lang : langs)
            {
                JSONObject options = (JSONObject) lang;
                String name = (String) options.get("name");
                names.add(name);

                String code = (String) options.get("code");
                codes.add(code);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}