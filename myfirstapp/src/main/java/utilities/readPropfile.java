package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readPropfile {

    Properties prop = new Properties();
    public void readPropData(String path)
    {
        File file = new File(path);
        FileInputStream fileInput = null;

        try{
            fileInput = new FileInputStream(file);
            try{
                prop.load(fileInput);
                System.out.println("fileInput ="+fileInput);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    public String getPropValue(String value)
    {
        //System.out.println("getPropvalue = "+prop.getProperty(value));
        return prop.getProperty(value);
    }

}
