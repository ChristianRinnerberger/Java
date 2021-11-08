package BubbleSort;

public class BubbleSort
{


    public static void main(String[]args)
    {


            int[]unsorted = {5,8,6,0,2,3,9,4,8,7,1};
            int[]sorted = bubblesort(unsorted);


        for (int i = 0; i< unsorted.length;i++)
        {
            System.out.println(sorted[i]);
        }


    }

    public static int[]bubblesort(int[]unsorted)
    {
       int temp;
       for (int i = 1; i < unsorted.length; i++)
       {
           for (int j = 0; j<unsorted.length -i;j++)
           {
               if (unsorted[j]>unsorted[j+1])
               {
                   temp = unsorted[j];
                   unsorted[j]=unsorted[j+1];
                   unsorted[j+1]=temp;
               }
           }
       }
       return unsorted;
    }
}
