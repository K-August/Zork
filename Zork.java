import java.util.Scanner;
import java.util.Random;

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

        private String[] impassableMessages =
        {
                "There are impassable mountains this way...",
                "There is a deadly river this way...",
                "This way is blocked by dark magic...",
                "This path is on fire. You can't go through it..."
        };
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
    private static Random random = new Random();


    public static void main(String[] args)
    {
        Puts("Would you like to start the game? y = affirmative");

        Scanner inputHandler = new Scanner(System.in);

        while (HandleInput(inputHandler.nextLine()))
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
                    HandleCurrentPosition(true);
                    return true;
                }
                break;
            case "s":
                if (--pos.y < config.minY)
                {
                    pos.y = config.minY;
                    HandleCurrentPosition(true);
                    return true;
                }
                break;
            case "e":
                if (++pos.x > config.maxX)
                {
                    pos.x = 2;
                    HandleCurrentPosition(true);
                    return true;
                }
                break;
            case "w":
                if (--pos.x < config.minX)
                {
                    pos.x = config.minX;
                    HandleCurrentPosition(true);;
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

    private static void HandleCurrentPosition(boolean isOOB)
    {
        if (isOOB)
        {
            Puts(config.impassableMessages[random.nextInt(4)]);
        }
    }

    // endregion

    private static void Puts(String output)
    {
        System.out.println(output);
    }

}
