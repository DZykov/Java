import java.awt.Desktop;
import java.io.*;
import java.net.*;


public class server 
{
   public static void main(String argv[]) throws Exception
      {
            String clientLink;
            int port = 6789;
            String ip = "localhost"; // or 192.168.X.X
            ServerSocket welcomeSocket = new ServerSocket(port, 0, InetAddress.getByName(ip));
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            clientLink = inFromClient.readLine();
            System.out.println("Received: " + clientLink);
            if (clientLink.toLowerCase().equals("exist"))
        	{
            	welcomeSocket.close();
        		return;
        	}
        	openBrowser(clientLink);
            while(connectionSocket.isConnected()) 
            {
            	clientLink = inFromClient.readLine();
                System.out.println("Received: " + clientLink);
            	if (clientLink.toLowerCase().equals("exist"))
            	{
            		welcomeSocket.close();
            		return;
            	}
            	openBrowser(clientLink);
            }
      }
   
   public static void openBrowser(String link)
   {
	   try 
		{
		   Desktop.getDesktop().browse(new URI(link));
		} 
	    catch (IOException | URISyntaxException e) 
		{
			System.out.println("Link does not exist or connection has failed");
		}
   }
   
} 
