package information;

import java.io.File;

public class FrameInfo {

    // GENERAL INFORMATION

    // index                                     0           1           2           3
    private static final int[][] screens = {{1000,750}, {1366,768}, {1440,1080}, {1920,1080}} ;
    private static final String[] backgrounds = {
            "src/assets/background/placeholder_HD.png",
            "src/assets/background/placeholder_HD_Wide.png",
            "src/assets/background/placeholder_FHD.png",
            "src/assets/background/placeholder_FHD_Wide.png"
    };
    private static final String[] homePageMenus = {
            "src/assets/homePageMenu/HomePageMenu_HD.png",
            "src/assets/homePageMenu/HomePageMenu_HD_Wide.png",
            "src/assets/homePageMenu/HomePageMenu_FHD.png",
            "src/assets/homePageMenu/HomePageMenu_FHD_Wide.png"
    };
    private static final String[] gameEnds = {
            "src/assets/gameEnd/GameEnd_HD.png",
            "src/assets/gameEnd/GameEnd_HD_Wide.png",
            "src/assets/gameEnd/GameEnd_FHD.png",
            "src/assets/gameEnd/GameEnd_FHD_Wide.png"
    };


    public static final File fontFile = new File("src/library/font/Minecraft.ttf");
    public static final String outfitSelection = "src/assets/homePageMenu/OutfitSelection.png";
    public static final String coverPane = "src/assets/homePageMenu/coverPane.png";


    // DERIVATIVE VARIABLE
    private static int userScreenSetting;

    public static String background = backgrounds[userScreenSetting];
    public static String homePageMenu = homePageMenus[userScreenSetting];
    public static String gameEnd = gameEnds[userScreenSetting];

    public static int frameWidth = screens[userScreenSetting][0];
    public static int frameHeight = screens[userScreenSetting][1];
    public static int tileSize = getTileSize();
    public static int arenaSize = getArenaSize();

    public static int arenaXstart = frameWidth/2 - arenaSize/2;
    public static int arenaXend = frameWidth/2 + arenaSize/2;
    public static int arenaYstart = frameHeight/2 - arenaSize/2;
    public static int arenaYend = frameHeight/2 + arenaSize/2;



    // SETTER

    // user screen setting
    public static void setUserScreenSetting(int preset){
        if (preset>=0 && preset<4){
            FrameInfo.userScreenSetting = preset;
            refresh();
        }
    }


    // tile size
    private static int getTileSize(){
        return 50;
    }


    // arena size
    public static int getArenaSize(){
        return 600;
    }


    // user screen setting
    public static int getUserScreenSetting() {
        return userScreenSetting;
    }



    // METHODS

    // refresh
    public static void refresh(){
        background = backgrounds[userScreenSetting];
        homePageMenu = homePageMenus[userScreenSetting];
        gameEnd = gameEnds[userScreenSetting];
        frameWidth = screens[userScreenSetting][0];
        frameHeight = screens[userScreenSetting][1];
        tileSize = getTileSize();
        arenaSize = getArenaSize();
        arenaXstart = frameWidth/2 - arenaSize/2;
        arenaXend = frameWidth/2 + arenaSize/2;
        arenaYstart = frameHeight/2 - arenaSize/2 ;
        arenaYend = frameHeight/2 + arenaSize/2;
    }


}
