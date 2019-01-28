package edu.ics211.review;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Inventory dump.
 * @author you
 */
public class InventoryDump {
  
//  Objectives:
//  1) create a method called printConsoleInventory that takes a LinkedList of VideoGameConsoles
//     as a parameter and prints the information about all the VideoGameConsoles in the list. 
//     For each VideoGameConsole in the list, it should print out:
//         -manufacturer
//         -model and submodel
//         -price
  
  /**
   * Prints information about all VideoGameConsoles in the list.
   * @param VideoGameConsoles
   * @return Console info
   */
  
  public static VideoGameConsole printConsoleInventory(LinkedList videoGameConsoles) {
    if (videoGameConsoles.isEmpty()) {
      throw new NoSuchElementException();
    }
    for (int i = 0; i < videoGameConsoles.size(); i++) {
      return (VideoGameConsole) videoGameConsoles.get(i);
    }
    return null;
    
  }
//  2) Create a main method and test your printConsoleInventory method on the GameStop console
//     inventory. The output should be the following:
//  
//     Microsoft
//     Xbox One X
//     $499.99
//
//     Microsoft
//     Xbox One S
//     $299.99
//
//     Sony
//     Playstation 4 Pro
//     $399.99
   
  /**
   * Test of the video game console inventory method.
   * @param args args
   */
  
  public static void main(String[] args) {
    LinkedList<VideoGameConsole> videoGameConsoleList = new LinkedList<VideoGameConsole>();
    Xbox xboxOneX = new Xbox("Microsoft","Xbox One X",499.99);
    Xbox xboxOneS = new Xbox("Microsoft","Xbox One S",299.99);
    Playstation playstationFourPro = new Playstation("Sony","Playstation 4 Pro",399.99);
    videoGameConsoleList.add(xboxOneX);
    videoGameConsoleList.add(xboxOneS);
    videoGameConsoleList.add(playstationFourPro);
    printConsoleInventory(videoGameConsoleList);
    
  }
}
