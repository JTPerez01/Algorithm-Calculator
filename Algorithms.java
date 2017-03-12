/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;
import java.util.*;
import java.io.*;
import java.math.*;
/**
 *
 * @author ayo
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int sizeOfArray;
        int choiceOrder;
        int choice;
        long start;
        long end;
        long totalTime;
        int restart = 0;
        
        int[] arrayToBeSorted = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the size of the array in int: ");
        sizeOfArray = keyboard.nextInt();
        
        System.out.println("1. In Order\n2. Reverse Order\n3. Almost Order\n4. Random Order\n");
        choiceOrder = keyboard.nextInt();
        
        switch(choiceOrder)
        {
            case 1:
                arrayToBeSorted = inOrder(sizeOfArray).clone();
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]);
                save(arrayToBeSorted);
                break;
            case 2:
                arrayToBeSorted = reverseOrder(sizeOfArray).clone();
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]);
                save(arrayToBeSorted);
                break;
            case 3:
                arrayToBeSorted = almostOrder(sizeOfArray).clone();
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]);
                save(arrayToBeSorted);
                break;
            case 4:
                arrayToBeSorted = randomOrder(sizeOfArray).clone();
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]);
                save(arrayToBeSorted);
                break;
            default:
                break;
        }
        do{
        System.out.println("\nWhat algorithm would you like to use? "+
                "\n1. Insertion Sort\n2. Selection Sort\n3. Radix Sort\n4. Heap Sort"
        +"5. Merge Sort\n6. Quick Sort\n");
        choice = keyboard.nextInt();
        switch(choice)
        {
            
            case 1:
                start = System.currentTimeMillis();
                insertionSort(arrayToBeSorted);
                end = System.currentTimeMillis();
                totalTime = end - start;
                System.out.print("\nThis process took "+totalTime+"ms.\n");
                break;
            case 2:
                start = System.currentTimeMillis();
                selectionSort(arrayToBeSorted);
                end = System.currentTimeMillis();
                totalTime = end - start;
                System.out.print("\nThis process took "+totalTime+"ms.\n");
                break;
            /*case 3:
                start = System.currentTimeMillis();
                radixSort(arrayToBeSorted);
                end = System.currentTimeMillis();
                totalTime = end - start;
                System.out.print("\nThis process took "+totalTime+"ms.\n");
                break;  
            case 4:
                start = System.currentTimeMillis();
                heapSort(arrayToBeSorted);
                end = System.currentTimeMillis();
                totalTime = end - start;
                System.out.print("\nThis process took "+totalTime+"ms.\n");
                break;
            case 5:
                start = System.currentTimeMillis();
                mergeSort(arrayToBeSorted);
                end = System.currentTimeMillis();
                totalTime = end - start;
                System.out.print("\nThis process took "+totalTime+"ms.\n");
                break;
                */
            case 6:
                start = System.currentTimeMillis();
                quickSort(arrayToBeSorted);
                end = System.currentTimeMillis();
                totalTime = end - start;
                System.out.print("\nThis process took "+totalTime+"ms.\n");
                break;
            default:
                break;
        }
        System.out.println("\nPress '1' to use the same data on a different algorithm! ");
        restart = keyboard.nextInt();
        if(restart == 1)
            arrayToBeSorted = load(sizeOfArray).clone();
        else
            break;
    }while(restart != 0);
       
    }
    //this is where the creation of the array to be sorted will go
    //remember to loop creation until preSort.length
    public static int[] inOrder(int sizeOfArray)
    {
        int[] tempArray = new int[sizeOfArray];
        for(int x = 0; x < sizeOfArray; x++)
        {
            tempArray[x] = x;
        }
        
        return tempArray;
    }
    public static int[] reverseOrder(int sizeOfArray)
    {
        int[] tempArray = new int[sizeOfArray];
      
        for(int x = 0; x < sizeOfArray; x++)
        {
            tempArray[x] = sizeOfArray - x - 1;
          
            
        }
        
        return tempArray;        
    }
    public static int[] almostOrder(int sizeOfArray)
    {
        int[] tempArray = new int[sizeOfArray];
        for(int x = 0; x < sizeOfArray; x++)
        {
            if(x%5 == 0)
            {
                tempArray[x] = 5;
            }
            else if(x%7 == 0)
            {
                tempArray[x] = 7;
            }
            else
            tempArray[x] = x;
        }
        return tempArray;
    }
    public static int[] randomOrder(int sizeOfArray)
    {
        int[] tempArray = new int[sizeOfArray];
        Random rand = new Random();
        for(int x = 0; x < sizeOfArray; x++)
        {
            //generate random numbers from 0 to the size of array -1
            tempArray[x] = rand.nextInt(sizeOfArray);
        }
        return tempArray;
    }
       
    //this is where the sorting algorithms will go
   public static int[] insertionSort(int[] toSort)
   {
       int temp;
        for (int i = 1; i < toSort.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(toSort[j] < toSort[j-1]){
                    temp = toSort[j];
                    toSort[j] = toSort[j-1];
                    toSort[j-1] = temp;
                }
            }
        }
        for(int z = 0; z<toSort.length; z++)
            System.out.print(toSort[z]);
        return toSort;
 
   }
   
   public static int[] selectionSort(int[] toSort)
   {
       for (int i = 0; i < toSort.length - 1; i++)
	    {
	        int index = i;
	        for (int j = i + 1; j < toSort.length; j++)
	            if (toSort[j] < toSort[index]) 
	                index = j;
	 
	        int smallerNumber = toSort[index];  
	        toSort[index] = toSort[i];
	        toSort[i] = smallerNumber;
	    }
       for(int z = 0; z<toSort.length; z++)
            System.out.print(toSort[z]);
       return toSort;
   }
   /*
   public static int[] radixSort(int[] x)
   {

   }
   public static int[] heapSort(int[] x)
   {
       
   }
   */
   /*
   public static int[] mergeSort(int[] x)
   {
       
   }
   */
   
   public static int[] quickSort(int[] toSort)
   {
        
        int length;
        
        length = toSort.length;
        quickSort(0, length - 1, toSort);
               
        for(int z = 0; z<toSort.length; z++)
            System.out.print(toSort[z]);
        
        return toSort;
   }
    public static void quickSort(int lowerIndex, int higherIndex, int[] toSort) {
         
        int i = lowerIndex;
        int j = higherIndex;
       
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = toSort[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (toSort[i] < pivot) {
                i++;
            }
            while (toSort[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, toSort);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j, toSort);
        if (i < higherIndex)
            quickSort(i, higherIndex, toSort);
    }
 
    private static void exchangeNumbers(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
   // add a method here to save the first array created for re use
   //one will be save(int[] toBeSaved)
    public static void save(int[] toBeSaved) throws FileNotFoundException, IOException
    {
     File save = new File("C://Users//ayo//Desktop//dta.txt");
     FileOutputStream fos = new FileOutputStream(save, false);
     for(int x = 0; x < toBeSaved.length; x++)
     {
     fos.write(toBeSaved[x]);
     }
     fos.close();
    
    }
   //one will be public int[] load()
    public static int[] load(int length) throws FileNotFoundException, IOException
    {
        int[] retrievedArray = new int[length];
      
        File save = new File("C://Users//ayo//Desktop//dta.txt");
        FileInputStream fis = new FileInputStream(save);
        for(int x = 0; x < length-1; x++)
            retrievedArray[x] = fis.read();
        return retrievedArray;
    }

}
