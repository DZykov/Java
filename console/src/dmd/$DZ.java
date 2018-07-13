package dmd;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import javax.swing.JOptionPane;

class $DZ {
	
	//msg
	/**
	 * This method is taking string and prints this string in console
	 * @param msg
	 */
	
	public static void print (String msg)
	{
		System.out.println(msg);
		int a = getRand(5);
	}
	
	//generate random number
    /**
     * This method is taking integer and multiply on random number than adding one
     * @param min
     * @return integer
     */
	public static int getRand (int max)
	{
		int num = (int)(Math.random()*max)+1;
		return num; 
	}


	
	//encryption
    /**
     * This method is taking string than changing all letters to symbols
     * @param text
     * @return string
     */
	public static String crypt(String text) 
	{
        String crypt = "";
		
		for (int i=0; i<text.length(); i++)
		{
			//letters
			if (text.substring(i, i+1).equalsIgnoreCase(" ")){crypt += "_17_";}
			if (text.substring(i, i+1).equalsIgnoreCase("a")){crypt += "adf6";}
			if (text.substring(i, i+1).equalsIgnoreCase("b")){crypt += "mnj3";}
			if (text.substring(i, i+1).equalsIgnoreCase("c")){crypt += "hoiu";}
			if (text.substring(i, i+1).equalsIgnoreCase("d")){crypt += "dmdz";}
			if (text.substring(i, i+1).equalsIgnoreCase("e")){crypt += "7fds";}
			if (text.substring(i, i+1).equalsIgnoreCase("f")){crypt += "fu8x";}
			if (text.substring(i, i+1).equalsIgnoreCase("g")){crypt += "6gh2";}
			if (text.substring(i, i+1).equalsIgnoreCase("h")){crypt += "0kcd";}
			if (text.substring(i, i+1).equalsIgnoreCase("i")){crypt += "7hdd";}
			if (text.substring(i, i+1).equalsIgnoreCase("j")){crypt += "zxd1";}
			if (text.substring(i, i+1).equalsIgnoreCase("k")){crypt += "cos9";}
			if (text.substring(i, i+1).equalsIgnoreCase("l")){crypt += "as7u";}
			if (text.substring(i, i+1).equalsIgnoreCase("m")){crypt += "sdue";}
			if (text.substring(i, i+1).equalsIgnoreCase("n")){crypt += "frg6";}
			if (text.substring(i, i+1).equalsIgnoreCase("o")){crypt += "47us";}
			if (text.substring(i, i+1).equalsIgnoreCase("p")){crypt += "axcb";}
			if (text.substring(i, i+1).equalsIgnoreCase("q")){crypt += "oiug";}
			if (text.substring(i, i+1).equalsIgnoreCase("r")){crypt += "nbcv";}
			if (text.substring(i, i+1).equalsIgnoreCase("s")){crypt += "cvbn";}
			if (text.substring(i, i+1).equalsIgnoreCase("t")){crypt += "37dk";}
			if (text.substring(i, i+1).equalsIgnoreCase("u")){crypt += "las9";}
			if (text.substring(i, i+1).equalsIgnoreCase("v")){crypt += "loh6";}
			if (text.substring(i, i+1).equalsIgnoreCase("w")){crypt += "zxcy";}
			if (text.substring(i, i+1).equalsIgnoreCase("x")){crypt += "vxbf";}
			if (text.substring(i, i+1).equalsIgnoreCase("y")){crypt += "yrnf";}
			if (text.substring(i, i+1).equalsIgnoreCase("z")){crypt += "pasl";}
			//letters ru
			if (text.substring(i, i+1).equalsIgnoreCase("й")){crypt += "xuyi";}
			if (text.substring(i, i+1).equalsIgnoreCase("ц")){crypt += "cece";}
			if (text.substring(i, i+1).equalsIgnoreCase("у")){crypt += "yuyu";}
			if (text.substring(i, i+1).equalsIgnoreCase("к")){crypt += "ckkc";}
			if (text.substring(i, i+1).equalsIgnoreCase("е")){crypt += "yore";}
			if (text.substring(i, i+1).equalsIgnoreCase("н")){crypt += "n&hl";}
			if (text.substring(i, i+1).equalsIgnoreCase("г")){crypt += "ggwp";}
			if (text.substring(i, i+1).equalsIgnoreCase("ш")){crypt += "glhf";}
			if (text.substring(i, i+1).equalsIgnoreCase("щ")){crypt += "hfhl";}
			if (text.substring(i, i+1).equalsIgnoreCase("з")){crypt += "dmzz";}
			if (text.substring(i, i+1).equalsIgnoreCase("х")){crypt += "xxxp";}
			if (text.substring(i, i+1).equalsIgnoreCase("ъ")){crypt += "lpoi";}
			if (text.substring(i, i+1).equalsIgnoreCase("ф")){crypt += "phue";}
			if (text.substring(i, i+1).equalsIgnoreCase("ы")){crypt += "iyyi";}
			if (text.substring(i, i+1).equalsIgnoreCase("в")){crypt += "vika";}
			if (text.substring(i, i+1).equalsIgnoreCase("а")){crypt += "kisa";}
			if (text.substring(i, i+1).equalsIgnoreCase("п")){crypt += "pisa";}
			if (text.substring(i, i+1).equalsIgnoreCase("р")){crypt += "rorp";}
			if (text.substring(i, i+1).equalsIgnoreCase("о")){crypt += "o00o";}
			if (text.substring(i, i+1).equalsIgnoreCase("л")){crypt += "love";}
			if (text.substring(i, i+1).equalsIgnoreCase("д")){crypt += "zkvd";}
			if (text.substring(i, i+1).equalsIgnoreCase("ж")){crypt += "zopa";}
			if (text.substring(i, i+1).equalsIgnoreCase("э")){crypt += "elos";}
			if (text.substring(i, i+1).equalsIgnoreCase("я")){crypt += "yaii";}
			if (text.substring(i, i+1).equalsIgnoreCase("ч")){crypt += "chch";}
			if (text.substring(i, i+1).equalsIgnoreCase("с")){crypt += "sccs";}
			if (text.substring(i, i+1).equalsIgnoreCase("м")){crypt += "mmmd";}
			if (text.substring(i, i+1).equalsIgnoreCase("и")){crypt += "andi";}
			if (text.substring(i, i+1).equalsIgnoreCase("т")){crypt += "titi";}
			if (text.substring(i, i+1).equalsIgnoreCase("ь")){crypt += "lpol";}
			if (text.substring(i, i+1).equalsIgnoreCase("б")){crypt += "baba";}
			if (text.substring(i, i+1).equalsIgnoreCase("ю")){crypt += "uyou";}
			//C:\Users\2018163\Desktop
			//numbers
			if (text.substring(i, i+1).equalsIgnoreCase("1")){crypt += "loll";}
			if (text.substring(i, i+1).equalsIgnoreCase("2")){crypt += "iioi";}
			if (text.substring(i, i+1).equalsIgnoreCase("3")){crypt += "ethr";}
			if (text.substring(i, i+1).equalsIgnoreCase("4")){crypt += "quat";}
			if (text.substring(i, i+1).equalsIgnoreCase("5")){crypt += "pyat";}
			if (text.substring(i, i+1).equalsIgnoreCase("6")){crypt += "phut";}
			if (text.substring(i, i+1).equalsIgnoreCase("7")){crypt += "asxg";}
			if (text.substring(i, i+1).equalsIgnoreCase("8")){crypt += "tgth";}
			if (text.substring(i, i+1).equalsIgnoreCase("9")){crypt += "ytre";}
			if (text.substring(i, i+1).equalsIgnoreCase("0")){crypt += "mjuk";}
			//symbols
			if (text.substring(i, i+1).equalsIgnoreCase("!")){crypt += "lili";}
			if (text.substring(i, i+1).equalsIgnoreCase("@")){crypt += "adad";}
			if (text.substring(i, i+1).equalsIgnoreCase("#")){crypt += "hmhm";}
			if (text.substring(i, i+1).equalsIgnoreCase("$")){crypt += "dldl";}
			if (text.substring(i, i+1).equalsIgnoreCase("%")){crypt += "olol";}
			if (text.substring(i, i+1).equalsIgnoreCase("^")){crypt += "vwvw";}
			if (text.substring(i, i+1).equalsIgnoreCase("&")){crypt += "adnn";}
			if (text.substring(i, i+1).equalsIgnoreCase("*")){crypt += "qeqe";}
			if (text.substring(i, i+1).equalsIgnoreCase("(")){crypt += "cscs";}
			if (text.substring(i, i+1).equalsIgnoreCase(")")){crypt += "scsc";}
			if (text.substring(i, i+1).equalsIgnoreCase("-")){crypt += "xvvx";}
			if (text.substring(i, i+1).equalsIgnoreCase("_")){crypt += "vxxv";}
			if (text.substring(i, i+1).equalsIgnoreCase("+")){crypt += "plsu";}
			if (text.substring(i, i+1).equalsIgnoreCase("=")){crypt += "uqal";}
			if (text.substring(i, i+1).equalsIgnoreCase("|")){crypt += "llll";}
			if (text.substring(i, i+1).equalsIgnoreCase("\\")){crypt += "iill";}
			if (text.substring(i, i+1).equalsIgnoreCase("/")){crypt += "llii";}
			if (text.substring(i, i+1).equalsIgnoreCase(".")){crypt += "oooo";}
			if (text.substring(i, i+1).equalsIgnoreCase(",")){crypt += "qqqq";}
			if (text.substring(i, i+1).equalsIgnoreCase(">")){crypt += "bols";}
			if (text.substring(i, i+1).equalsIgnoreCase("<")){crypt += "menc";}
			if (text.substring(i, i+1).equalsIgnoreCase("'")){crypt += "opos";}
			if (text.substring(i, i+1).equalsIgnoreCase("`")){crypt += "podo";}
			if (text.substring(i, i+1).equalsIgnoreCase("~")){crypt += "hern";}
			if (text.substring(i, i+1).equalsIgnoreCase("[")){crypt += "kvad";}
			if (text.substring(i, i+1).equalsIgnoreCase("]")){crypt += "dvak";}
			if (text.substring(i, i+1).equalsIgnoreCase("{")){crypt += "kuin";}
			if (text.substring(i, i+1).equalsIgnoreCase("}")){crypt += "niuk";}
			
		}
		
		return crypt;
		
	}//end of method

