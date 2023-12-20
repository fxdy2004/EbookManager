package view;

import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import service.EBook;

public class TextListener extends FocusAdapter{
	EBook book = null;
	String text = null;
	int n = 0;
	public TextListener(EBook book,String text,int n) {
		this.book = book;
		this.text = text;
		this.n = n;
	}
    @Override
    public void focusLost(FocusEvent e) {
        switch (n) {
		case 1:
			book.setBookName(text);
			break;
		case 2:
			book.setAuthor(text);
			break;
		case 3:{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(text, formatter);
			book.setPublicationDate(localDate);
			break;
		}
		case 4:
			book.setPress(text);
			break;
		case 5:
			book.setIsbn(text);
			break;
		case 6:
			book.setDescription(text);
			break;
		default:
			break;
		}
    }
}
