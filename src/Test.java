import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		 List<String> listWord=new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.artic.edu/api/v1/artworks/search?query%5Bterm%5D%5Bis_public_domain%5D=true&limit=0"))
        .build();
  	   HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
  	   
  	   //Read 
  	   
  	    try {
  	   
  	    FileReader reader = new FileReader("Evalution.txt");

  	    
  	    int ch;
  	    while ((ch = reader.read()) != -1) {
  	        System.out.print((char) ch);
  	    }

  	    
  	    reader.close();

  	} catch (IOException ex) {
  	    ex.printStackTrace();
  	}
   	 
  	  //Write  

     	try {
     	 
     	    FileWriter writer = new FileWriter("Evalution.txt");


     	    writer.write(response.body());
     	

     	 
     	    writer.close();

     	} catch (IOException ex) {
     	    ex.printStackTrace();
     	}
     	
     	//Searching for Unique word 
     	
      File data=new File("C:\\Users\\user012\\eclipse-workspace\\Evaluation\\Evalution.txt");
   	  FileReader fileR=null;
   	  Scanner scanner1=new Scanner(System.in);
   	  String string;
   	  
	  System.out.println("Enter word you want to search:");
	  String SearchWord= scanner1.next();
	  listWord.add(SearchWord);
	  
   	 try {
   		fileR=new FileReader(data);
		  BufferedReader bufferR=new BufferedReader(fileR);
		  
		  while((string=bufferR.readLine())!=null) {
			  if(string.contains(SearchWord)) {
				  System.out.println("Yes "+SearchWord+" is in the file");
			  }	
			
		
			  else {
				  System.out.println("No "+SearchWord+" is Not in the file");
				  
			 }}}
           			  


   		
   	 
   				  
   			 
   			     catch(FileNotFoundException ex) {
   					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
   				     }catch(IOException ex) {
   					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
   				  }
   				  finally {
   					  fileR.close();
   				  }
     	
     	
        
		
		
}}