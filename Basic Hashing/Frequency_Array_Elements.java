class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        // code here
        HashMap<Integer , Integer> mp=new HashMap<>();
        // solution 1:
        
        // for(int i = 1; i <= N; i++){
        //         mp.put(i,0);
        // }
        
        // for(int i = 1; i <= N; i++){
        //     if(mp.containsKey(arr[i-1]))
        //         mp.put(arr[i-1] ,mp.get(arr[i-1]) + 1);
        // }


        // mp.forEach((key,value)->arr[key-1] = value);
        
        // for( Map.Entry<Integer,Integer> entry : mp.entrySet()){
        //     arr[entry.getKey()-1] = entry.getValue();
        // }
       
       //more optimized
        
         for(int i = 1; i <= N; i++)
            mp.put(arr[i-1],mp.getOrDefault(arr[i-1],0)+1);
        
            
         for(int i = 1; i <= N; i++)
            arr[i-1] = mp.getOrDefault(i,0);
        
    }
}
