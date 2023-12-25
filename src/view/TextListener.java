package view;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import service.EBook;

public class TextListener extends FocusAdapter{
    EBook book = null;
    int n = 0;
    
    public TextListener(EBook book, int n) {
        this.book = book;
        this.n = n;
    }
    
    @Override
    public void focusLost(FocusEvent e) {
        
        String text = "";
        
        if(e.getSource() instanceof JTextField) { // 如果是JTextField
            JTextField textField = (JTextField)e.getSource();
            text = textField.getText();
        } else if(e.getSource() instanceof JTextArea) { // 如果是JTextArea
            JTextArea textArea = (JTextArea)e.getSource();
            text = textArea.getText();
        }
        
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
