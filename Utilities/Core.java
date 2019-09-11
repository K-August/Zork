package Utilities;

public class Core
{
    public enum LandMark
    {
        None,
        River,
        Mountain,
        Forest,
        House,
    }

    public static class GameConfig
    {
        public int maxX;
        public int maxY;
        public int minX;
        public int minY;

        public GameConfig()
        {
            maxX = 4;
            maxY = 4;

            minX = -4;
            minY = -4;
        }

        public String[] impassableMessages =
                {
                        "There are impassable mountains this way...",
                        "There is a deadly river this way...",
                        "This way is blocked by dark magic...",
                        "This path is on fire. You can't go through it..."
                };
    }

    public static class PlayerData
    {

        public int moves;

        // Position
        public int x;
        public int y;
        public String position;
        public LandMark playerLandmark;

        public PlayerData()
        {
            x = 0;
            y = 0;
            moves = 0;
            playerLandmark = LandMark.None;
        }

        public String UpdateCoord()
        {
            return position = String.format("(%s, %s)", this.x, this.y);
        }
    }
}



