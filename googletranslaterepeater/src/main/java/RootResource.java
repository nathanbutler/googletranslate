import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


@Path("/")
@RequiredArgsConstructor
public class RootResource {
  @GET
  public String root(@QueryParam("input") String input, @QueryParam("times") int times) {
      Translation tran = new Translation();

      //String output = "<html><h1>" + tran.translate(input) + "<h1></html>";
      /*String output = "<html><h1>" + tran.repeat(input, times) + "<h1>";
       output = output+ "<h2>" + tran.outJSON +"</h2></html>";*/

      String output = ""+ tran.iterateTranslate(input, times);
      output = readJson(output);
      //output = "<html><h1>" + output + "<h1></html>";

    return output;
  }

    private String readJson(String json)
    {
        JSONParser parser = new JSONParser();
        String outHTML="<html lang=\"en\">";
        try
        {
            JSONArray langs = (JSONArray) parser.parse(json);

            for (Object lang : langs)
            {
                JSONObject options = (JSONObject) lang;
                String name = (String) options.get("name");
                String code = (String) options.get("code");
                String phrase = (String) options.get("phrase");
                outHTML = outHTML + "<blockquote lang=\""+code +"\">";
                outHTML = outHTML + "<p> Language: " +name+ ": \"" + phrase + "\"</p></blockquote>";
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outHTML;
    }
}
