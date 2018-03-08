import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * This will take the the phrase and int then
 */
public class Translation {
    /**
     * This method takes the phrase and the repeat integer and runs it through translate TIMES
     * @param input String -  The phrase that the user sets
     * @param times Int - Number of times they want to run it through the translator
     * @return iterationList - The JSON list that is written with the results
     */
    public JSONArray iterateTranslate (String input, int times) {
        JSONArray iterationList = new JSONArray();
        LanguageReader randLang = new LanguageReader();
        Random rand = new Random();

        //gets the max array size to choose a number below that
        int max = randLang.getArraySize();
        //Sets the inCode to start off as English always
        String inCode = "en";

        for (int count=1; count<=times; count++){
            JSONObject iteration = new JSONObject();
            String outCode = "en";
            String outName = "English";
            String output = "Error";

            if(count == times){
                output = translate(input, inCode, "en");
                iteration.put("phrase",output);
                iteration.put("code","en");
                iteration.put("name","English");
                iterationList.add(iteration);
                input = output;
            }
            else {

                //Google Translate API has an error when the input code is the same as the output code.
                do{
                    //Get a random number between the max index value and 0
                    int random = rand.nextInt(max) + 0;
                    //get the language output code for the translation to run
                    outCode = LanguageReader.codes.get(random);
                    outName = LanguageReader.names.get(random);
                    //unless the code is the same or english then run it again.
                } while (inCode == outCode || outCode == "en");

                //run the translation and save it to the output string
                output = translate(input, inCode, outCode);

                iteration.put("phrase",output);
                iteration.put("code",outCode);
                iteration.put("name",outName);
                iterationList.add(iteration);
                //Switch the input to the new output to run again
                input = output;
                //Switch the language code from the input to the output and run again
                inCode = outCode;
            }
        }
        //Write JSON file
        try (FileWriter file = new FileWriter("iterations.json")) {

            file.write(iterationList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return iterationList;
    }

    /**
     * The actual api call to google
     * @param input String -  The phrase that the user sets
     * @param inCode The language code that the phrase is already in
     * @param outCode The language code that the phrase wants to end up in
     * @return output - String - the translation output of the phrase
     */
    public String translate (String input, String inCode, String outCode){
        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // Translates some text into
        com.google.cloud.translate.Translation translation =
                translate.translate(
                        input,
                        Translate.TranslateOption.sourceLanguage(inCode),
                        Translate.TranslateOption.targetLanguage(outCode));

        String output = translation.getTranslatedText();
        //System.out.printf("Text: %s%n", input);
        //System.out.printf("Translation: %s%n", output);
        //System.out.printf("Translation: %s%n", translation.getTranslatedText());

        return output;
    }
}