package Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LineCounter implements Counter {
    @Override
    public int getCount(File f) {
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(f))){
            String line = reader.readLine();
            while(line != null ){
                if(!line.equals("")) {
//                    System.out.println(line);
                    count++;
                }
                line = reader.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return count;
    }
}
