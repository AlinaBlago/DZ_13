import templateImpl.TemplateReaderImpl;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1");
        System.out.println("-------------------------------------");
        TemplateReaderImpl.getLinesWithTemplate("File.txt" , " at ");

        System.out.println("Task 2");
        System.out.println("-------------------------------------");
        // копирование происходит из ресурсов с заранее готового шаблона из папки from
        File fromFolder = new File(TemplateReaderImpl.class.getClassLoader().getResource("from").getFile());
        // введите куда нужно скопировать содержимое папки from
        File toFolder = new File("/Users/alinocka/Desktop/to");

        if(!fromFolder.exists()){

            System.out.println("Directory does not exist.");
            System.exit(0);

        }else{

            try{
                CopyContentImpl.copy(fromFolder,toFolder);
            }catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }

        System.out.println("Done");
    }

}