    /**
     * This method is taking string than changing all letters, numbers to the symbols
     * @param text1
     * @return string
     */
	public static String decrypt(String text1) 
	{
        String crypt = "";
		
		for (int i=0; i<text1.length(); i+=4)
		{
			//letters
			if (text1.substring(i, i+4).equalsIgnoreCase("_17_")){crypt += " ";}
			if (text1.substring(i, i+4).equalsIgnoreCase("adf6")){crypt += "a";}
			if (text1.substring(i, i+4).equalsIgnoreCase("mnj3")){crypt += "b";}
			if (text1.substring(i, i+4).equalsIgnoreCase("hoiu")){crypt += "c";}
			if (text1.substring(i, i+4).equalsIgnoreCase("dmdz")){crypt += "d";}
			if (text1.substring(i, i+4).equalsIgnoreCase("7fds")){crypt += "e";}
			if (text1.substring(i, i+4).equalsIgnoreCase("fu8x")){crypt += "f";}
			if (text1.substring(i, i+4).equalsIgnoreCase("6gh2")){crypt += "g";}
			if (text1.substring(i, i+4).equalsIgnoreCase("0kcd")){crypt += "h";}
			if (text1.substring(i, i+4).equalsIgnoreCase("7hdd")){crypt += "i";}
			if (text1.substring(i, i+4).equalsIgnoreCase("zxd1")){crypt += "j";}
			if (text1.substring(i, i+4).equalsIgnoreCase("cos9")){crypt += "k";}
			if (text1.substring(i, i+4).equalsIgnoreCase("as7u")){crypt += "l";}
			if (text1.substring(i, i+4).equalsIgnoreCase("sdue")){crypt += "m";}
			if (text1.substring(i, i+4).equalsIgnoreCase("frg6")){crypt += "n";}
			if (text1.substring(i, i+4).equalsIgnoreCase("47us")){crypt += "o";}
			if (text1.substring(i, i+4).equalsIgnoreCase("axcb")){crypt += "p";}
			if (text1.substring(i, i+4).equalsIgnoreCase("oiug")){crypt += "q";}
			if (text1.substring(i, i+4).equalsIgnoreCase("nbcv")){crypt += "r";}
			if (text1.substring(i, i+4).equalsIgnoreCase("cvbn")){crypt += "s";}
			if (text1.substring(i, i+4).equalsIgnoreCase("37dk")){crypt += "t";}
			if (text1.substring(i, i+4).equalsIgnoreCase("las9")){crypt += "u";}
			if (text1.substring(i, i+4).equalsIgnoreCase("loh6")){crypt += "v";}
			if (text1.substring(i, i+4).equalsIgnoreCase("zxcy")){crypt += "w";}
			if (text1.substring(i, i+4).equalsIgnoreCase("vxbf")){crypt += "x";}
			if (text1.substring(i, i+4).equalsIgnoreCase("yrnf")){crypt += "y";}
			if (text1.substring(i, i+4).equalsIgnoreCase("pasl")){crypt += "z";}
			//letters ru
			if (text1.substring(i, i+4).equalsIgnoreCase("xuyi")){crypt += "й";}
			if (text1.substring(i, i+4).equalsIgnoreCase("xuyi")){crypt += "ц";}
			if (text1.substring(i, i+4).equalsIgnoreCase("yuyu")){crypt += "у";}
			if (text1.substring(i, i+4).equalsIgnoreCase("ckkc")){crypt += "к";}
			if (text1.substring(i, i+4).equalsIgnoreCase("yore")){crypt += "е";}
			if (text1.substring(i, i+4).equalsIgnoreCase("n&hl")){crypt += "н";}
			if (text1.substring(i, i+4).equalsIgnoreCase("ggwp")){crypt += "г";}
			if (text1.substring(i, i+4).equalsIgnoreCase("glhf")){crypt += "ш";}
			if (text1.substring(i, i+4).equalsIgnoreCase("hfhl")){crypt += "щ";}
			if (text1.substring(i, i+4).equalsIgnoreCase("dmzz")){crypt += "з";}
			if (text1.substring(i, i+4).equalsIgnoreCase("xxxp")){crypt += "х";}
			if (text1.substring(i, i+4).equalsIgnoreCase("lpoi")){crypt += "ъ";}
			if (text1.substring(i, i+4).equalsIgnoreCase("phue")){crypt += "ф";}
			if (text1.substring(i, i+4).equalsIgnoreCase("iyyi")){crypt += "ы";}
			if (text1.substring(i, i+4).equalsIgnoreCase("vika")){crypt += "в";}
			if (text1.substring(i, i+4).equalsIgnoreCase("kisa")){crypt += "а";}
			if (text1.substring(i, i+4).equalsIgnoreCase("pisa")){crypt += "п";}
			if (text1.substring(i, i+4).equalsIgnoreCase("rorp")){crypt += "р";}
			if (text1.substring(i, i+4).equalsIgnoreCase("o00o")){crypt += "о";}
			if (text1.substring(i, i+4).equalsIgnoreCase("love")){crypt += "л";}
			if (text1.substring(i, i+4).equalsIgnoreCase("zkvd")){crypt += "д";}
			if (text1.substring(i, i+4).equalsIgnoreCase("zopa")){crypt += "ж";}
			if (text1.substring(i, i+4).equalsIgnoreCase("elos")){crypt += "э";}
			if (text1.substring(i, i+4).equalsIgnoreCase("yaii")){crypt += "я";}
			if (text1.substring(i, i+4).equalsIgnoreCase("chch")){crypt += "ч";}
			if (text1.substring(i, i+4).equalsIgnoreCase("sccs")){crypt += "с";}
			if (text1.substring(i, i+4).equalsIgnoreCase("mmmd")){crypt += "м";}
			if (text1.substring(i, i+4).equalsIgnoreCase("andi")){crypt += "и";}
			if (text1.substring(i, i+4).equalsIgnoreCase("titi")){crypt += "т";}
			if (text1.substring(i, i+4).equalsIgnoreCase("lpol")){crypt += "ь";}
			if (text1.substring(i, i+4).equalsIgnoreCase("baba")){crypt += "б";}
			if (text1.substring(i, i+4).equalsIgnoreCase("uyou")){crypt += "ю";}
			//numbers
			if (text1.substring(i, i+4).equalsIgnoreCase("loll")){crypt += "1";}
			if (text1.substring(i, i+4).equalsIgnoreCase("iioi")){crypt += "2";}
			if (text1.substring(i, i+4).equalsIgnoreCase("ethr")){crypt += "3";}
			if (text1.substring(i, i+4).equalsIgnoreCase("quat")){crypt += "4";}
			if (text1.substring(i, i+4).equalsIgnoreCase("pyat")){crypt += "5";}
			if (text1.substring(i, i+4).equalsIgnoreCase("phut")){crypt += "6";}
			if (text1.substring(i, i+4).equalsIgnoreCase("asxg")){crypt += "7";}
			if (text1.substring(i, i+4).equalsIgnoreCase("tgth")){crypt += "8";}
			if (text1.substring(i, i+4).equalsIgnoreCase("ytre")){crypt += "9";}
			if (text1.substring(i, i+4).equalsIgnoreCase("mjuk")){crypt += "0";}
			//symbols
			if (text1.substring(i, i+4).equalsIgnoreCase("lili")){crypt += "!";}
			if (text1.substring(i, i+4).equalsIgnoreCase("adad")){crypt += "@";}
			if (text1.substring(i, i+4).equalsIgnoreCase("hmhm")){crypt += "#";}
			if (text1.substring(i, i+4).equalsIgnoreCase("dldl")){crypt += "$";}
			if (text1.substring(i, i+4).equalsIgnoreCase("olol")){crypt += "%";}
			if (text1.substring(i, i+4).equalsIgnoreCase("vwvw")){crypt += "^";}
			if (text1.substring(i, i+4).equalsIgnoreCase("adnn")){crypt += "&";}
			if (text1.substring(i, i+4).equalsIgnoreCase("qeqe")){crypt += "*";}
			if (text1.substring(i, i+4).equalsIgnoreCase("cscs")){crypt += "(";}
			if (text1.substring(i, i+4).equalsIgnoreCase("scsc")){crypt += ")";}
			if (text1.substring(i, i+4).equalsIgnoreCase("xvvx")){crypt += "-";}
			if (text1.substring(i, i+4).equalsIgnoreCase("vxxv")){crypt += "_";}
			if (text1.substring(i, i+4).equalsIgnoreCase("plsu")){crypt += "+";}
			if (text1.substring(i, i+4).equalsIgnoreCase("uqal")){crypt += "=";}
			if (text1.substring(i, i+4).equalsIgnoreCase("llll")){crypt += "|";}
			if (text1.substring(i, i+4).equalsIgnoreCase("iill")){crypt += "\\";}
			if (text1.substring(i, i+4).equalsIgnoreCase("llii")){crypt += "/";}
			if (text1.substring(i, i+4).equalsIgnoreCase("oooo")){crypt += ".";}
			if (text1.substring(i, i+4).equalsIgnoreCase("qqqq")){crypt += ",";}
			if (text1.substring(i, i+4).equalsIgnoreCase("bols")){crypt += ">";}
			if (text1.substring(i, i+4).equalsIgnoreCase("menc")){crypt += "<";}
			if (text1.substring(i, i+4).equalsIgnoreCase("opos")){crypt += "'";}
			if (text1.substring(i, i+4).equalsIgnoreCase("podo")){crypt += "`";}
			if (text1.substring(i, i+4).equalsIgnoreCase("hern")){crypt += "~";}
			if (text1.substring(i, i+4).equalsIgnoreCase("kvad")){crypt += "[";}
			if (text1.substring(i, i+4).equalsIgnoreCase("dvak")){crypt += "]";}
			if (text1.substring(i, i+4).equalsIgnoreCase("kuin")){crypt += "{";}
			if (text1.substring(i, i+4).equalsIgnoreCase("niuk")){crypt += "}";}
		}
		
		return crypt;
		
	}//end of method
	
