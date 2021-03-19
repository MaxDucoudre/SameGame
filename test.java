import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.FileInputStream;  
import java.io.*;  

public class test {  
	public static void main(String[] args) throws IOException {  

		int i;
		int j;

      FileReader fichier =new FileReader("./grilles/grille1.txt");   //Creation of File Reader object
      BufferedReader flux = new BufferedReader(fichier);  //Creation of BufferedReader object
      int c = 0;          


      while (c != -1) {

           			char character = (char) c;          
            		System.out.println(c);        
            		c = flux.read();

            	}	
            }
        }
