package jayhou.work.pathmatchsimulator;

import jayhou.work.Log;

public class TrailMatchSimulator {
    private final String TAG = "TrailMatchSimulator";
    String gpxFilePath;
    String runningDataPath;
    public TrailMatchSimulator(String gpxFile, String runningData) {
        gpxFilePath = gpxFile;
        runningDataPath = runningData;
        Log.d(TAG, "GPX file:" + gpxFile);
        Log.d(TAG, "Running data:" + runningData);
    }

    public void start() {

    }
}
