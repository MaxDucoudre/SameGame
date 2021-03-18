import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.FileInputStream;  
import java.io.*;  

public class test {  
  public static void main(String[] args) throws IOException {  
    int c;

    File inputFile = new File("./grilles_prefab/grille2.txt"); 

    FileReader in = new FileReader(inputFile); 


    while ((c = in.read()) != -1) {
      System.out.println("Caractère : " + (char)c + " ");  
    }  

    in.close(); 
  }
}
