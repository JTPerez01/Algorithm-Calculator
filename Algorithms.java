//Made with Duct tape
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
        int[] savedArray = null;
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
                savedArray = new int[arrayToBeSorted.length];
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]+" ");
                for(int n = 0; n < arrayToBeSorted.length; n++)
                    savedArray[n] = arrayToBeSorted[n];
                break;
            case 2:
              arrayToBeSorted = reverseOrder(sizeOfArray).clone();
                savedArray = new int[arrayToBeSorted.length];
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]+" ");
                for(int n = 0; n < arrayToBeSorted.length; n++)
                    savedArray[n] = arrayToBeSorted[n];
                break;
            case 3:
             arrayToBeSorted = almostOrder(sizeOfArray).clone();
                savedArray = new int[arrayToBeSorted.length];
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]+" ");
                for(int n = 0; n < arrayToBeSorted.length; n++)
                    savedArray[n] = arrayToBeSorted[n];
                break;
            case 4:
          arrayToBeSorted = randomOrder(sizeOfArray).clone();
                savedArray = new int[arrayToBeSorted.length];
                for(int k = 0; k<arrayToBeSorted.length; k++)
                    System.out.print(arrayToBeSorted[k]+" ");
                for(int n = 0; n < arrayToBeSorted.length; n++)
                    savedArray[n] = arrayToBeSorted[n];
                break;
            default:
                break;
        }
        do{
        System.out.println("\nWhat algorithm would you like to use? "+
                "\n1. Insertion Sort\n2. Selection Sort\n3. Radix Sort\n4. Heap Sort"
        +"\n5. Merge Sort\n6. Quick Sort\n");
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
            case 3:
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
        {
            arrayToBeSorted = savedArray.clone();
            System.out.println("The following array was loaded: \n");
            for(int x = 0; x < arrayToBeSorted.length; x++)
                System.out.print(arrayToBeSorted[x]+" ");
        }
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
            System.out.print(toSort[z]+" ");
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
            System.out.print(toSort[z]+" ");
       return toSort;
   }
   
   public static int[] radixSort(int[] toSort)
   {
       int length = toSort.length;
        // Find the maximum number to know number of digits
        int m = getMax(toSort, length);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(toSort, length, exp);
        for(int z = 0; z<toSort.length; z++)
            System.out.print(toSort[z]+" ");
        return toSort;
   }
   static int getMax(int[] toSort, int length)
    {
        int mx = toSort[0];
        for (int i = 1; i < length; i++)
            if (toSort[i] > mx)
                mx = toSort[i];
        return mx;
    }
   static void countSort(int[] toSort, int length, int exp)
    {
        int output[] = new int[length]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < length; i++)
            count[ (toSort[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = length - 1; i >= 0; i--)
        {
            output[count[ (toSort[i]/exp)%10 ] - 1] = toSort[i];
            count[ (toSort[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < length; i++)
            toSort[i] = output[i];
    }
   public static int[] heapSort(int[] toSort)
   {
       int N = toSort.length-1;
     
          {       
        heapify(toSort, N);        
        for (int i = N; i > 0; i--)
        {
            swap(toSort,0, i);
            N = N-1;
            maxheap(toSort, 0, N);
        }
        }
          for(int z = 0; z<toSort.length; z++)
            System.out.print(toSort[z]+" ");
        return toSort;
   }
   public static void heapify(int toSort[], int N)
    {
        N = toSort.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(toSort, i, N);        
    }
   public static void maxheap(int[] toSort, int i, int N)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && toSort[left] > toSort[i])
            max = left;
        if (right <= N && toSort[right] > toSort[max])        
            max = right;
 
        if (max != i)
        {
            swap(toSort, i, max);
            maxheap(toSort, max, N);
        }
    }    
   public static void swap(int toSort[], int i, int j)
    {
        int tmp = toSort[i];
        toSort[i] = toSort[j];
        toSort[j] = tmp; 
    }    
   
   public  static int[] mergeSort(int[] toSort)
   {
       int[] tempMergArr;
       int length;
       
        length = toSort.length;
        tempMergArr = new int[length];
        doMergeSort(0, length - 1, toSort, tempMergArr);
        for(int z = 0; z<toSort.length; z++)
            System.out.print(toSort[z]+" ");
        return toSort;
   }
   private static void mergeParts(int lowerIndex, int middle, int higherIndex, int[] toSort, int[] tempMergArr) {
 
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = toSort[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                toSort[k] = tempMergArr[i];
                i++;
            } else {
                toSort[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            toSort[k] = tempMergArr[i];
            k++;
            i++;
        }
 
    }

   private static int[] doMergeSort(int lowerIndex, int higherIndex, int[] toSort, int[] tempMergArr) {
         
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle, toSort, tempMergArr);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex, toSort, tempMergArr);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex, toSort, tempMergArr);
        }
        return toSort;
    }

   
   
   public static int[] quickSort(int[] toSort)
   {
        
        int length;
        
        length = toSort.length;
        quickSort(0, length - 1, toSort);
               
        for(int z = 0; z<toSort.length; z++)
            System.out.print(toSort[z]+" ");
        
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
     
  //try to add file output/input later
    public static void save(int[] toBeSaved, int[] savedArray) throws FileNotFoundException, IOException
    {
        /*
     File save = new File("C://Users//ayo//Desktop//dta.txt");
     FileOutputStream fos = new FileOutputStream(save);
     for(int x = 0; x < toBeSaved.length; x++)
     {
     fos.write(toBeSaved[x]);
    
     }
     fos.close();*/
        savedArray = toBeSaved.clone();
    
    }
   //one will be public int[] load()
    public static int[] load(int[] savedArray) throws FileNotFoundException, IOException
    {
        /*
        int[] retrievedArray = new int[length];
      
        File save = new File("C://Users//ayo//Desktop//dta.txt");
        FileInputStream fis = new FileInputStream(save);
        for(int x = 0; x < length; x++)
            retrievedArray[x] = fis.read();
        fis.close();
        return retrievedArray;
*/
        return savedArray;
    }

}
