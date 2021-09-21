import java.util.Scanner;

public class Game
{
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;
    int Turns;

    public void start()
    {
        player1 = new Player('X');
        currentPlayer = player1;
        player2 = new Player('O');
        board = new Board();
        Scanner scanner = new Scanner(System.in);
        board.printBoard();
        Turns = 0;

        while(getWinner() == null)
        {
            if(isBoardFull())
            {
                System.out.println("It's a tie.");
                start();
                break;
            }

            System.out.println("Player " + currentPlayer.getSymbol() + " Turn");
            System.out.println("Where do you wanna place your mark?");

            int position = Integer.parseInt(scanner.nextLine());

            while(!checkPosition(position))
            {
                System.out.println("Position taken!");
                position = Integer.parseInt(scanner.nextLine());
            }

            board.placeSymbol(currentPlayer.getSymbol(), position);

            Turns++;

            if (currentPlayer == player1) currentPlayer = player2;
            else currentPlayer = player1;

            board.printBoard();
        }
        System.out.println("Congrats - you won! : " + getWinner());
        start();
    }

    /*public void restart(){
        start();
    }

    public boolean stop(){
        System.out.println("Thank you for playing!");
        return true;
    }*/

    private Character getWinner()
    {
        char[] field = board.getField();
        if (getWinnerHorizontal(field, player1)) return player1.getSymbol();
        if (getWinnerHorizontal(field, player2)) return player2.getSymbol();
        if (getWinnerVertical(field, player1)) return player1.getSymbol();
        if (getWinnerVertical(field, player2)) return player2.getSymbol();
        if(getWinnerDiagonal(field, player1)) return player1.getSymbol();
        if(getWinnerDiagonal(field, player2)) return player2.getSymbol();
        return null;
    }

    private boolean getWinnerDiagonal(char[] field, Player player)
    {
        return (field[0] == player.getSymbol() && field[4] == player.getSymbol() && field[8] == player.getSymbol()) ||
                (field[2] == player.getSymbol() && field[4] == player.getSymbol() && field[6] == player.getSymbol());
    }

    private boolean getWinnerHorizontal(char[] field, Player player)
    {
        return (field[0] == player.getSymbol() && field[1] == player.getSymbol() && field[2] == player.getSymbol()) ||
                (field[3] == player.getSymbol() && field[4] == player.getSymbol() && field[5] == player.getSymbol()) ||
                (field[6] == player.getSymbol() && field[7] == player.getSymbol() && field[8] == player.getSymbol());
    }

    private boolean getWinnerVertical(char[] field, Player player)
    {
        return (field[0] == player.getSymbol() && field[3] == player.getSymbol() && field[6] == player.getSymbol()) ||
                (field[1] == player.getSymbol() && field[4] == player.getSymbol() && field[7] == player.getSymbol()) ||
                (field[2] == player.getSymbol() && field[5] == player.getSymbol() && field[8] == player.getSymbol());
    }

    private boolean checkPosition(int position)
    {
        char[] field = board.getField();

        return field[position] != player1.getSymbol() && field[position] != player2.getSymbol();
    }

    private boolean isBoardFull()
    {
        char[] field = board.getField();
        return Turns == field.length;
    }
}
