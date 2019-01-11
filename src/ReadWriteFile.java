import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author He.H
 * @date 2019/1/10 19:33
 **/


public class ReadWriteFile {
    public static File[] Openfolder(String path){
        File file = new File(path);
        if (file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    public static BufferedReader OpenFile(File file) throws FileNotFoundException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }

    public static BufferedReader OpenFile(String path) throws FileNotFoundException{
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }

    public static long GetRecordFileDate(File file) throws ParseException {
        String name = file.getName();
        String[] names = name.split("to");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(names[0]);
        Date s = sdf.parse("2014-11-21");
        return (d.getTime()-s.getTime())/86400000;
    }

    public static void WriteLine(BufferedWriter bw, String... args) throws IOException{
        for (int i = 0; i < args.length; i++) {
            bw.write(args[i]);
            if(i < args.length -1)
                bw.write("\t");
        }
        bw.write("\n");
    }

    public static <K, V> void WriteLine(BufferedWriter bw, HashMap<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            bw.write(String.valueOf(entry.getKey()));
            bw.write(":");
            bw.write(String.valueOf(entry.getValue()));
            bw.write("\t");
        }
        bw.write("\n");
    }

    public static BufferedWriter OpenWriteFile(String path) throws IOException{
        File outFile = new File(path);
        FileWriter fw = new FileWriter(outFile);
        BufferedWriter bw = new BufferedWriter(fw);
        return bw;
    }


}
