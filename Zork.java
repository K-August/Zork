import java.util.Scanner;
import java.util.Random;
import Utilities.Core.*;

public class Zork
{
    private static GameConfig config = new GameConfig();
    private static PlayerData data = new PlayerData();
    private static Random random = new Random();

    public static void main(String[] args)
    {
        System.out.println("Welcome to the game. The controls are N, E, W, and S to move.");

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
                if (++data.y > config.maxY)
                {
                    data.y = config.maxY;
                    HandleCurrentPosition(true);
                    return true;
                }
                break;
            case "s":
                if (--data.y < config.minY)
                {
                    data.y = config.minY;
                    HandleCurrentPosition(true);
                    return true;
                }
                break;
            case "e":
                if (++data.x > config.maxX)
                {
                    data.x = config.maxX;
                    HandleCurrentPosition(true);
                    return true;
                }
                break;
            case "w":
                if (--data.x < config.minX)
                {
                    data.x = config.minX;
                    HandleCurrentPosition(true);;
                    return true;
                }
                break;
            default:
                Puts("This command is unknown!");
                return true;

        }
        HandleCurrentPosition(false);

        return true;
    }

    private static void HandleCurrentPosition(boolean isOOB)
    {
        if (isOOB)
        {
            Puts(config.impassableMessages[random.nextInt(4)]);
            return;
        }

        data.moves++;

        Puts("Your current position is " + data.GetCoord() + ". - Landmark: " + data.GetLandmark(config));
    }

    public static void Puts(String output)
    {
        System.out.print(output + "\n");
    }
    // endregion
}
