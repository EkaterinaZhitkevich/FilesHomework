package gameprogress;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        GameProgress progress1 = new GameProgress(100, 100, 0, 0.0);
        GameProgress progress2 = new GameProgress(70, 80, 2, 5.5);
        GameProgress progress3 = new GameProgress(40, 50, 5, 10.2);
        String path1 = "C:\\Users\\Екатерина\\Documents\\Games\\savegames";
//        String pathtemp = "gameprogress";

        GameProgress.saveGame(path1, progress1);
        GameProgress.saveGame(path1, progress2);
        GameProgress.saveGame(path1, progress3);




    }
    public static List<String> createPaths(String... filePath){
        List<String> paths = new ArrayList<>();
        for (int i = 0; i < filePath.length; i++) {
            paths.add(filePath[i]);
        }
        return paths;
}
}
