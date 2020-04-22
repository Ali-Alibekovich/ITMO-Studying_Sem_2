import ReadPrint.Matrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Считывание матрицы
        Scanner sc = null;
        {
            try {
                sc = new Scanner(new File("resources/matrix.txt"));
            } catch (FileNotFoundException e) {
                System.err.print("Ошибка данных");
            }
        }
        int[][] matrixR = new int[4][4];
        int[][] matrixD = {{0,1,2,3},{1,0,1,2},{2,1,0,1},{3,2,1,0}};
        Matrix matrix = new Matrix();
        matrix.matrixReader(sc ,matrixR);
        matrix.printMatrix(matrixR);
        matrix.printMatrix(matrixD);
        //Конец считывания


    }
}