	//the largest and smallest
    /**
     * This method is taking array of integer than finding max and min
     * @param num
     * @return integer
     */
    public static int SLArray (int [] num)
    {
        int max = 0;
        int min = num[0];
        for (int i = 0; i <num.length;i++) 
        {
              if (num[i] > max) max = num[i];
              else if (num[i] < min) min = num[i];
        }
        
        return max & min;
    } //end SLArray

	//count the elements in string array
    /**
     * This method is taking array of strings and counting how many elements in array
     * @param string
     * @return integer
     */
    public static int countAr (String [] string)
    {
        int count = 0;
        for (int i = 0; i < string.length; i ++)
            if (string[i] != null)
                count ++;
        return count;
    } //end SLArray
	
    //int array elements
    /**
     * This method is taking array of integer and returning ODD AND EVEN numbers
     * @param num
     * @return integer
     */
    public static int countInt (int [] num)
    {
        int countO = 0;
        int countE = 0;
        for (int i = 0; i < num.length; i ++)
            if (num[i] % 2 ==0){countO ++;}
            else if (num[i] % 2 ==1){countE ++;}
        
        return countE & countO;
    }// end

    //isPrime
    //song: until were gone reez remix (i like this song)
    /**
     * This method is checking is number prime or not
     * @param num
     * @return boolean
     */
    public static boolean isPrime (int num)
    {
    	int check;
    	for(int i=2;i<=num/2;i++) //division on 1 is useless, because it will give the exact number
    	 { 
    		check=num%i;
    	    if(check==0){return false;}
    	 }
    	return true;
    }// end

