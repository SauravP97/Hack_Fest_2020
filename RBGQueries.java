import java.util.*;
import java.io.*;

class RBGQueries {
    public static class Point {
        int a;
        int b;

        Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        FastReader sc1 = new FastReader();
        StringBuilder sb = new StringBuilder();

        int n = sc1.nextInt();
        int q = sc1.nextInt();

        int[][] pts = new int[n][3];

        ArrayList<Point>[] pointsx = new ArrayList[100001];
        ArrayList<Point>[] pointsy = new ArrayList[100001];
        ArrayList<Point>[] pointsz = new ArrayList[100001];

        int[][] pr = new int[100001][3];
        int[][] pb = new int[100001][3];
        int[][] pg = new int[100001][3];

        for (int i = 0; i < 100001; i++) {
            pointsx[i] = new ArrayList<>();
            pointsy[i] = new ArrayList<>();
            pointsz[i] = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                pr[i][j] = 1000000;
            }
            for (int j = 0; j < 3; j++) {
                pb[i][j] = 1000000;
            }
            for (int j = 0; j < 3; j++) {
                pg[i][j] = 1000000;
            }
        }

        for (int i = 0; i < n; i++) {
            pts[i][0] = sc1.nextInt();
            pts[i][1] = sc1.nextInt();
            pts[i][2] = sc1.nextInt();

            pointsx[pts[i][0]].add(new Point(pts[i][1], pts[i][2]));
            pointsy[pts[i][1]].add(new Point(pts[i][0], pts[i][2]));
            pointsz[pts[i][2]].add(new Point(pts[i][0], pts[i][1]));

            int rc = pts[i][0];
            int bc = pts[i][1];
            int gc = pts[i][2];

            pr[rc][0] = rc;
            pr[rc][1] = Math.min(pr[rc][1], bc);
            pr[rc][2] = Math.min(pr[rc][2], gc);

            pb[bc][0] = Math.min(pb[bc][0], rc);
            pb[bc][1] = bc;
            pb[bc][2] = Math.min(pb[bc][2], gc);

            pg[gc][0] = Math.min(pg[gc][0], rc);
            pg[gc][1] = Math.min(pg[gc][1], bc);
            pg[gc][2] = gc;
        }

        int collide = 0;

        for (int i = 0; i < 100001; i++) {
            collide = Math.max(collide, Math.max(pointsx[i].size(), Math.max(pointsy[i].size(), pointsz[i].size())));
        }

        if (collide > 80000) {
            for (int i = 0; i < q; i++) {
                int rc = sc1.nextInt();
                int bc = sc1.nextInt();
                int gc = sc1.nextInt();

                if (pr[rc][1] <= bc && pr[rc][2] <= gc && pb[bc][0] <= rc && pb[bc][2] <= gc && pg[gc][0] <= rc
                        && pg[gc][1] <= bc) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        } else {
            for (int j = 0; j < q; j++) {
                int rc = sc1.nextInt();
                int bc = sc1.nextInt();
                int gc = sc1.nextInt();

                int red = 0;
                int blu = 0;
                int gre = 0;

                for (Point pt : pointsx[rc]) {
                    if (pt.a <= bc && pt.b <= gc) {
                        red = 1;
                        break;
                    }
                }

                for (Point pt : pointsy[bc]) {
                    if (pt.a <= rc && pt.b <= gc) {
                        blu = 1;
                        break;
                    }
                }

                for (Point pt : pointsz[gc]) {
                    if (pt.a <= rc && pt.b <= bc) {
                        gre = 1;
                        break;
                    }
                }

                if (red == 1 && blu == 1 && gre == 1) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
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

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

}