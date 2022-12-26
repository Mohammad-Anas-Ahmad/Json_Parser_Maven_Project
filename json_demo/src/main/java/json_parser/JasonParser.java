package json_parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;


public class JasonParser  {

   
/*
 * This is ParseFiles method this method parses the JSON files into the Java object
 * and then it converts the that object to an array jsondata object.
 */
    private static void ReadFiles(String folderPath){

      String filename = null;
       try {

         //Creating an Object of Gson to parse files.
         Gson gSon = new Gson();

         //Creating objects for file handeling and writing
         File folder = new File(folderPath);
         File[] files = folder.listFiles();
         
         //This gives the object the path of the result file which is output in the project.
         FileWriter writer = new FileWriter("C:\\Users\\moham\\OneDrive\\Desktop\\mavenpr\\json_demo\\OutputFolder\\Result.CSV");

         //Writing the first row of three colomn Id,Kruzbezeichnug,Strassenbezeichnug
         writer.write("Id,Kruzbezeichnug,Strassenbezeichnug");
         
 
         //This loop gives the file located in the data folder and pass it to the data object
         jsondata[] data;
         for(File file : files){
         try {
               
              filename = file.getName();
              data = gSon.fromJson(new FileReader(file),jsondata[].class);
 
              if(data.length==0||data == null){
                writeError(filename,"Empty file", "C:\\Users\\moham\\OneDrive\\Desktop\\mavenpr\\json_demo\\OutputFolder\\Error.txt");
              }
 
              //This loop runs through the array of data object
              for (int i = 0; i < data.length; i++) {

                 String strassenbezeichnung = data[i].getstrass();
                 String kurzbezeichnung = data[i].getkruz();
                 String  id = data[i].getid();
     
                 // writing contents in files;
                 writer.write("\n"+id+","+kurzbezeichnung +","+strassenbezeichnung);
                 
                }
  
         } catch (Exception e) {
             // TODO: handle exception
             writeError(filename,e.toString(), "C:\\Users\\moham\\OneDrive\\Desktop\\mavenpr\\json_demo\\OutputFolder\\Error.txt");
             
         }
       }
       writer.close();
       System.out.println("File created successfully!");
 
       } catch (Exception e) {
        // TODO: handle exception
        writeError(filename,e.toString(), "C:\\Users\\moham\\OneDrive\\Desktop\\mavenpr\\json_demo\\OutputFolder\\Error.txt");
        
       }
    }

    //This is the fuction to write error in the error file
    public static void writeError(String fileName, String errorMessage, String errorFilePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(errorFilePath, true))) {
            bw.write(fileName + ": " + errorMessage);
            bw.newLine();
        } catch (IOException e) {
            // handle the exception
            System.out.println(e);
            e.printStackTrace();
      }
    }

    //Making the main function and calling the ReadFiles function.
    public static void main(String[] args) throws IOException {

        //calling the fuction and passing the path to the fuction where the data is located
        ReadFiles("C:\\Users\\moham\\OneDrive\\Desktop\\mavenpr\\json_demo\\src\\data\\data");
           
    }
}
