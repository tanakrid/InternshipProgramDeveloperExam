package weather;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Weather {
    private String cwd = System.getProperty("user.dir");
    private String fileSep = System.getProperty("file.separator");

    private String readFile(String nameFile){
        StringBuilder data = new StringBuilder();
        try {
            File file = new File(cwd+fileSep+"OutputInputFile"+fileSep+nameFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data.toString();
    }

    private void writeFile(String nameFile ,String data){
        try {
            if(Files.notExists(Paths.get(cwd+fileSep+"OutputInputFile"+fileSep+nameFile+".xml"))){
                throw new IOException();
            }
            File file = new File(cwd+fileSep+"OutputInputFile"+fileSep+nameFile+".json");
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file,false);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void runProgram(){
        System.out.println("--- Convert XML File to JSON File ---");
        Scanner sc = new Scanner(System.in);
        String name = "", isExit = "";
        while (true) {
            System.out.print("Enter your XML file' name (not type file) in OutputInput Folder: ");
            name = sc.nextLine();
            JSONObject jsonObject = XML.toJSONObject(readFile(name+".xml"));
            writeFile(name,jsonObject.toString(2));
            System.out.print("Want to exit program press Q or not press other: ");
            isExit = sc.nextLine();
            if (isExit.toLowerCase().charAt(0) == 'q')
                break;
        }
    }
}
