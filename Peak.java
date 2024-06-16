import java.util.Scanner;

public class Peak {
    public static int [][] readArray(Scanner sc, int rows , int cols) {
        System.out.println("Enter array element of ("+rows+","+cols+")");
        int matrix [][] = new int[rows][cols];
        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < cols; j ++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void displayMatrix (int array[][]) {
        System.out.println("Matrix ");
        for( int arr[] : array){
            for(int element : arr){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
    public static int checkPeakC (int arr[][], int r , int l) {
        int maximumRow = 0;
        int minimumCol = Integer.MAX_VALUE;
        for(int i = 0; i < r ; i++){
            if( arr[i][0] > maximumRow) {
                maximumRow = arr[i][0];
            }
        }
        for(int j = 0; j< l; j++) {
               
            if(arr[0][j] < minimumCol ) {
                minimumCol = arr[0][j];
            }
        }

        System.out.println("maximum in rows is: "+maximumRow);
        System.out.println("minimumu in columns is: "+minimumCol);
        if(maximumRow == minimumCol) {
            System.out.println("Peak column is: "+minimumCol);
        }else{
            System.out.println("There is no peak column in array");
        }
        return maximumRow;
    }

    public static void main(String[] args) {
        System.out.println("Enter rows");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();

        System.out.println("Enter cols");
        int cols = scanner.nextInt();

        int arr [][] = readArray(scanner, rows, cols);
        displayMatrix(arr);
        checkPeakC(arr, rows, cols);
        scanner.close();
    }
}
