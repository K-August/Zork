package Utilities;

public class Core
{
    public enum LandMark
    {
        Path,
        Clearing,
        River,
        Mountain,
        Forest,
        House,
    }

    public static class GameConfig
    {
        public final int maxX;
        public final int maxY;
        public final int minX;
        public final int minY;

        public GameConfig()
        {
            maxX = 3;
            maxY = 3;

            minX = -3;
            minY = -3;
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
        private String position;
        public LandMark playerLandmark;

        public PlayerData()
        {
            x = 0;
            y = 0;
            moves = 0;
            playerLandmark = LandMark.Path;
        }

        public Object GetLandmark(GameConfig config)
        {
            switch (this.x)
            {
                case 3:
                case 2:
                case 1:
                    switch (this.y)
                    {
                        case 3:
                        case 2:
                        case 1:
                            this.playerLandmark = LandMark.Forest;
                            break;
                        case -1:
                        case -2:
                            this.playerLandmark = LandMark.Clearing;
                            break;
                        case -3:
                            this.playerLandmark = LandMark.River;
                            break;
                        default:
                            this.playerLandmark = LandMark.Path;
                    }
                    break;
                case 0:
                    switch (this.y)
                    {
                        case -3:
                            this.playerLandmark = LandMark.River;
                            break;
                        default:
                            this.playerLandmark = LandMark.Path;
                    }
                    break;
                case -1:
                case -2:
                case -3:
                    switch (this.y)
                    {
                        case 3:
                        case 2:
                        case 1:
                            this.playerLandmark = LandMark.Mountain;
                            break;
                        case -1:
                        case -2:
                            this.playerLandmark = LandMark.House;
                            break;
                        case -3:
                            this.playerLandmark = LandMark.River;
                            break;
                        default:
                            this.playerLandmark = LandMark.Path;
                    }
                    break;
                default:
                    System.out.println("This should never print, but one day it will.");
            }
            return this.playerLandmark;
        }


        public String GetCoord()
        {
            return position = String.format("(%s, %s)", this.x, this.y);
        }
    }
}
