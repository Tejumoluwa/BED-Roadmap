package Java;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public interface Counter{
    int getCount(File f);
    static boolean verifySpecialCharacter(String word){
        ArrayList<String> specialChar = new ArrayList<>(Arrays.asList("!", "@", "#", "$", "%", ")",
                "(", "*", "&", "^", "<", ">", ",", ".", "/",
                "{", "}", "[", "]", "\\", "|", "+", "=", "?", "-", "-", "~", "'", "\"", "`", ":", ";"));
        return specialChar.contains(word);
    }
}
