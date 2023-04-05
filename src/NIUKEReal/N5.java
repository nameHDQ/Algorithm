package NIUKEReal;

public class N5 {
    public int circle(long r, int[] point1, int[] point2){

        long distance = (point2[1] - point1[1]) * (point2[1] - point1[1]) + (point2[0] - point1[0]) * (point2[0] - point1[0]);

        if (distance == 0){
            return 0;
        }
        if (distance <= r * r){
            return 1;
        }

        return (int) ((int)distance / (r * r)    + 1);
    }

    public static void main(String[] args) {
        int[] point1 = {8322,1271};//8322  8322 215
        int[] point2 = {8322,215};
        System.out.println(new N5().circle(66, point1, point2));
    }
}
