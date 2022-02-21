package ntnu.no;

public class IsRowValid extends RowAndColumn implements Runnable {


    IsRowValid(int row, int column){
        super(row, column);
    }

    @Override
    public void run() {
        if (col != 0 || row > 8){
            System.out.println("Invalid row or column");
            return;
        }

        int i = 0;
        boolean[] arrayToCheck = new boolean[9];
        while(i < 9){
            int number = SudokuValidator.sudoku[row][i];
            if (number < 1 || number > 9 || arrayToCheck[number-1]){
                return;
            } else if (!arrayToCheck[number-1]){
                arrayToCheck[number-1] = true;
            }
            i++;
        }
        SudokuValidator.isValid[9 + row] = true;
    }
}