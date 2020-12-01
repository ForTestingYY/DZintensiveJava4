import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        try{
            FileReader reader = new FileReader("homework.xml");
            char[] buf = new char[256];
            int c;
            String newText = null;
            while ((c = reader.read(buf))>0){
                if(c<256){
                    buf = Arrays.copyOf(buf, c);
                }
                newText = String.valueOf(buf).replaceAll("(<.*li.*>).*(</.*li.*>)", "$1Some new text bla bla bla$2");
                System.out.println(newText);

            }

            File file = new File("newhomework.xml");
            FileWriter writer = new FileWriter(file);
            writer.write(newText);
            writer.flush();
            reader.close();
            writer.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
