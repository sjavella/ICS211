/**
 * FileDump.java
 * Copyright (C) Simplicio Javellana-Samonte 2018
 */
package edu.ics211.h00;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Prints out the contents of any file.
 *
 * @author Simplicio Javellana-Samonte Worked with Micah Kim & Matthew Kim regarding UTF-8 encoding.
 */
public class FileDump {
  private static int count;
  private static Scanner sc;

  /**
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    System.out.print("Insert File Destination:");
    Scanner inputFile = new Scanner(System.in);
    args[0] = inputFile.nextLine();

    FileReader fr = new FileReader(args[0]);
    BufferedReader br = new BufferedReader(fr);

    while ((count = br.read()) != -1) {
      printInBinary();
    }

    fr.close();
    System.out.println("");
    FileReader fr2 = new FileReader(args[0]);
    BufferedReader br2 = new BufferedReader(fr2);

    while ((count = br2.read()) != -1) {
      printInHexadecimal();
    }
    fr2.close();
    System.out.println("");
    System.out.println("UTF-8 contents of file:");
    FileReader fr3 = new FileReader(args[0]);
    sc = new Scanner(fr3);

    while (sc.hasNext()) {
      printInUTF();
    }
  }


  /**
   * Prints file contents as binary.
   */

  public static void printInBinary() {
    
    String s = Integer.toBinaryString(count);
    System.out.print("0" + s + " ");
  }


  /**
   * Prints file contents as hexadecimal.
   */

  public static void printInHexadecimal() {
    String d = Integer.toHexString(count);
    System.out.print(d + " ");
  }


  /**
   * Prints file contents as UTF-8.
   * 
   * @throws UnsupportedEncodingException - if there is an invalid encoding type, throws an exception.
   * @throws FileNotFoundException - if there is no file found, throws an exception.
   */
  
  public static void printInUTF() {
    String f = sc.next();
    byte[] data = f.getBytes();
    String s = new String(data, Charset.forName("UTF-8"));
    System.out.print(s + " ");
  }

}