    //nextPrime
    /**
     * This method is taking number and finding the nearest prime number which is bigger
     * @param num
     * @return integer
     */
    public static int nextPrime (int num)
    {
    	while(true)
    	{
    		boolean isprime = true;
    		num++;
    		int sqt = (int)Math.sqrt(num);
    		for(int i=2;i<=sqt;i++)
    		{
    			if(num%i==0)
    			{
    			isprime = false;
    			break;
    			}
    		}
    		if(isprime){return num;}
    	}
    }// end

    //string loop
    //replace "a" with "!"
    /**
     * This method is taking string and replacing "a" with !
     * @param str
     * @return string
     */
    public static String stringloop (String str)
    {
    	String tst = "";
    	for(int i=0; i<str.length();i++)
    	{
    		if (str.substring(i,i+1).equals("a"))
    		{
    			tst = str.replace("a", "!");
    		}
    	}  	
		return tst;  	
    }//end
    //same
    /**
     * This method is taking string and replacing "a" with "!" (with out replace)
     * @param str
     * @return string
     */
    public static String stringL(String str) 
    {
    	  String hello = "";
    	  for (int i = 0; i < str.length(); i++) 
    	  {

    	   if (str.charAt(i) == 'a')
    	    hello = hello + '!';
    	   
    	   else
    	    hello = hello + str.charAt(i);
    	  }
    	  return hello;
    }
    
