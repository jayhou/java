import jayhou.work.pathmatchsimulator.TrailMatchSimulator;
import jayhou.work.stringconvertion.Words2Utf8Encoding;

import java.io.UnsupportedEncodingException;

public class AnyDemo {



    public static void main(String[] args) {
        String[] string = {"上公里用时","总距离","海拔","距离","公里"};
        short[][] coding = Words2Utf8Encoding.String2UTF_8_Encoding_uint16_Arrays(string);
        Words2Utf8Encoding.printShortAsHex4d(coding);
        String gpxFilePath = "";
        String runningDataFile = "";
        TrailMatchSimulator mSimulator = new TrailMatchSimulator(gpxFilePath, runningDataFile);
        mSimulator.start();
    }
}
