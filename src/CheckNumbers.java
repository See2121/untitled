public class CheckNumbers {
    public static void main(String[] args) {

        int[][] matrixe = {
                {3, 3, 3},
                {4, 6, 2},
                {3, 3, 4}
        };
        int min = matrixe[0][0];
        int max = matrixe[0][0];
        double average;
        double count = 0;
        double sum = 0;
        for (int i = 0; i < matrixe.length; i++) {
            for (int j = 0; j < matrixe[i].length; j++) {
                sum += matrixe[i][j];
                count++;
                if (matrixe[i][j] < min) min = matrixe[i][j];
                if (matrixe[i][j] > max) max = matrixe[i][j];
                System.out.print(matrixe[i][j] + " ");
            }
            System.out.println();
        }
        average = sum / count;
        System.out.println("min :" + min);
        System.out.println("max :" + max);
        System.out.println("average :" + average);
    }
}



