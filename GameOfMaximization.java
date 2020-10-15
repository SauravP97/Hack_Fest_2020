import java.util.*;
import java.io.*;

class GameOfMaximization {

    public static void main(String[] args) {
        FastReader sc1 = new FastReader();
        StringBuilder sb = new StringBuilder();

        int n = sc1.nextInt();
        int odd = 0;
        int even = 0;

        for(int i=0; i<n; i++){
            int ele = sc1.nextInt();
            if(i%2!=0){
                odd += ele;
            }
            else{
                even += ele;
            }
        }

        int diff = Math.min(odd,even);
        int res = 2*diff;
        System.out.print(res);
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