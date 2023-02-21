package stack;

import java.util.LinkedList;

public class Better_394_decoder {
    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        System.out.println("hello!! ");
        String s = "2[abc]3[cd]ef";
        //String s = "3[a]2[bc]";
        betterDecoder(s);
        System.out.println("finish!! ");
        
        //sc.close(); 
    }
    public static String betterDecoder(String s){
        StringBuilder res = new StringBuilder();
        int multi =0;//避免连续两个char都表示数字
        LinkedList<Integer> stack_multi =  new LinkedList<>();//??为什么栈用linkedlist
        LinkedList<String> stack_res = new LinkedList<>();
        for(char c:s.toCharArray()){//！string 读取单个char
            if(c=='['){
                stack_multi.add(multi);
                stack_res.add(res.toString());
                multi=0;
                res = new StringBuilder();
            }
            else if(c==']'){
                int cur_multi = stack_multi.removeLast();
                StringBuilder tmp_res = new StringBuilder();
                for(int i=0;i<cur_multi;i++){
                    tmp_res.append(res);
                }
                res = new StringBuilder(stack_res.removeLast()+tmp_res.toString());
            }
            else if(c>='0'&&c<='9'){
                multi*=10;
                multi+=Integer.parseInt(c+"");//!string 转 int
            }
            else{
                res.append(c);
            }
        }
        System.out.println(res);

        return res.toString();
        
    }
}
