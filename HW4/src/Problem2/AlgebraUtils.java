package Problem2;

public class AlgebraUtils {

    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        int nA = a.length, mA = a[0].length;
        int nB = b.length, mB = b[0].length;
        if(mA!=nB) {
            System.out.println("ERROR! First matrix's number of columns is not equal to second matrix's number of rows");
            return new double[0][0];
        }
        double[][] matrix = new double[nA][mB];

        for(int i=0; i<nA; i++) {
            for(int j=0; j<mB; j++) {
                for(int l=0; l<mA; l++) {
                    matrix[i][j] += a[i][l]*b[l][j];
                }
            }
        }

        return matrix;
    }
}
