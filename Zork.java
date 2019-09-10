import java.util.Scanner;
import java.util.Random;

public class Zork
{
    enum LandMark
    {
        None,
        River,
        Mountain,
        Forest,
        House,
    }

    static class GameConfig
    {
        private int maxX;
        private int maxY;
        private int minX;
        private int minY;

        GameConfig()
        {
            maxX = 4;
            maxY = 4;

            minX = -4;
            minY = -4;
        }

        private String[] impassableMessages =
                {
                        "There are impassable mountains this way...",
                        "There is a deadly river this way...",
                        "This way is blocked by dark magic...",
                        "This path is on fire. You can't go through it..."
                };
    }
    static class PlayerData
    {

        private int moves;

        // Position
        private int x;
        private int y;
        private String position;
        private LandMark playerLandmark;

        PlayerData()
        {
            x = 0;
            y = 0;
            moves = 0;
            playerLandmark = LandMark.None;
        }

        private String UpdateCoord()
        {
            return position = String.format("(%s, %s)", this.x, this.y);
        }
    }

    private static GameConfig config = new GameConfig();
    private static PlayerData data = new PlayerData();
    private static Random random = new Random();


    public static void main(String[] args)
    {
        Puts("Welcome to the game. The controls are N, E, W, and S to move.");

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
                    data.x = 2;
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
        Puts("Your new position is " + data.UpdateCoord());
        HandleCurrentPosition(false);
        
        Puts("Current Landmark: " + data.playerLandmark);

        return true;
    }

    private static void HandleCurrentPosition(boolean isOOB)
    {
        if (isOOB)
        {
            Puts(config.impassableMessages[random.nextInt(4)]);
        }
        data.moves++;

        if (data.x == 0 && data.y == 0)
        {
            data.playerLandmark = LandMark.None;
        }
        switch (data.x)
        {
            case -1:
            case -2:
                switch (data.y)
                {
                    case -1:
                    case -2:
                        data.playerLandmark = LandMark.House;
                        break;
                    case -4:
                        data.playerLandmark = LandMark.River;
                        break;
                }
            case -3:
                switch (data.y)
                {
                    case -4:
                        data.playerLandmark = LandMark.River;
                }
                break;
            case -4:
                switch (data.y)
                {
                    case -4:
                        data.playerLandmark = LandMark.River;
                }
                break;
            case 0:
                switch (data.y)
                {
                    case -4:
                        data.playerLandmark = LandMark.River;
                }
                break;
        }
    }
        // endregion

        private static void Puts (String output){
        System.out.println(output);
    }
}
