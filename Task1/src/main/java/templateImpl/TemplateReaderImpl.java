package templateImpl;

import template_interface.ITemplateReader;

import java.io.*;

public class TemplateReaderImpl implements ITemplateReader {
    public static void getLinesWithTemplate(String resourceFileName , String strTemplate) {
        File file = new File(TemplateReaderImpl.class.getClassLoader().getResource(resourceFileName).getFile());

        if(!file.exists()) return;

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(fr);

        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        while (line != null) {
            if(line.contains(strTemplate))
                System.out.println(line);
            try {
                line = reader.readLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}


