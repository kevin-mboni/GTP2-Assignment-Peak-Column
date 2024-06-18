import java.util.Scanner;

public class Peak {

    //Method to read user input
    public static int[][] readArray(Scanner sc, int rows, int cols) {
        System.out.println("Enter array elements of (" + rows + "," + cols + "):");
        int matrix[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Function to display the matrix
    public static void displayMatrix(int array[][]) {
        System.out.println("Matrix A:");
        for (int arr[] : array) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Function to find and display peak-columns
    public static void findPeakColumns(int arr[][], int rows, int cols) {
        boolean peakFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean isPeak = true;
                for (int k = 0; k < cols; k++) {
                    if (arr[i][k] > arr[i][j]) {
                        isPeak = false;
                        break;
                    }
                }
                if (isPeak) {
                    for (int k = 0; k < rows; k++) {
                        if (arr[k][j] < arr[i][j]) {
                            isPeak = false;
                            break;
                        }
                    }
                }
                // If arr[i][j] is a peak-column element, print it
                if (isPeak) {
                    System.out.println("(" + (i+1) + "," + (j+1) + ") = " + arr[i][j]);
                    peakFound = true;
                }
            }
        }
        if (!peakFound) {
            System.out.println("There are no peak columns in the array.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of rows:");
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();

        System.out.println("Enter number of columns:");
        int cols = scanner.nextInt();

        int arr[][] = readArray(scanner, rows, cols);
        displayMatrix(arr);
        findPeakColumns(arr, rows, cols);
        scanner.close();
    }
}
