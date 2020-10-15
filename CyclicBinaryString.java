import java.util.*;
import java.io.*;

class CyclicBinaryString {

    public static void main(String[] args) {
        FastReader sc1 = new FastReader();
        //StringBuilder sb = new StringBuilder();

        String str = sc1.nextLine();
        int mcount = 0;
        int count = 0;

        int lcount = 0;
        int rcount = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='0'){
                count++;
            }
            else{
                count = 0;
            }
            mcount = Math.max(count, mcount);
        }

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1'){
                break;
            }
            lcount++;
        }

        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i)=='1'){
                break;
            }
            rcount++;
        }

        mcount = Math.max(lcount+rcount, mcount);

        if(mcount >= str.length()){
            mcount = -1;
        }
        
        System.out.print(mcount);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}