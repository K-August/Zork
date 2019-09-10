import java.util.Scanner;

public class Zork
{
    static class GameConfig
    {
        private int maxX;
        private int maxY;
        private int minX;
        private int minY;

        GameConfig()
        {
            maxX = 3;
            maxY = 3;

            minX = -3;
            minY = -3;
        }
    }
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

    private static GameConfig config = new GameConfig();
    private static PlayerPosition pos = new PlayerPosition();

    private static boolean wantsToPlay = true;


    public static void main(String[] args)
    {
        Puts("Would you like to start the game? y = affirmative");
        Scanner inputHandler = new Scanner(System.in);

        while (wantsToPlay == HandleInput(inputHandler.nextLine()))
        {
            HandleInput((inputHandler.nextLine()));
        }
    }

    // region Position Handler

    private static boolean HandleInput(String input)
    {
        if (input.equalsIgnoreCase("stop")) return false;

        // Updates position and disallows player from going out of bounds
        switch (input)
        {
            case "n":
                if (++pos.y > config.maxY)
                {
                    pos.y = config.maxY;
                    Puts("You can't go further North!");
                    return true;
                }
                break;
            case "s":
                if (--pos.y < config.minY)
                {
                    pos.y = config.minY;
                    Puts("You can't go any further South!");
                    return true;
                }
                break;
            case "e":
                if (++pos.x > config.maxX)
                {
                    pos.x = 2;
                    Puts("You can't go any further East!");
                    return true;
                }
                break;
            case "w":
                if (--pos.x < config.minX)
                {
                    pos.x = config.minX;
                    Puts("You can't go any further West!");
                    return true;
                }
                break;
            case "y":
                Puts("You are now playing the game");
                break;
            default:
                Puts("This command is unknown!");
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
