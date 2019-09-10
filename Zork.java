import java.util.Scanner;

public class Zork
{
    static class PlayerPosition
    {
        private int x;
        private int y;
        private String position;

        PlayerPosition()
        {
            x = 0;
            y = 0;
        }

        private String UpdateCoord()
        {
            return position = String.format("(%s, %s)", this.x, this.y);
        }
    }

    private static PlayerPosition pos = new PlayerPosition();

    private static boolean wantsToPlay = true;

    private static int[] gameBoard =
            {
                    -2, -1, 0, 1, 2
            };

    public static void main(String[] args)
    {
        Puts("Would you like to start the game? y = affirmative");
        Scanner inputHandler = new Scanner(System.in);

        while (wantsToPlay == HandleInput(inputHandler.nextLine()))
        {
            HandleInput((inputHandler.nextLine()));
        }
    }

    // region Postion Handler

    private static boolean HandleInput(String input)
    {
        if (input.equalsIgnoreCase("stop")) return false;

        // Updates position and disallows player from going out of bounds
        switch (input)
        {
            case "n":
                if (++pos.y > gameBoard[4])
                {
                    pos.y = 2;
                    Puts("You can't go further North!");
                    return true;
                }
                break;
            case "s":
                if (--pos.y < gameBoard[0])
                {
                    pos.y = -2;
                    Puts("You can't go any further South!");
                    return true;
                }
                break;
            case "e":
                if (++pos.x > gameBoard[4])
                {
                    pos.x = 2;
                    Puts("You can't go any further East!");
                    return true;
                }
                break;
            case "w":
                if (++pos.x < gameBoard[0])
                {
                    pos.x = -2;
                    Puts("You can't go any further West!");return true;

                }
                break;
            default:
                Puts("You can't go here!");
                return true;

        }
        Puts("Your new position is " + pos.UpdateCoord());

        return true;
    }

    private static void HandleCurrentPosition()
    {

    }

    // endregion

    private static void Puts(String output)
    {
        System.out.println(output);
    }

}
