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
     	
     	
     	
     	
     	 Scanner sc = new Scanner(System.in);
         
     	 System.out.println("Enter the word to be found");
         String word = sc.next();
         boolean flag = false;
         int count = 0;

         
         Scanner sc2 = new Scanner(new FileInputStream("Evalution.txt"));
         while(sc2.hasNextLine()) {
            String line = sc2.nextLine();
            System.out.println(line);
            if(line.indexOf(word)!=-1) {
               flag = true;
               count = count+1;
            }
         }
         if(flag) {
            System.out.println("File contains the specified word");
            System.out.println("Number of occurrences is: "+count);
         } else {
            System.out.println("File does not contain the specified word");
         }
      }
   }
     	//Searching for Unique word 
//     	
//      File data=new File("C:\\Users\\user012\\eclipse-workspace\\Evaluation\\Evalution.txt");
//   	  FileReader fileR=null;
//   	  Scanner scanner1=new Scanner(System.in);
//   	  String string;
//      String[] json=response.body().split(" ");
//      
//	  System.out.println("Enter word you want to search:");
//	  String SearchWord= scanner1.next();
//	  int count=0;
//	  for(int i=0; i<json.length;i++) {
//		  if(json[i]==SearchWord) {
//			  count++;
//		  }
//	  }
//
//   	 
//   	 
//	  
//   	 try {
//   		fileR=new FileReader(data);
//		  BufferedReader bufferR=new BufferedReader(fileR);
//		  
//		  while((string=bufferR.readLine())!=null) {
//			  if(string.contains(SearchWord)) {
//				  for(String word:listWord) {
//           		   if(set.add(word)==true) {
//				  System.out.println("Yes, "+word+" is in the file");
//			  	}}}
//			
//
//			  else {
//				  System.out.println("No, "+SearchWord+" is Not in the file");
//				
//			 }}}
//           			  
//
//
//   		
//   	 
//   				  
//   			 
//   			     catch(FileNotFoundException ex) {
//   					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
//   				     }catch(IOException ex) {
//   					  Logger.getLogger(Test.class.getName()).log(Level.SEVERE,null,ex);
//   				  }
//   				  finally {
//   					  fileR.close();
//   				  }
//     	
//     	
//        
//		
//		
//}}