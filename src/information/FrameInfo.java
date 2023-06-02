package information;

public class FrameInfo {
    // index                                     0           1           2           3
    private static final int[][] screens = {{1000,750}, {1366,768}, {1440,1080}, {1920,1080}} ;
    private static final String[] backgrounds = {
            "src/assets/background/placeholder_HD.png",
            "src/assets/background/placeholder_HD_Wide.png",
            "src/assets/background/placeholder_FHD.png",
            "src/assets/background/placeholder_FHD_Wide.png"
    };

    private static int userScreenSetting;

    public static String background = backgrounds[userScreenSetting];

    public static int frameWidth = screens[userScreenSetting][0];
    public static int frameHeight = screens[userScreenSetting][1];
    public static int tileSize = getTileSize();
    public static int arenaSize = getArenaSize();

    public static int arenaXstart = frameWidth/2 - arenaSize/2;
    public static int arenaXend = frameWidth/2 + arenaSize/2;
    public static int arenaYstart = frameHeight/2 - arenaSize/2;
    public static int arenaYend = frameHeight/2 + arenaSize/2;

    // setter
    public static void setUserScreenSetting(int preset){
        if (preset>=0 && preset<4){
            FrameInfo.userScreenSetting = preset;
            refresh();
        }
    }

    public static void refresh(){
        background = backgrounds[userScreenSetting];
        frameWidth = screens[userScreenSetting][0];
        frameHeight = screens[userScreenSetting][1];
        tileSize = getTileSize();
        arenaSize = getArenaSize();
        arenaXstart = frameWidth/2 - arenaSize/2;
        arenaXend = frameWidth/2 + arenaSize/2;
        arenaYstart = frameHeight/2 - arenaSize/2;
        arenaYend = frameHeight/2 + arenaSize/2;
    }

    private static int getTileSize(){
        return userScreenSetting > 1? 50 : 50;
    }

    private static int getArenaSize(){
        return userScreenSetting > 1? 800 : 600;
    }

    public static int getUserScreenSetting() {
        return userScreenSetting;
    }
}
