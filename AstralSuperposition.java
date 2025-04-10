import java.util.*;

public class AstralSuperposition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<T; i++){
            int N = scan.nextInt();
            int A = scan.nextInt();
            int B = scan.nextInt();
            int[][] photo = new int[N][N];
            int[][] original = new int[N][N];
            int[][] late = new int[N][N];
            scan.nextLine();
            int count = 0;
            for(int n=0; n<N; n++){
                String hi = scan.nextLine();
                for(int d=0; d<N; d++){
                    //5 = white (empty) 1 = gray (1 photo) 2 = black (both)
                    // in 
                    if(hi.charAt(d)=='W'){
                        photo[n][d] = 5;
                        original[n][d] = 5;
                        late[n][n]=5;
                    }else if(hi.charAt(d)=='G'){
                        photo[n][d] =1;
                    }else{
                        photo[n][d] =2;
                        original[n][d] = 1;
                        if(n-B<0||d-A<0||original[n-B][d-A]==5){
                            count = -1;
                        }else{
                        original[n-B][d-A] = 1;
                        }
                        late[n][d]=1;
                    }
                }
            }
            
            for(int n=0; n<N; n++){
                for(int d=0; d<N; d++){
                    if(photo[n][d]==1){
                        if(n-B<0||d-A<0){
                            original[n][d]=1;
                        }else if(original[n-B][d-A]==1){
                            late[n][d]=1;
                        }else{
                            original[n][d]=1;
                        }
                    }
                }
            }

            
            if(count>-1){
            for(int n=0; n<N; n++){
                for(int d=0; d<N; d++){
                    if(original[n][d]==1){
                        count++;
                    }
                }
            }

            for(int n=0; n<N; n++){
                for(int d=0; d<N; d++){
                    if(late[n][d]==1){
                        if(original[n-B][d-A]==0){
                            count = -1;
                            break;
                        }
                    }
                }
            }
            }
            


            System.out.println(count);




        }
	}
}
