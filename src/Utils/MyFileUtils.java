package Utils;
import java.io.*;
import java.util.*;

public class MyFileUtils {

    public static void saveInFile(String filepath, String line){
        try (FileWriter writer = new FileWriter(filepath, true)){
            writer.write(line+"\n");
        } catch(IOException e){ }
    }

    public static List<String> readFromFile(String filepath){
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.isEmpty()) continue;
                lines.add(line);
            }
        } catch (IOException e) {}
        return lines;
    }

    public static void clearFile(String filepath){
        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write("");
        } catch (IOException e) {}
    }

    public static void deleteLineFromFile(String filepath, String linetodelete){
        List<String> lines = readFromFile(filepath);
        if(lines==null || lines.isEmpty()) return;

        String allLines = "";
        for(String line : lines){
            if(line.equalsIgnoreCase(linetodelete)) continue;
            allLines+=line+"\n";
        }
        clearFile(filepath);
        saveInFile(filepath, allLines);
    }

    public static String searchFromFile(String filepath, String searchterm){
        List<String> lines = readFromFile(filepath);
        if(lines==null || lines.isEmpty()) return null;

        String outputLine = "";
        boolean found = false;
        for(String line : lines){
            String parts[] = line.split("\\|");
            for(String part : parts){
                if(part.equalsIgnoreCase(searchterm)){
                    found = true;
                    outputLine = line;
                }
            }
        }

        if(found){
            return outputLine;
        } else {
            return null;
        }
    }
}
