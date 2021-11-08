public class Board
{
    int[][] b;


    public Board(int rows, int cols)
    {
        b = new int[rows][cols];
    }

    public int get(int row, int col)
    {
            return b[row][col];
    }

    public void set(int row, int col, int value)
    {
        b[row][col] = value;
    }

    public int getRows()
    {
        return b.length;
    }

    public int getCols()
    {
        return b[0].length;
    }

    public String toString()
    {
        String result = " ";
        for (int r = 0; r < getRows(); r++)
        {
            for (int c = 0; c < getCols(); c++)
            {
                result +=String.valueOf(b[r][c]);
            }
            result+= "\n";
        }
        return result;
    }
}