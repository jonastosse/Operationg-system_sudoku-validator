package ntnu.no;

public class IsColumnValid extends RowAndColumn implements Runnable {


    IsColumnValid(int row, int column){
        super(row, column);
    }

    @Override
    public void run() {
        if (row != 0 || col > 8){
            System.out.println("Invalid row or column");
            return;
        }

        int i = 0;
        boolean[] arrayToCheck = new boolean[9];
        while(i < 9){
            int number = SudokuValidator.sudoku[col][i];
            if (number < 1 || number > 9 || arrayToCheck[number-1]){
                return;
            } else if (!arrayToCheck[number-1]){
                arrayToCheck[number-1] = true;
            }
            i++;
        }
        SudokuValidator.isValid[18 + row] = true;
    }
}
