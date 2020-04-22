package ReadPrint;

import javafx.scene.shape.Path;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Matrix implements IMatrix{
    @Override
    public void matrixReader(Scanner sc, int [][] matrixR){
        try {
        for (int i = 0; i<4; i++){
            for (int j = 0; j<4; j++){
                matrixR[i][j]=sc.nextInt();
            }
        }
        }catch (NoSuchElementException ex){
            System.err.println("Файл пуст. Создана пустая матрица");
        }
    }

    @Override
    public void printMatrix(int [][] matrix){
        int k=matrix.length;
        System.out.println("Matrix=");
        while (k!=0){
            System.out.print("-----");
            k--;
        }
        System.out.println("-");
        for (int i = 0; i<matrix.length;i++){
            System.out.print("|");
            for (int j=0; j<matrix[i].length ;j++){
                System.out.printf("%3d |",matrix[i][j]);
            }
            System.out.println();
            for (int f=0; f<matrix[1].length;f++) {
                System.out.print("-----");
            }
            System.out.print("-");
            System.out.println();
        }
    }

}