    //array loop
 
    /**
     * This method is taking array of integer and returning max value (change return max to return min, to get min value) 
     * @param nums
     * @return integer
     */
    public static int minmax(int[] nums) 
    	{
    	  int max = nums[0];
    	  int min = nums[0];
    	  
    	  for (int i = 0; i < nums.length; i++) 
    	  { 
    	  if (nums[i] > max) {max = nums[i];}
    	  if (nums[i] < min) {min = nums[i];}
    	  } 
    	  return max;
    	}
        
    //bubble sort int
    /**
     * This method is taking array of integer and resorting it from smallest to biggest
     * @param num
     */
    public static void bubbleint( int [ ] num )
    {
    	 
         int temp = 0;
        
         for(int i=0; i < num.length; i++)
         {//for loop 1
                 for(int j=1; j < (num.length-i); j++)
                 {//for loop 2
                        
                         if(num[j-1] > num[j])
                         {//if start
                                 //swap the elements
                                 temp = num[j-1];
                                 num[j-1] = num[j];
                                 num[j] = temp;
                         }//if end
                        
                 }//for loop 2
         }//for loop 1  
	} //end

    //bubble sort strings
    /**
     * This method is taking array of strings and resorting it from smallest to biggest
     * @param str
     */
    public static void bubblestr( String [ ] str )
    {
    	 
         String temp;
        
         for(int i=0; i < str.length; i++)
         {//for loop 1
                 for(int j=1; j < (str.length-i); j++)
                 {//for loop 2
                        
                         if(str[j-1].length() >str[j].length())
                         {//if start
                                 //swap the elements
                                 temp = str[j-1];
                                 str[j-1] = str[j];
                                 str[j] = temp;
                         }//if end
                        
                 }//for loop 2
         }//for loop 1  
	} //end
    //insertion sort int
    /**
     * This method is taking array of integer and resorting it from smallest to biggest
     * @param num
     */
    public static void insertsort( int [ ] num)
    {
         int j;// the number of items
         int key, i;  

         for (j = 1; j < num.length; j++)
        {
               key = num[j];//storing value
               for(i =j-1;(i >= 0) && (num[i] >key); i--) //small values going up
              {
                     num[ i+1 ] = num[ i ];
              }
             num[ i+1 ] = key;
         }
    }
    //selection sort int
    /**
     * This method is taking array of integer and resorting it from smallest to largest
     * @param num
     */
    public static void selectsort (int[] num)
    {
         int i, j, first, temp;  
         for ( i = num.length - 1; i > 0; i--)  
         {
              first = 0;//storing first element
              for(j = 1; j <= i; j ++)//move smallest element between positions 1 and i
              {
                   if( num[j] > num[first]){first = j;}
              }
              temp = num[first];//swap smallest found with element in position i
              num[first] = num[i];
              num[i] = temp; 
          }           
    }//end
    
