public class Board
{
    private final char[] field;

    public Board()
    {
    field = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
    }

    public char[] getField()
    {
        return field;
    }

    public void printBoard()
    {
        System.out.println(field[0] + " | " + field[1] + " | " + field[2]);
        System.out.println("---------");
        System.out.println(field[3] + " | " + field[4] + " | " + field[5]);
        System.out.println("---------");
        System.out.println(field[6] + " | " + field[7] + " | " + field[8]);

    }

    public void placeSymbol(char symbol, int position)
    {
        field[position] = symbol;
    }


}
