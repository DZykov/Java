// *it is a copy
// **work here and test here
// ***then update real one
/*
 * That was a rough cope, but right know it is a real Assignment 2!
 * SO...story...
 * I decided to right a simple encryption, and i did it!!!
 * I had a lot of time, and i decided to improve my program!
 * I made a console with commands (some commands are useless, some of them a great and helpful)
 * Enjoy! 
 */
package dmd;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import dmd.Console;

//i will use them!
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Console {

	public static void main(String[] args)
	{
		new Console();
		iconTray(args);
		//Checks if the computer will let us control it through java-program (web browser, skype, delete & create files)
		if (!Desktop.isDesktopSupported()) 
		{
			println("Your computer doesn't allow to use web browser", new Color(255,155,155));
			return;
		}
		
	}

	public static String search = null;
	//settings
	public static JFrame frame;
	public JTextPane console;
	public JTextField input;
	public JScrollPane scrollpane;
	public StyledDocument document;
	
	boolean trace = false;
	
	ArrayList<String> recent_used = new ArrayList<String>();
	
	//for remembering last commands
	int recent_used_id = 0;
	int recent_used_maximum = 20;
	
	//for loop command
	boolean loop = false;
	int loop_times = 1;
	int loop_times_temp = 1;	
	
	public Console()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception ex) {}
		
		
		//create and setting frame
		frame = new JFrame();
		frame.setType(javax.swing.JFrame.Type.UTILITY);
		frame.setTitle("Console");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //do nothing on close button (red cross)
		//window listener
		frame.addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	frame.setState(JFrame.ICONIFIED); // set Jframe to iconTray 
		    }
		});
		console = new JTextPane();
		console.setEditable(false);
		console.setForeground(Color.WHITE);
		console.setCaretColor(Color.WHITE);
		console.setFont(new Font ("Coutier New", Font.PLAIN, 15));
		console.setOpaque(false);
		
		//The Document interface represents the entire XML (access to the document's data)
		document = console.getStyledDocument();
		
		input = new JTextField();
		input.setEditable(true);
		input.setFont(new Font ("Coutier New", Font.PLAIN, 15));
		input.setForeground(Color.WHITE);
		input.setCaretColor(Color.WHITE);	
		input.setOpaque(false);

		
		//taking input from textbox
		input.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) 
					{
						String text = input.getText();
						
						if (text.length()>1)
						{
							recent_used.add(text);
							recent_used_id = 0;
							doCommand(text);
							scrollBottom();
							input.selectAll();		
						}
					}
			
				});
		
		//code for up and down arrows
		input.addKeyListener(new KeyListener()
				{
					@Override
					public void keyPressed(KeyEvent e)
					{
						if (e.getKeyCode() == KeyEvent.VK_UP)
						{
							if (recent_used_id <(recent_used_maximum - 1) && recent_used_id < (recent_used.size()-1))
							{
								recent_used_id++;
							}
							input.setText(recent_used.get(recent_used.size()-1-recent_used_id));
						}
						else if (e.getKeyCode() == KeyEvent.VK_DOWN)
						{
							if (recent_used_id >0)
							{
								recent_used_id--;
							}
							input.setText(recent_used.get(recent_used.size()-1-recent_used_id));
						}
					}
					@Override
					public void keyReleased(KeyEvent e)
					{
						
					}
					@Override
					public void keyTyped(KeyEvent e)
					{
						
					}
				});
		
		//adding possibility for scrolling up and down
		scrollpane = new JScrollPane(console);
		scrollpane.setBorder(null);
		scrollpane.setOpaque(false);
		scrollpane.getViewport().setOpaque(false);
		
		frame.add(input, BorderLayout.SOUTH);
		frame.add(scrollpane, BorderLayout.CENTER);
		
		
		//set frame
		frame.setLocationRelativeTo(null);
		frame.setSize(792, 420);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setResizable(true);
		frame.setVisible(true);
			
	}
	
	//scrolls
	public void scrollTop()
	{
		console.setCaretPosition(0);
	}
	
	public void scrollBottom()
	{
		console.setCaretPosition(console.getDocument().getLength());
	}
	/*
	 * I made a lot od print method with same name but different parametres 
	 * so i do not need to remember every name
	 * i need just to put paramtres which i need, and java will choose apropiriate method
	 */
	//print
	public void print(String s, boolean trace)
	{
		print(s, trace, new Color(255, 255, 255));
	}
	
	public void print(String s, boolean trace, Color c)
	{
		Style style = console.addStyle("Style", null);
		StyleConstants.setForeground(style,  c);
		
		if(trace)
		{
			Throwable t = new Throwable();
			StackTraceElement[] elements = t.getStackTrace();
			String caller = elements [0].getClassName();
			
			s = caller + " -> " + s;
		}
		
		try
		{
			document.insertString(document.getLength(), s, style);
		}catch (Exception ex) {}
		
		
	}
	
	public void println(String s, boolean trace)
	{
		println("|: " + s, trace, new Color(255, 255, 255));
	}

	public static void println(String s, Color c)
	{
		println("|: " + s, c);
	}
	
	public static void println(String s)
	{
		println("|: " + s);
	}
	
	public void println(String s, boolean trace, Color c)
	{
		print("|: " + s + "\n", trace, c);
	}
		
	//method to clear frame
	public void clear()
	{
		try
		{
			document.remove(0, document.getLength());
		}catch (Exception ex) {}
	}
	
	//method for commands
	public void doCommand(String s) 
	{
		/*
		 * to get number of word from string i will split words with space
		 */
		//splits words 
		// get ip
		// 1 - get
		// 2 - ip
		final String[] commands = s.split(" ");
		
		//command loop
		for (int i=0; i<loop_times; i++)
		{//loop command
			
			try
			{//to catch erros
				/*
				 * down there is a list of commands
				 * i hope i will not go astray
				 * God will help me
				 */
				//clear
				if (commands[0].equalsIgnoreCase("clear") || commands[0].equalsIgnoreCase("cls"))
				{
					clear();
				}
				//popup
				else if (commands[0].equalsIgnoreCase("popup"))
				{
					String message = "";
					
					for (int a=1; a<commands.length; a++)
					{
						message += commands[a];
						if (a!=commands.length - a)
						{
							message += " ";
						}
					}
					//print command
					println(s ,trace, new Color(255, 255, 255));
					//show msg (JOption)
					JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				//loop
				else if (commands[0].equalsIgnoreCase("loop"))
				{
					loop_times_temp = Integer.parseInt(commands[1]);
					loop = true;
					println("The next command will loop " + loop_times_temp + " times!",trace, new Color(155, 155, 255));
				}
				//change text
				else if (commands[0].equalsIgnoreCase("text"))
				{
					println(s,trace, new Color(155, 155, 255));
					//color
					if (commands[1].equalsIgnoreCase("color"))
					{
						if (commands[2].equalsIgnoreCase("normal"))
						{
							input.setForeground(Color.WHITE);
							input.setCaretColor(Color.WHITE);
							println("The color of Console was set to normal" ,trace, new Color(155, 155, 255));
						}
						else if(commands[2].equalsIgnoreCase("green"))
						{
							input.setForeground(new Color(0,204,0));
							input.setCaretColor(new Color(0,204,0));
							println("The color of Console was set to green" ,trace, new Color(155, 155, 255));
						}
						else if(commands[2].equalsIgnoreCase("red"))
						{
							input.setForeground(new Color(255,0,0));
							input.setCaretColor(new Color(255,0,0));
							println("The color of Console was set to red" ,trace, new Color(155, 155, 255));
						}
						else if(commands[2].equalsIgnoreCase("black"))
						{
							input.setForeground(new Color(0,0,0));
							input.setCaretColor(new Color(0,0,0));
							println("The color of Console was set to black" ,trace, new Color(155, 155, 255));
						}
						else
						{
						int a = Integer.parseInt(commands [2]);
						int b = Integer.parseInt(commands [3]);
						int c = Integer.parseInt(commands [4]);	
						input.setForeground(new Color(a,b,c));
						input.setCaretColor(new Color(a,b,c));
						println("The size of Console was set to " +a+";"+b+";"+c,trace, new Color(155, 155, 255));
						}
					}
					//font
					if (commands[1].equalsIgnoreCase("font"))
					{
							int size = Integer.parseInt(commands[2]);
							String all = commands[0]+" "+commands[1]+" "+commands[2]+" ";
							String font = s.replaceAll(all, "");
							input.setFont(new Font (font , Font.PLAIN, size));
							console.setFont(new Font (font , Font.PLAIN, size));
					}
				}
				//color change
				else if (commands[0].equalsIgnoreCase("back"))
				{
					if (commands[1].equalsIgnoreCase("normal"))
					{
						frame.getContentPane().setBackground(new Color(50,50,50));
						println("The color of Console was set to normal" ,trace, new Color(155, 155, 255));
					}
					else if(commands[1].equalsIgnoreCase("green"))
					{
						frame.getContentPane().setBackground(new Color(0,204,0));
						println("The color of Console was set to green" ,trace, new Color(155, 155, 255));
					}
					else if(commands[1].equalsIgnoreCase("red"))
					{
						frame.getContentPane().setBackground(new Color(255,0,0));
						println("The color of Console was set to red" ,trace, new Color(155, 155, 255));
					}
					else if(commands[1].equalsIgnoreCase("black"))
					{
						frame.getContentPane().setBackground(new Color(0,0,0));
						println("The color of Console was set to black" ,trace, new Color(155, 155, 255));
					}
					else
					{
					int a = Integer.parseInt(commands [1]);
					int b = Integer.parseInt(commands [2]);
					int c = Integer.parseInt(commands [3]);			
					frame.getContentPane().setBackground(new Color(a,b,c));
					println("The color of Console was set to " +a+";"+b+";"+c,trace, new Color(155, 155, 255));
					}				
				}
				//
				//size
				else if (commands[0].equalsIgnoreCase("size"))
				{
					if (commands[1].equalsIgnoreCase("normal"))
					{
						frame.setSize(792, 420);
						println("The size of Console was set to normal: 792;420" ,trace, new Color(155, 155, 255));
					}
					else
					{
					int x = Integer.parseInt(commands [1]);
					int y = Integer.parseInt(commands [2]);
					frame.setSize(x, y);
					println("The size of Console was set to " +x+";"+y,trace, new Color(155, 155, 255));
					}
				}
				//play a video from youtube
				else if (commands[0].equalsIgnoreCase("youtube") || commands[0].equalsIgnoreCase("utube"))
				{
					println(s ,trace, new Color(155, 155, 255));
					try 
					{
						//Opens the browser with the youtube link (the raplceall thing just replaces all whitespace with the "+"
						//so the URL understands it)
						//crutch
						String link = "";
						if (commands[0].equalsIgnoreCase("youtube")){link = s.replace("youtube ", "").replaceAll("\\s+", "+");}
						if (commands[0].equalsIgnoreCase("utube")){link = s.replace("utube ", "").replaceAll("\\s+", "+");}
						Desktop.getDesktop().browse(new URI($DZ.getLink(link)));
					} catch (IOException | URISyntaxException e) 
					{
						// TODO Auto-generated catch block
						println("Error ->" + e.getMessage(), trace, new Color(255,155,155));
						e.printStackTrace();
					}
				}
				//start (open objects, programs, folders)
				else if (commands[0].equalsIgnoreCase("start"))
				{
					String url = commands[1];
					//print to frame
					println(s ,trace, new Color(255, 255, 255));
					String cmd = "cmd.exe /c start " + url;
					// open with cmd
					Runtime.getRuntime().exec(cmd);
				}
				//trace
				else if (commands[0].equalsIgnoreCase("trace"))
				{
					 if (commands[1].equalsIgnoreCase("true"))
						{
						 trace = true;
						 println("Tracing Enabled!", trace, new Color(155, 155, 255));
						}
					else if (commands[1].equalsIgnoreCase("false"))
					    {
						trace = false;
						 println("Tracing Disabled!", trace, new Color(155, 155, 255));
					    }
				}
				//get
				else if (commands[0].equalsIgnoreCase("get"))
				{
					//get ip 
					if (commands[1].equalsIgnoreCase("ip"))
					{
						new Thread(new Runnable()
						{
							@Override
							public void run()
							{
								try
								{
									println(s ,trace, new Color(255, 255, 255));
									//get local ip
									println("Local IP: " + InetAddress.getLocalHost().getHostAddress(), trace, new Color(155, 155, 255));
								}catch (Exception ex)
								{
									//if error
									println("Error ->" + ex.getMessage(), trace, new Color(255,155,155));
								}
								
								try
								{
									String url = "http://bot.whatismyipaddress.com/";
									println("Connecting to service", trace, new Color(155, 255, 155));
									try{Thread.sleep(10);}catch (Exception ex) {}
									
									//go to web site
									BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
									println("Getting Global Ip Address", trace, new Color(155, 255, 155));
									//get text from website
									String receive = br.readLine();
									println("Global Ip: " + receive, trace, new Color(155, 155, 255));
								}
								catch (Exception ex)
								{
									println("Error ->" + ex.getMessage(), trace, new Color(255,155,155));
								}
								scrollBottom();
							}
						}).start();
					}
						//get time
						else if (commands[1].equalsIgnoreCase("time"))
						{
							  //get info about print
						      Date dNow = new Date( );
						      //format how to print print
						      SimpleDateFormat ft = 
						      new SimpleDateFormat ("hh:mm:ss a zzz");
						      println("Current time is  "+ ft.format(dNow), trace, new Color(255, 255, 255));
						}
						//get date
						else if (commands[1].equalsIgnoreCase("date"))
						{
							  //get info about date
						      Date dNow = new Date( );
						      //format how to show date
						      SimpleDateFormat ft = 
						      new SimpleDateFormat ("E dd.MM.yyyy");
						      println("Current date is  "+ft.format(dNow), trace, new Color(255, 255, 255));
						}
				}
				//exit
				else if (commands[0].equalsIgnoreCase("exit"))
				{
					System.exit(0);
				}
				//search file
				else if (commands[0].equalsIgnoreCase("search"))
				{
					  println(s ,trace, new Color(255, 255, 255));
					  //settings
					  String path = commands[1];
					  String b = commands[2];  
					  String files;
					  File folder = new File(path);
					  File[] listOfFiles = folder.listFiles(); 
					 
					  //algorithm for searching files
					  //getting how many files in that folder
					  for (int i1 = 0; i1 < listOfFiles.length; i1++) 
					  {
					   //checking is it a file or not
					   if (listOfFiles[i1].isFile()) 
					   {
					   files = listOfFiles[i1].getName();
					   	   //if file's name contains what we need print
					       if (files.contains(b))
					       {
					          println(files,trace, new Color(255, 255, 255));
					        }
					     }
					  }
				}
				//show folders
				else if (commands[0].equalsIgnoreCase("show"))
				{
					println(s,trace, new Color(255, 255, 255));
					println("-------------------------------------------" ,trace, new Color(255, 0, 0));
					String c = commands[1];
					try {
					      File dir = new File(c);
					      String[] children = dir.list();
					      //checking directory
					      if (children == null) {
					         println("does not exist or is not a directory", trace, new Color(255,155,155));
					      }
					      else {
					    	  //algorithm for getting folders
					    	  //getting how many folders
					         for (int i1 = 0; i1 < children.length; i1++) {
					            //print them
					        	String filename = children[i1];
					            println(filename,trace, new Color(255, 255, 255));
					         }
					         //if error
					      }} catch (Exception ex)
							{
								println("Error ->" + ex.getMessage(), trace, new Color(255,155,155));
							}
				}
				//create
				else if(commands[0].equalsIgnoreCase("create"))
				{
					println(s,trace, new Color(255, 255, 255));
					//if second word is folder
					if (commands[1].equalsIgnoreCase("folder"))
					{
						//get path and name for folder
						File myPath = new File(commands[2], commands[3]);
						//create folder
						myPath.mkdirs();
						println("Folder " + commands[3] + " successfully created!",trace, new Color(155, 155, 255));
					}
					//if second word is file
					else if(commands[1].equalsIgnoreCase("file"))
					{
						
						try 
						{
						//get path, file's name and format
						File file = new File(commands[2] + "\\" + commands[3]);
						//create file
							if (file.createNewFile()){
							println("File " + commands[3] + " successfully created!",trace, new Color(155, 155, 255));
							}
							else
							{
					    	//if file exists
					        println("File already exists!", trace, new Color(255, 0, 0));
							}
						//if errors
						} 
						catch (IOException e) 
						{      
						      e.printStackTrace();
						      println("Error -> " + e.getMessage(), trace, new Color(255,155,155));
						}
						
					}
				}
				//hide
				else if(commands[0].equalsIgnoreCase("hide"))
				{
					frame.setState(JFrame.ICONIFIED);
				}
				else if(commands[0].equalsIgnoreCase("kill"))
				{
					try
					{
					String proc = commands[1];
					//kill through cmd 
					Runtime.getRuntime().exec("taskkill /F /IM " + proc);
					println("Process " + commands[1] + " has been killed!", trace, new Color(255,155,155));
					}
					catch (IOException e) 
					{      
					      e.printStackTrace();
					      println("Error -> " + e.getMessage(), trace, new Color(255,155,155));
					}
				}
				//process
				else if(commands[0].equalsIgnoreCase("process"))
				{
					println(s,trace, new Color(255, 255, 255));
					try 
					{
						String process;
						//run and set cmd
						Process p = Runtime.getRuntime().exec("TASKLIST");
						//get them
						BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
						//print process
						while ((process = input.readLine()) != null) 
						{
							println(process, trace, new Color(255,255,255));
							println("--------------------------------------------------------------------------"
							+ "----------------------------------------------", trace, new Color(255,0,0));
						}
						input.close();
						//if errors
					} 
					catch (Exception err) 
					{
						println("Error -> " + err.getMessage(), trace, new Color(255,155,155));
					}
				}
				//play
				else if (commands[0].equalsIgnoreCase("play"))
				{
					println(s,trace, new Color(255, 255, 255));
					//play maze
					if (commands[1].equalsIgnoreCase("maze"))
					{
						//call method
						Assignment1.main(null);
						
					}
					//play agario
					if (commands[1].equalsIgnoreCase("agario"))
					{
						String url = "http://agar.io/";
						String cmd = "cmd.exe /c start " + url;
						// open with cmd
						Runtime.getRuntime().exec(cmd);
					}
					//play snake
					if (commands[1].equalsIgnoreCase("snake"))
					{
						String url = "http://www.supersnake.io/";
						String cmd = "cmd.exe /c start " + url;
						// open with cmd
						Runtime.getRuntime().exec(cmd);
					}
					//play slither
					if (commands[1].equalsIgnoreCase("slither"))
					{
						String url = "http://slither.io/";
						String cmd = "cmd.exe /c start " + url;
						// open with cmd
						Runtime.getRuntime().exec(cmd);
					}

				}
					
				//read
				else if (commands[0].equalsIgnoreCase("read"))
				{
					println(s,trace, new Color(255, 255, 255));
					//get file
					try (BufferedReader br = new BufferedReader(new FileReader(commands[1])))
					{

						String Line;
						//print line by line
						while ((Line = br.readLine()) != null) 
						{
							println(Line,trace, new Color(255, 255, 255));
						}
						// if errors
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					} 	
				}
				//calc
				else if (commands[0].equalsIgnoreCase("calc"))
				{
					double a = Double.parseDouble(commands[1]);
					double b = Double.parseDouble(commands[3]);
					//*
					if (commands[2].equals("*")){double c = a*b; String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// : /
					if (commands[2].equals(":") || commands[2].equals("/")){double c = a/b; String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// +
					if (commands[2].equals("+")){double c = a+b; String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// - 
					if (commands[2].equals("-")){double c = a-b; String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// ^
					if (commands[2].equals("^")){double c = Math.pow(a, b); String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// sqrt
					if (commands[2].equalsIgnoreCase("root") || commands[2].equalsIgnoreCase("rt")){double c = Math.pow(a, 1/b); String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// +%
					if (commands[2].equals("+%")){double c = a/100*b + a; String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// -%
					if (commands[2].equals("-%")){double c = a - a/100*b; String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					// !
					if (commands[2].equals("!"))
						{
						double c = 1; 
						for (int i1 = 1; i1 <= a; i1++) {c *= i1;}
						String d = String.valueOf(c);
						println(s+" = "+d,trace, new Color(255, 255, 255));
						}
					//cos
					if (commands[2].equals("cos")){double c = Math.cos(b); String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					//sin
					if (commands[2].equals("sin")){double c = Math.sin(b); String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
					//tan
					if (commands[2].equals("tan")){double c = Math.tan(b); String d = String.valueOf(c);println(s+" = "+d,trace, new Color(255, 255, 255));}
				}
				//crypt
				else if (commands[0].equalsIgnoreCase("crypt"))
				{
					println(s,trace, new Color(255, 255, 255));
					//go to path and get file
					try (BufferedReader br = new BufferedReader(new FileReader(commands[1])))
					{

						String Line;
						String crLine;
						String crFile = "";
						
						//read and crypt by line
						while ((Line = br.readLine()) != null) 
						{
							crLine = $DZ.crypt(Line);
							crFile += $DZ.crypt(Line);
							println(crLine,trace, new Color(255, 255, 255));
						}
						//save
						if (commands[2].equalsIgnoreCase("save"))
						{
							//path to write
							FileWriter wrt = new FileWriter(new File(commands[3], commands[4]), false);
							//
							//write to file
							wrt.append(String.format(crFile));
							//close it to save
							wrt.flush();
							wrt.close();
							println("Done", trace, new Color(255,255,255));
						}
						//close file
						br.close();
					} catch (IOException e) 
					{
						//if errors
						e.printStackTrace();
					}
					//delete
					if (commands[2].equalsIgnoreCase("delete") || commands[5].equalsIgnoreCase("delete"))
					{
						//get path of file
						File file = new File(commands[1]);
						//delete file
						if(file.delete()){
			    			println(file.getName() + " is deleted!",trace, new Color(255,255,255));
			    		}else
			    		{
			    			//if error
			    			println("Delete operation is failed.",trace, new Color(255,255,255));
			    		}
					  
					}

				}
				//encrypt
				else if (commands[0].equalsIgnoreCase("encrypt"))
				{
					println(s,trace, new Color(255, 255, 255));
					//go to path and get file
					try (BufferedReader br = new BufferedReader(new FileReader(commands[1])))
					{

						String Line;
						String crLine;
						String crFile = "";
						
						//read and encrypt line by line
						while ((Line = br.readLine()) != null) {
							crLine = $DZ.decrypt(Line);
							crFile += $DZ.decrypt(Line);
							println(crLine,trace, new Color(255, 255, 255));
						}
						//save
						if (commands[2].equalsIgnoreCase("save"))
						{
							//path to write
							FileWriter wrt = new FileWriter(new File(commands[3], commands[4]), false);
							//
							//write to file
							wrt.append(String.format(crFile));
							//close it to save
							wrt.flush();
							wrt.close();
							println("Done", trace, new Color(255,255,255));
						}
						//close file
						br.close();
					} catch (IOException e) 
					{
						//if error
						e.printStackTrace();
					}
					//delete
					if (commands[2].equalsIgnoreCase("delete") || commands[5].equalsIgnoreCase("delete"))
					{
						//go to path
						File file = new File(commands[1]);
						//delete file
						if(file.delete()){
			    			println(file.getName() + " is deleted!",trace, new Color(255,255,255));
			    		}else
			    		{
			    			//if error
			    			println("Delete operation is failed.",trace, new Color(255,255,255));
			    		}
					  
					}

				}
				//delete
				else if (commands[0].equalsIgnoreCase("delete"))
				{
					//get path of file
					File file = new File(commands[1]);
					//delete file
					if(file.delete()){
		    			println(file.getName() + " is deleted!",trace, new Color(255,255,255));
		    		}else
		    		{
		    			//if error
		    			println("Delete operation is failed.",trace, new Color(255,255,255));
		    		}
				  
				}
				//help
				else if (commands[0].equalsIgnoreCase("help"))
				{
					println(s,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("clear/cls - delete everything in console" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("popup [text]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("loop [number of loops] [command]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("start [path to the folder, file, or website]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("trace [false/true]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("get [date, time, ip]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("search [path] [name of an object]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("show [path]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("create [file/folder] [path] [name.format]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("process" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("kill [process, name of a program]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("read [path]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("play [maze, agario, snake, slither]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("crypt [path] [save:path/delete] [name.format] [delete]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("encrypt [path] [save:path/delete] [name.format] [delete]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("text [color] [r g b/normal,red, and etc]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("text [font] [size] [font]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("back [r g b/normal, red, and etc]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("size ([x] [y]) (size normal - to set to default size)" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("play [maze, agario, snake, slither]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("youtube/utube [key words]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("calc [x] [sign] [y]" ,trace, new Color(255, 255, 255));
					println("calc [x] [!] [1]" ,trace, new Color(255, 255, 255));
					println("calc [1] [cos/sin/tan] [y]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("adcheck [http://example.com/]" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("hide" ,trace, new Color(255, 255, 255));
					println("" ,trace, new Color(255, 255, 255));
					println("close" ,trace, new Color(255, 255, 255));	
				}
				//check website
				else if (commands[0].equalsIgnoreCase("webcheck"))
				{
					println(s,trace, new Color(255, 255, 255));
					try 
					{
							$DZ.check(commands[1]);
							String m = String.valueOf($DZ.check(commands[1]));
							println(m ,trace, new Color(255, 255, 255));
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				//checks for admin panel
				else if (commands[0].equalsIgnoreCase("adcheck"))
				{
					println(s,trace, new Color(255, 255, 255));
					try (BufferedReader br = new BufferedReader(new FileReader("ad_panel_links.txt")))
					{
						String Line;
						//print line by line
						while ((Line = br.readLine()) != null) 
						{
							String link = commands[1]+Line;
							$DZ.check(link);
							if($DZ.check(link)==200)
							{
							println(link,trace, new Color(255, 255, 255));
							String m = String.valueOf($DZ.check(commands[1]+Line));
							println(m ,trace, new Color(255, 255, 255));
							break;
							}
						}
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				//print text
				else
				{
					println(s ,trace, new Color(255, 255, 255));
				}
				
			}
			catch (Exception ex)
			{
				println("Error ->" + ex.getMessage(), trace, new Color(255,155,155));
			}
				
		}
		//algorithm for loop
		if (loop)
		{
			loop_times = loop_times_temp;
			loop_times_temp =1;
		}
		else
		{
			loop_times = 1;
			loop_times_temp =1;
		}
	}//end console
	
	//for tray and icon
	public static void iconTray(String []args){
	    //checking for support
	    if(!SystemTray.isSupported())
	    {
	    	JOptionPane.showMessageDialog(null, "System tray is not supported !!!", "Oooops!", JOptionPane.INFORMATION_MESSAGE);
	        return ;
	    }
	    //get the systemTray of the system
	    SystemTray systemTray = SystemTray.getSystemTray();
	    //get default toolkit
	    //get image
	    Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
	    //popupmenu
	    PopupMenu trayPopupMenu = new PopupMenu();
	    
	    //1t menuitem for popupmenu
	    MenuItem action = new MenuItem("Minimize");
	    action.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setState(JFrame.ICONIFIED);           
	        }
	    });     
	    trayPopupMenu.add(action);
    
	    //2nd menuitem of popupmenu
	    MenuItem action1 = new MenuItem("Maximize");
	    action1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	frame.setExtendedState(JFrame.NORMAL);           
	        }
	    });     
	    trayPopupMenu.add(action1);
	    
	    //3rd menuitem of popupmenu
	    MenuItem close = new MenuItem("Close");
	    close.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);             
	        }
	    });
	    trayPopupMenu.add(close);


	    //setting tray icon
	    TrayIcon trayIcon = new TrayIcon(image, "Console", trayPopupMenu);
	    //adjust to default size as per system recommendation 
	    trayIcon.setImageAutoSize(true);

	    try{
	        systemTray.add(trayIcon);
	    }catch(AWTException awtException){
	        awtException.printStackTrace();
	    }
	    

	}//end of tray
	


	
}//end of class