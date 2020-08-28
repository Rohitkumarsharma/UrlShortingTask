package com.urlshortener.util;

import java.util.Random;

public class RamdomUniqueGenratorUtil 
{  
	
	private final static char[] base62String = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static String convertBase10ToBase62ID(int id) 
	{
        String ret="";
        while(id > 0)
        {
            int remainder = (int)(id % 62);
            ret = ret+ base62String[remainder];
            id /= 62;
        }
        return ret;
    }
	
	public static int getRandomNumberString()
	{
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	     String format = String.format("%06d", number);
	     return Integer.valueOf(format);
	}

}
