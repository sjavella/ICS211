package edu.ics211.sorts;

import java.util.Comparator;

/**
 * TimedSort class.
 * @author Paul Snieder
 * @param <E> generic
 */
public class TimedSort<E> {
  
  private Sort<E> sorter;
  
  /**
   * Sorts the data and times how long it took in seconds.
   * @param sort the sorting algorithm
   * @param data the data
   * @param comp comparator
   */
  public void timedSort(SortAlgorithm sort, E[] data, Comparator<E> comp) {
    switch (sort) {
      case INSERTION:
        sorter = new InsertionSort<E>();
        break;
      case BUBBLE:
        sorter = new BubbleSort<E>();
        break;
      case SELECTION:
        sorter = new SelectionSort<E>();
        break;
      case SHELL:
        sorter = new ShellSort<E>();
        break;
      case MERGE:
        sorter = new MergeSort<E>();
        break;
      case HEAP:
        sorter = new HeapSort<E>();
        break;
      case QUICK:
        sorter = new QuickSort<E>();
        break;
      default:
        throw new IllegalArgumentException("Invalid sorting algorithm.");
    }
    
    double sortTime = sorter.timedSort(data, comp);
    
    System.out.println(sort + " of " + data.length  + " items took " + sortTime + " seconds.");

  }

}