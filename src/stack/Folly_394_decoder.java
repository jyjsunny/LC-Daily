package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Folly_394_decoder {
    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        System.out.println("hello ");
        String s = "2[abc]3[cd]ef";
        //String s = "3[a]2[bc]";
        decoder(s);
       
        //sc.close(); 
    }
    public static String decoder(String s){

        Deque<Integer> numStack  = new ArrayDeque<>();//??
        Deque<Character> charStack = new ArrayDeque<>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(isNumber(c)){//k计算
                int num = c-'0';
                while((i<(len-1))&&isNumber(s.charAt(i+1))){
                    c=s.charAt(i+1);
                    num*=10;
                    num+=c-'0';
                    i++;
                }
                numStack.push(num);
            }
            else{
                if(c!=']')
                    charStack.push(c);
                else{
                    int k = numStack.pollFirst();
                    List<Character> tmp = new ArrayList<>();
                    while(charStack.peek()!='['){
                        char cc = charStack.pollFirst();
                       tmp.add(cc); 
                    }
                    //System.out.println(charStack.peek());
                    charStack.pop();
                    for(int j=0;j<k;j++){
                        
                        for(int p = tmp.size()-1;p>=0;p--){
                            //System.out.print(tmp.get(p));
                            charStack.push(tmp.get(p));
                        }
                    }
                    
                    
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!charStack.isEmpty()){
            sb.append(charStack.pollLast());
        }
        System.out.println(sb.toString());

        return sb.toString();
    }
    public static boolean isNumber(char c){
        return ((c-'0')>=0 && (c-'0')<=9)?true:false;
    }
}
