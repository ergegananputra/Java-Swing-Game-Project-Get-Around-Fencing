package testing;

import information.FrameInfo;

public class TestingFacilities {
    public static void main(String[] args) {
        System.out.println("Frame Width : "+FrameInfo.frameWidth);
        System.out.println("Frame Height : "+FrameInfo.frameHeight);
        System.out.println("Arena Size : "+FrameInfo.arenaSize);

        System.out.println("Arena X Start : "+FrameInfo.arenaXstart);
        System.out.println("Arena X End : "+FrameInfo.arenaXend);
        System.out.println("Arena Y Start : "+FrameInfo.arenaYstart);
        System.out.println("Arena Y End : "+FrameInfo.arenaYend);
    }
}
