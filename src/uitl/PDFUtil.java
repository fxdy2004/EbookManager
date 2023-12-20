package uitl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.rendering.PDFRenderer;

import service.EBook;

public class PDFUtil {
	public static EBook PDFLoad(File file,EBook.BookType bookType) throws Exception {
		String NULL = null;
		String nameString = file.getName().substring(0, file.getName().lastIndexOf("."));
		String authorString = "null";
		EBook book = null;
		PDDocument document = Loader.loadPDF(file);
		PDFRenderer renderer = new PDFRenderer(document);
		BufferedImage coverImage = renderer.renderImage(0);
		PDDocumentCatalog catalog = document.getDocumentCatalog();
		PDMetadata metadata = catalog.getMetadata();
		COSDictionary info = null;
		if (metadata!=null) {
			info = metadata.getCOSObject();
		}
		if (info!=null) {
			if(info.getString(COSName.TITLE)!=null) {
				nameString = info.getString(COSName.TITLE);
			}
			if(info.getString(COSName.AUTHOR)!=null) {
				authorString = info.getString(COSName.AUTHOR);
			}
		}
				
		book = new EBook(nameString, authorString, bookType);
		ImageIO.write(coverImage, "JPEG", new File("images/"+book.getBookName()+".jpg"));
		book.setCoverImageIcon(new ImageIcon("images/"+book.getBookName()+".jpg"));
		book.setPublicationDate(null);
		book.setPress(new String("null"));
		book.setIsbn(new String("null"));
		book.setDescription(new String("null"));
		book.setSubmissionDate(null);
		book.setSubmissionUserId(0);
		book.setFilePath(file.getPath());
		
		return book;
	}
}
