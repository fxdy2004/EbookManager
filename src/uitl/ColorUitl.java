package uitl;

import java.awt.*;
import java.io.*;

public class ColorUitl {
    public static void saveSelectedColor(Color color) {
        // 将选中的颜色转换为16进制字符串，并保存到文件中
        String hexColor = "#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase();

        try (FileWriter fileWriter = new FileWriter("selectedColor.txt")) {
            fileWriter.write(hexColor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Color getSavedColor() {
        try (BufferedReader reader = new BufferedReader(new FileReader("selectedColor.txt"))) {
            String hexColor = reader.readLine();
            return Color.decode(hexColor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
