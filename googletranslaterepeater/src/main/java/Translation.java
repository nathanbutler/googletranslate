import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;

import java.util.ArrayList;

public class Translation {


    public ArrayList<String> repeat (String input, int times) {
        ArrayList <String> iterations = new ArrayList<>();
        for (int count=0; count<=times; count++){
            String output = translate(input);
            iterations.add(output);
            input = output;
        }
        return iterations;
    }

    public String translate (String input){
        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        // Translates some text into
        com.google.cloud.translate.Translation translation =
                translate.translate(
                        input,
                        Translate.TranslateOption.sourceLanguage("en"),
                        Translate.TranslateOption.targetLanguage("es"));


        System.out.printf("Text: %s%n", input);
        System.out.printf("Translation: %s%n", translation.getTranslatedText());
        String output = translation.getTranslatedText();

        return output;
    }
}