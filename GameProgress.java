package gameprogress;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public static void saveGame(String path, GameProgress progress) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(progress);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void zipFiles(String zipPath, List<String> filePaths) throws IOException {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (String filePath : filePaths) {
                try (FileInputStream fis = new FileInputStream(filePath)) {
                    ZipEntry entry = new ZipEntry(filePath);
                    zos.putNextEntry(entry);
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    zos.write(bytes);
                    zos.closeEntry();
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String createPath(int i) {
        return "C:\\Users\\Екатерина\\Documents\\Games\\savegames\\save" + i + ".dat";
    }

    public static List<String> createPathsList(String... filePath) {
        List<String> paths = new ArrayList<>();
        for (int i = 0; i < filePath.length; i++) {
            paths.add(filePath[i]);
        }
        return paths;
    }

}
