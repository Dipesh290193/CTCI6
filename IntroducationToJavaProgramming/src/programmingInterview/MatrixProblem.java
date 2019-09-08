package src.programmingInterview;

public class MatrixProblem {
    public static void main(String args[]){
        int[][] input = generateRandomMatrix();
        int[][] output = getMaxMatrix(input);
        System.out.println(output);
    }

    public static int[][] getMaxMatrix(int[][] input){
            int row = input.length;
            int column = input[0].length;
            //Creating 1 plus size matrix for output
            int[][] output = new int[row+1][column+1];
            //Maximum value in the all matrix inputs
            int maximumValue = Integer.MIN_VALUE;
            for(int i=0; i<row;i++){
                //max value in the row
                int maxRow = Integer.MIN_VALUE;
                for(int j = 0; j < column; j++){
                    int value = input[i][j];
                    output[i][j]= value;
                    if(value > maxRow){
                        maxRow=value;
                    }
                    if(value > output[row][j]){
                        //set max value in the column
                        output[row][j] = value;
                    }
                    if(value > maximumValue){
                        maximumValue = value;
                    }
                }
                output[i][column]=maxRow;
            }
            output[row][column]= maximumValue;
            return output;
    }

    public static int[][] generateRandomMatrix(){
        int[][] matrix = new int[5][5];
        for(int i = 0; i< 5; i++){
            for(int j = 0; j< 5 ; j++){
                matrix[i][j] = (int)(Math.random() * 49 + 1);
            }
        }
        return matrix;
    }
}
