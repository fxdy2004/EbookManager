package uitl;
import java.io.*;

public class FilePersistenceUtil {
    public static void saveFilePath(String selectedPath) {
        FilePath filePath = new FilePath();
        filePath.setPath(selectedPath);

        try {
            FileOutputStream fileOut = new FileOutputStream("filepath.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(filePath);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSavedFilePath() {
        FilePath filePath;
        try {
            FileInputStream fileIn = new FileInputStream("filepath.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            filePath = (FilePath) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return filePath.getPath();
    }

    private static class FilePath implements Serializable {
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
