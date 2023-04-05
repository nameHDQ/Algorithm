package NIUKEReal;

public class N2 {

    static String res = "222222222222222222222222222222222222";
    public static void dfs(int N, int cur, String str){
        if (cur > N){
            return ;
        }
        if(cur == N){
            if (str.length() <= res.length()){
                res = str;
            }
            return ;
        }
        dfs(N, cur * 2 + 1, str + "2");
        dfs(N, cur * 2 + 2, str + "3");
    }

    public static void main(String[] args) {
        dfs(10,0,"");

        int N = 10;
        String res = "";
        while (N > 0 ){
            if ( N % 2 == 0){
                N = (N - 2) / 2;
                res = "3" + res;
            }else {
                N = (N - 2) / 2;
                res = "2" + res;
            }
        }
        System.out.println(res);
    }
}
