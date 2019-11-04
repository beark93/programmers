/**
 * level2_10
 */
import java.util.*;
public class level2_10 {

    static class CircleArray {
        private byte[] array;
        private int index;

        public CircleArray(byte[] array) {
            this.array = array;
            this.index = 0;
        }

        public byte front(int n) {
            int i=this.index+n;
            if(i >= this.array.length) i -= this.array.length;
            return this.array[i];
        }

        public byte back(int n) {
            int i=this.index-n;
            if(i < 0) i = this.array.length+i;
            return this.array[i];
        }

        public byte now() {
            return this.array[this.index];
        }

        public void change() {
            this.array[this.index] = 0;
        }

        public void setIndex(int index, boolean front) {
            if(front) {
                int newIndex = this.index+index;
                this.index = (newIndex>=this.array.length)?newIndex-this.array.length:newIndex;
            } else {
                int newIndex = this.index-index;
                this.index = (newIndex<0)?this.array.length+newIndex:newIndex;
            }
        }
        
    }
    
    public static int solution(String name) {
        byte[] name_arr = name.getBytes();
        int cnt = name.length();
        int action = 0;

        for(int i=0;i<name_arr.length;i++) {
            if(name_arr[i] == 'N') name_arr[i] = 13;
            else name_arr[i] = (name_arr[i]>'N')?(byte)(13-(name_arr[i]-'N')):(byte)(13-('N'-name_arr[i]));

            if(name_arr[i] == 0) cnt--;
        }

        CircleArray ca = new CircleArray(name_arr);

        while(cnt>0) {
            System.out.println();
            if(ca.now() > 0) {
                action += ca.now();
                ca.change();
                cnt--;
            }

            for(int i=1;i>0;i++) {
                boolean front=true;
                System.out.println(ca.front(i));
                if(ca.front(i)>0 || ca.back(i)>0) {
                    if(!(ca.front(i)>0)) front= false;

                    action += i;
                    ca.setIndex(i,front);
                }
            }

        }

        return action;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }
}