    //binary search
    /**
     * This method is taking array of integer and searching another integer (which you need) 
     * @param a
     * @param key
     * @return integer
     */
    public static int search(int[] a, int key) 
    {
        if (a.length == 0){return 0;}
        int low = 0;
        int high = a.length-1;
        int mid;
        while (low <= high) 
        {
            mid = (low + high) / 2;
            if (mid > key) {high = mid - 1;} 
            else if (mid < key) {low = mid + 1;} 
            else {int f= a.length-mid-1;return f;}
        }
        return 0;
      }
    
    /**
     *  This method takes a string and puts each letter in a new 
     *  array of characters.  The method should return the array
     *  of characters. 
     *  
     *  @param String
     *  @return char[]
     *
     */
    public static char[] toCharArray(String word) 
    {
    	char [] array = new char [word.length()];
    	
    	for(int i=0; i<word.length(); i++)
    	{
    		array[i] = (word.charAt(i));
    	}
    	
    	return array; 
    }
    
    //youtube
    public static String getLink(String name) 
    {
		String Link = null;
		try {
			//Url Connection is needed to read the html of the the website
			//it works with God strength
			URLConnection conn =  new URL("https://www.youtube.com/results?search_query=" + name).openConnection();

			//open the stream and put it into BufferedReader to read the html
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			boolean read = true;
			while (read) 
			{
				String line = br.readLine();
				if (line == null)
				{
					read = false;
					return null;
				}
				//unfortunately, this is the only way how to search code of a website
				if (line.contains("<a href=\"/watch"))
				{ 
					return "www.youtube.com" //Returns the youtube link
				    + line.split("<a href=\"")[1].split("\"")[0];
				}
			}

		} 
		catch (Exception e) 
		{
			//if this happens good luck
			//i have no idea how to fix it
			e.printStackTrace();
		}

		return Link;
	}
    
    //receiving response code
    public static int check(String urlString) throws MalformedURLException, IOException {
	    URL u = new URL(urlString); 
	    HttpURLConnection huc =  (HttpURLConnection)  u.openConnection(); 
	    huc.setRequestMethod("GET"); 
	    huc.connect(); 
	    return huc.getResponseCode();
	}

    
}
