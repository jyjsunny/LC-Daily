package stack;

import java.util.Arrays;
import java.util.HashMap;

public class Good1_768_maxChunksToSorted {
    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        System.out.println("hello!! ");
        int[] arr = new int[]{2,1,3,3,4};
        //String s = "3[a]2[bc]";
        maxChunksToSorted(arr);
        System.out.println("finish!! ");
        
        //sc.close(); 
    }

    /*
        需求分析：
        arr分块、排序、连接 == Arrays.sort(arr)
        问能将数组分成的最多块数
    */
    public static int maxChunksToSorted(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        int res = 0;
        //方法一：排序+哈希表
        int[] A = new int[len];
        System.arraycopy(arr, 0, A, 0, len);//copy from arr[] to A[]

        Arrays.sort(arr);
        for(int i=0;i<len;i++){
            if(map.containsKey(arr[i])){
                int count = map.get(arr[i]);
                count++;
                map.put(arr[i],count);
            }
            else
                map.put(arr[i],1);
            if(map.get(arr[i])==0)
                map.remove(arr[i]);

            if(map.containsKey(A[i])){
                int count = map.get(A[i]);
                count--;
                map.put(A[i],count);
            }
            else
                map.put(A[i],-1);
            if(map.get(A[i])==0)
                map.remove(A[i]);
            
            if(map.isEmpty())   res++;
            
        }
        return res;
    }
}
