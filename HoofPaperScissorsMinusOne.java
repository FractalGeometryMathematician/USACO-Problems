
import java.io.*;
import java.util.*;

public class HoofPaperScissorsMinusOne {
    public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<Integer>[] lose = new HashSet[N];
        for(int i=0; i<N; i++){
            lose[i] = new HashSet<>();
        }

        for(int i=0; i<N; i++){
            String record = r.readLine();
            for(int l=0; l<=i; l++){
                if(record.charAt(l)=='W'){
                    lose[l].add(i);
                }else if(record.charAt(l)=='L'){
                    lose[i].add(l);
                }
            }
            
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(r.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int p = Integer.parseInt(st.nextToken()) - 1;
            HashSet<Integer> same = new HashSet<>(lose[l]);
            same.retainAll(lose[p]);
            if(same.size()<1){
                pw.println(0);
            }else{
                int ans = (same.size()*(N-same.size()))*2 + (same.size()*same.size());
                pw.println(ans);
            }
        }
        /*for(int i=0; i<N; i++){
            pw.println(lose[i].size());
        }
        */
        

		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
}
