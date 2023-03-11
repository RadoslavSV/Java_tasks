import Problem2.AlgebraUtils;

public class AlgebraUtilsTest {
    public static void main(String[] args) {
        AlgebraUtils au = new AlgebraUtils();
        double[][] mat1 = {{3, 2}, {1, 0}, {7, 1}, {9, 3}};
        double[][] mat2 = {{6, 1, 8}, {0, 2, 3}};
//        double[][] mat1 = { {1,2,3}, {4,5,6}, {7,8,9}};
//        double[][] mat2 = { {0,2,4}, {1,4.5,2.2}, {1.1,4.3,5.2}};

        double[][] res = au.multiplyMatrix(mat1, mat2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}