package stack;

import java.util.ArrayDeque;

import java.util.Deque;

public class Good2_768_maxChunksToSorted {
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
        //方法二：单调栈
        Deque<Integer> stack = new ArrayDeque<>();//用于保存每个chunk中最大的数，一个chunk中只保留一个

        //int res = 0;
        for(int num: arr){
            if(stack.isEmpty()||stack.peek()<=num)//chunk++
                stack.push(num);
            else{
                int max = stack.poll();//提取代表的chunk
                while(!stack.isEmpty()&&stack.peek()>num){//pop出来要被合并到max的chunk中的元素
                    stack.pop();
                }
                stack.push(max);//再次压入chunk：max
            }
        }
        return stack.size();
        
    }
}
