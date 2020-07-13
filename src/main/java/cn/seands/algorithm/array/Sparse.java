package cn.seands.algorithm.array;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Queue;


/**
 * 稀疏数组
 */
public class Sparse {

    /**
     * 初始化一个二维数组 随便给几个值
     * @return
     */
    public static int[][] init(){
        int rowNum = 11;
        int colNum = 11;
        int[][] chessArr= new int[rowNum][colNum];
        chessArr[0][3] = 1;
        chessArr[2][5] = 2;
        return chessArr;
    }

    /**
     * 压缩二维数组数据
     * @param arr
     * @return
     */
    public static int[][] arrToSparse(int [][] arr){
        int sum = 0;
        for (int[] row: arr){
            for (int data: row){
                if(data != 0){
                    sum++;
                }
            }
        }
        //if(sum * 3 > arr.length * arr[0].length){
        int rowNum = arr.length;
        int colNum = arr[0].length;
        if(sum * 3 > rowNum * colNum){
            System.out.println("已经如头发一样多，不稀疏了, 没有必要压缩转换");
            return arr;
        }
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = rowNum;
        sparseArr[0][1] = colNum;
        sparseArr[0][2] = sum;
        int count = 1;
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                if(arr[i][j] != 0){
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                    count++;
                }
            }
        }
        return sparseArr;
    }

    /**
     * 解压还原二维数组数据
     * @param sparse
     * @return
     */
    public static int[][] sparseToArr(int [][] sparse){
        int[][] arr = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            // arr[sparse[i][0]][sparse[i][1]] = sparse[i][2];
            int[] row = sparse[i];
            arr[row[0]][row[1]] = row[2];
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        // 初始化二维数组
        int[][] chessArr = init();
        System.out.println("原始二维数组 --------------------");
        printArr(chessArr);
        // 存储二维数组  243个字节  243B
        saveArr(chessArr, "C:/study/arr.txt");
        // 二维数组转稀疏数组
        int[][] sparse = arrToSparse(chessArr);
        System.out.println("压缩后稀疏数组 --------------------");
        printArr(sparse);
        // 存储稀疏数组  21个字节  节省了243B-21B = 222B存储空间 - -
        saveArr(sparse, "C:/study/sparse.txt");
        // 读取稀疏数组
        int[][] sparse2 = readArr("C:/study/sparse.txt");
        System.out.println("文件中读取的稀疏数组 --------------------");
        printArr(sparse2);
        // 还原为二维数组
        int[][] arr2 = sparseToArr(sparse2);
        System.out.println("还原后的二维数组 --------------------");
        printArr(arr2);
    }

    /**
     * 二位数据数据 存储到文件
     * @param arr
     * @param filePath
     * @throws IOException
     */
    public static void saveArr(int[][] arr, String filePath) throws IOException {
        StringBuilder content = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++){
                if(j != arr[i].length - 1){
                    content.append(arr[i][j]).append(",");
                }else{
                    content.append(arr[i][j]);
                }
            }
            if(i != arr.length - 1){
                content.append("\n");
            }
        }
        Files.write(Paths.get(filePath), Collections.singleton(content.toString()), StandardCharsets.UTF_8);
    }

    /**
     * 从文件中读取二维数组
     * @param filePath
     * @return
     * @throws IOException
     */
    public static int[][] readArr(String filePath) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(filePath));
        int colNum = list.get(0).split(",").length;
        int[][] arr = new int[list.size()][colNum];
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] cols = s.split(",");
            for (int j = 0; j < cols.length; j++) {
                arr[i][j] = Integer.parseInt(cols[j]);
            }
        }
        return arr;
    }

    public static void printArr(int[][] arr){
        for (int[] row: arr) {
            for (int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
