public class Life {
    public static final int  ROWS =20;
    public static final int  COLS =80;
    public static final int  TIME_DELAY =500;

private static void clearCosole(){
    System.out.println("\033[H\033[2J");
    System.out.flush();
}
    public static void initializeBoard(Board b)
    {
        for (int r = 0; r < ROWS; r++){
            for ( int c = 0; c < COLS; c++){
                int randVal = (int)(Math.random() * 3); // Random Number 0,1,2
                if(randVal == 0) {                       //1/3 chance having a live cell
                    b.set(r,c,1);
                }
            }
        }
    }

    public static void displayBoard(Board board)
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0 ; c < COLS; c++)
            {
                if (board.get(r,c)==0)
                {
                    System.out.print(".");
                }
                else
                {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }


    public static void calculateNextGeneration(Board b,Board nextB) {
        for (int r = 0 ; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                int neighborCount = countNeighbors(r,c,b);
               if (b.get(r,c)==1 && neighborCount < 2){
                   nextB.set(r,c,0);
               }
               else if (b.get(r,c)==1 && neighborCount < 4){
                    nextB.set(r,c,1);
               }
               else if (b.get(r,c) == 1 && neighborCount > 3){
                   nextB.set(r,c,0);
               }
               else if (b.get(r,c) == 0 && neighborCount == 3){
                   nextB.set(r,c,1);
               }
               else{
                   nextB.set(r,c,0);
               }
            }
        }
    }

    public static int countNeighbors(int row,int col,Board b)
    {
        int count = 0;
        for (int r = row - 1; r <= row + 1;r++){
            for (int c = col - 1; c <= col+1; c++){
                if (r >= 0 && r < ROWS &&
                        c >= 0 && c < COLS &&
                            !(r == row && c == col)&&
                                b.get(r,c) == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public static void transferNextToCurrent(Board board,Board nextBoard)
    {
        for (int r = 0 ; r < ROWS ; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                board.set(r,c,nextBoard.get(r,c));
            }
        }
    }


    public static void main(String[] args) {

        Board board = new Board(ROWS,COLS);
        Board nextBoard = new Board(ROWS,COLS);
        initializeBoard(board);
        for (int i = 0; i < 100; i++){
            clearCosole();
            displayBoard(board);
            calculateNextGeneration(board,nextBoard);
            initializeBoard(board);
            transferNextToCurrent(board,nextBoard);
        }
    }


}