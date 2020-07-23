import java.io.*;
import java.io.File;

public class CopyContentImpl implements ICopyContent {
    public static void copy(File from, File to) throws IOException {
        
        if(from.isDirectory()){

            if(!to.exists()){
                to.mkdir();
                System.out.println("Directory copied from "
                        + from + "  to " + to);
            }

            String files[]= from.list();

            for (String file : files) {
                File fromFile = new File(from, file);
                File toFile = new File(to, file);
                copy(fromFile,toFile);
            }

        }else{
            InputStream in = new FileInputStream(from);
            OutputStream out = new FileOutputStream(to);

            byte[]buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + from + " to " + to);
        }
    }
}
            
