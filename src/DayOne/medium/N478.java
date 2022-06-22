package DayOne.medium;

import java.util.Random;

/**
 * @author hdq
 * @create 2022-06-05 21:08
 */
public class N478 {
    class Solution {
        private double R;
        private double x;
        private double y;
        Random random;

        public Solution(double radius, double x_center, double y_center) {
            this.R = radius;
            this.x = x_center;
            this.y = y_center;
            this.random = new Random();
        }

        public double[] randPoint() {
            while (true){
                double tempX = this.random.nextDouble() * 2 * this.R - this.R;
                double tempY = this.random.nextDouble() * 2 * this.R - this.R;

                if (tempX * tempX + tempY * tempY <= this.R * this.R){
                    return new double[]{tempX + this.x, tempY + this.y};
                }
            }
        }
    }
}
