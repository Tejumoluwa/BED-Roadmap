package Java;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharacterCounter implements Counter {
    @Override
    public int getCount(File file){
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while(line != null){
                String[] words = line.split(" ");
                for(String word : words){
                    if(!line.equals("")) {
                        for(int i = 0; i < word.length(); i++) {
                            count++;
//                            System.out.println(word.charAt(i));
                        }
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
