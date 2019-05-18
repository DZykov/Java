
import java.io.*;
import java.net.*;

public class client {
	 public static void main(String argv[]) throws Exception
	 {
	  String sentence;
	  int port = 6789;
	  String ip = "localhost"; // or 192.168.X.X
	  BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
	  // connect to localhost on port
	  Socket clientSocket = new Socket(ip, port);
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  sentence = inFromUser.readLine();
	  outToServer.writeBytes(sentence + '\n');
	  if (sentence.toLowerCase().equals("exist"))
      {
		clientSocket.close();
      	return;
      }
	  while(clientSocket.isConnected()) 
      {
		  sentence = inFromUser.readLine();
		  outToServer.writeBytes(sentence + '\n');
		  if (sentence.toLowerCase().equals("exist"))
		  {
			  clientSocket.close();
			  return;
		  }
      }
	 }
}