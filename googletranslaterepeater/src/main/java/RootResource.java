import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@Path("/")
@RequiredArgsConstructor
public class RootResource {
    @GET
    public String root(@QueryParam("input") String input, @QueryParam("times") int times) {
        Translation tran = new Translation();

        String output = ""+ tran.iterateTranslate(input, times);
        output = readJson(output);

        return output;
    }

    /**
     * This string will read the json given by the translator and then output it in html
     * @param json - the json returned by the translation class
     * @return output - the HTML ready to go up
     */
    private String readJson(String json) {
        JSONParser parser = new JSONParser();
        String outHTML="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Google Translation</title>\n" +
                "</head>";
        try
        {
            JSONArray langs = (JSONArray) parser.parse(json);

            for (Object lang : langs)
            {
                JSONObject options = (JSONObject) lang;
                String name = (String) options.get("name");
                String code = (String) options.get("code");
                String phrase = (String) options.get("phrase");
                outHTML = outHTML + "<div class=\"body\" lang=\""+code+"\"><p> Language: " + name + ": " + phrase + "</p></html>";
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outHTML;
    }
}
