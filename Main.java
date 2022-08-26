package gameprogress;

import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        GameProgress progress1 = new GameProgress(100, 100, 0, 0.0);
        GameProgress progress2 = new GameProgress(70, 80, 2, 5.5);
        GameProgress progress3 = new GameProgress(40, 50, 5, 10.2);

        String path1 = progress1.createPath(1);
        String path2 = progress2.createPath(2);
        String path3 = progress3.createPath(3);
        List<String> filePathsList = GameProgress.createPathsList(path1, path2, path3);

        GameProgress.saveGame(path1, progress1);
        GameProgress.saveGame(path2, progress2);
        GameProgress.saveGame(path3, progress3);
        String zipPath = "C:\\Users\\Екатерина\\Documents\\Games\\savegames\\zip.zip";
        GameProgress.zipFiles(zipPath, filePathsList);
    }
    public static void deleteFiles(String path){
        if (!new File(path).delete()) {
            System.out.println("Файл успешно удален");
        }

    }
}
