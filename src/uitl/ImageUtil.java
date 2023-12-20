package uitl;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageUtil {
	public static ImageIcon resizeImage(ImageIcon imageIcon,int width,int height) {
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
