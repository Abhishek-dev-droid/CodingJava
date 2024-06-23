
class Solution
{
	int  select(int arr[], int i)
	{
        // code here such that selectionSort() sorts arr[]
        selectionSort(arr,i);
        return 1;
	}
	
	void selectionSort(int arr[], int n)
	{

	    for(int i = 0; i < n-1; i++){
	        int min = i;
	        for(int j = i+1; j < n; j++){
	            if(arr[j] < arr[min])
                    min=j;
	        }
	        swap(arr, i , min);
	    }
	}
	
	    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
