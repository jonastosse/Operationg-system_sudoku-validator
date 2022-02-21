package ntnu.no;

public class Is3x3Valid extends RowAndColumn implements Runnable{

    public Is3x3Valid(int row, int column){
        super(row, column);
    }

    @Override
    public void run() {
        if(row > 6 || row%3 != 0 || col > 6 || col%3 != 0){
            System.out.println("Invalid row or cloumn");
        }

        int i = row;
        boolean[] arrayToCheck = new boolean[9];
        while(i < row + 3){
            int j = col;
            while(j < col +3){
                int number = SudokuValidator.sudoku[i][j];
                if(number < 1 || number > 9 || arrayToCheck[number-1]){
                    return;
                } else {
                    arrayToCheck[number-1] = true;
                }
                j++;
            }
            i++;
        }
        SudokuValidator.isValid[row + col/3] = true;
    }
}
