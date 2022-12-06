import java.beans.EventHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.directory.SearchResult;



public class Test {

	
	public static void main(String[] args) throws IOException, InterruptedException{
		HashSet<String> set = new HashSet<>();
		 List<String> listWord=new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.artic.edu/api/v1/artworks/search?query%5Bterm%5D%5Bis_public_domain%5D=true&limit=0"))
        .build();
  	   HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
   	 
  	  //Write  

     	try {
     	 
     	    FileWriter writer = new FileWriter("Evalution.txt");


     	    writer.write(response.body());
     	

     	 
     	    writer.close();

     	} catch (IOException ex) {
     	    ex.printStackTrace();
     	}
     	
     	 
     	  FileReader fileR=null;

       	  String string;
  		 
		
		 Scanner scanner1=new Scanner(System.in); 
       	 System.out.println("Please Choose the Type of the file you want :");
    	 System.out.println("1-Text File.");
    	 System.out.println("2-PDF.");
         int option1=scanner1.nextInt();
         
         
         
       	 switch(option1) {
       	 
       	 
       	 case 1 :

     	
        	  
          	System.out.println("Enter word you want to search:");
       	  String SearchWord= scanner1.next();
       	  listWord.add(SearchWord);




          	 try {
          		File data=new File("Evalution.txt");
          		fileR=new FileReader(data);
       		  BufferedReader bufferR=new BufferedReader(fileR);

       		  while((string=bufferR.readLine())!=null) {
       			  if(string.contains(SearchWord)) {
       			  for(String word:listWord) {
               		   if(set.add(word)==true) {
     				  System.out.println("Yes, "+word+" is in the file");
     			  	}}}
       		  
       		  else {
     			

     			  System.out.println("No, "+SearchWord+" is Not in the file");
     			
     		 }}}


     		
     	 
     				  
     			 
     			     catch(FileNotFoundException ex) {
     					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
     				     }catch(IOException ex) {
     					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
     				  }
     				  finally {
     					  fileR.close();
     				  }
       		 break;
       		 
       		 
       		
       	 case 2: 
       		 

      	
        		 
         	  
           	System.out.println("Enter word you want to search:");
        	  String SearchWord2= scanner1.next();
        	  listWord.add(SearchWord2);




           	 try {
           		File data=new File("Evalution.pdf");
           		fileR=new FileReader(data);
        		  BufferedReader bufferR=new BufferedReader(fileR);

        		  while((string=bufferR.readLine())!=null) {
        			  if(string.contains(SearchWord2)) {
        			  for(String word:listWord) {
                		   if(set.add(word)==true) {
      				  System.out.println("Yes, "+word+" is in the file");
      			  	}}}
        		  
        		  else {
      			

      			  System.out.println("No, "+SearchWord2+" is Not in the file");
      			
      		 }}}


      		
      	 
      				  
      			 
      			     catch(FileNotFoundException ex) {
      					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
      				     }catch(IOException ex) {
      					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
      				  }
      				  finally {
      					  fileR.close();
      				  }

	
	
}}}

