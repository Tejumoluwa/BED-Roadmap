package Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter implements Counter{

    @Override
    public int getCount(File file){
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while(line != null){
                String[] words = line.split(" ");
                for(String word : words){
                    if(!Counter.verifySpecialCharacter(word) && !line.equals("")) {
                        count++;
//                        System.out.println(word);
                    }
                }
                line = reader.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return count;
    }
}
