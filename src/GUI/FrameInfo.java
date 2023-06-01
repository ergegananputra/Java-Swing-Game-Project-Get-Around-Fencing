package GUI;

public class FrameInfo {
    private static int userScreenSetting = 1;
    // index                                     0           1           2           3
    private static final int[][] screens = {{1000,750}, {1366,768}, {1440,1080}, {1920,1080}} ;
    private static final String[] backgrounds = {
            "src/assets/placeholder_HD.png",
            "src/assets/placeholder_HD_Wide.png",
            "src/assets/placeholder_FHD.png",
            "src/assets/placeholder_FHD_Wide.png"
    };
    public static String background = backgrounds[userScreenSetting];


    public static int frameWidth = screens[userScreenSetting][0];
    public static int frameHeight = screens[userScreenSetting][1];
    public static int tileSize = userScreenSetting > 1? 40 : 30;
    public static int arenaSize = userScreenSetting > 1? 800 : 600;

    public static int arenaXstart = frameWidth/2 - arenaSize/2;
    public static int arenaXend = frameWidth/2 + arenaSize/2;
    public static int arenaYstart = frameHeight/2 - arenaSize/2;
    public static int arenaYend = frameHeight/2 + arenaSize/2;

    // setter
    public static void setUserScreenSetting(int preset){
        if (preset>=0 && preset<4){
            FrameInfo.userScreenSetting = preset;
        }
    }

}
