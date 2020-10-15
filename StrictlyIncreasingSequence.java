import java.util.*;
import java.io.*;

class StrictlyIncreasingSequence {
    
    public static int[] nextArray(FastReader sc1, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc1.nextInt();
        }
        return arr;
    }
    
    public static void main(String[] args) {
        FastReader sc1 = new FastReader();
        StringBuilder sb = new StringBuilder();

        int tc = sc1.nextInt();
        int ch = 0;

        while(ch<tc){
            int n = sc1.nextInt();
            int[] arr = nextArray(sc1, n);
            HashMap<Integer,Integer> fre = new HashMap<>();

            boolean posi = true;

            for(int i=0; i<n-1; i++){
                if(fre.containsKey(arr[i])){
                    int ff = fre.get(arr[i]);
                    fre.put(arr[i],ff+1);
                    posi = false;
                }
                else{
                    fre.put(arr[i], 1);
                }
            }

            if(posi){
                sb.append("First\n");
            }
            else{
                String won = (n%2==0) ? "Second" : "First";
                sb.append(won+"\n");
            }
            ch++;
        }

        System.out.print(sb.toString());
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