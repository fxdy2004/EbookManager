package service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.ImageIcon;

public class EBook {
    private int bookId;
    private String bookName;
    private String author;
    private LocalDate publicationDate;
    private String press;
    private String isbn;
    private BookType type;
    private String description;
    private int submissionUserId;
    private LocalDateTime submissionDate;
    private ImageIcon coverImageIcon;
    private Path filePath;
    
    public EBook(String bookName,String author,BookType type) {
    	setBookName(bookName);
    	setAuthor(author);
    	setType(type);
    }
    
    public enum BookType {
        LITERATURE_AND_FICTION("A0"),
        FINE_ARTS("B0"),
        PROGRAMMING_LANGUAGE("C0"),
        DATA_STRUCTURES_AND_ALGORITHMS("C1"),
        COMPUTER_HARDWARE("C2"),
        DATABASE("C3"),
        GAME("C4"),
        COMPUTER_PRACTICAL_TECHNIQUES("C5"),
    	OTHER("Z0");
        private final String code;
        BookType(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
        public static BookType getCategoryByCode(String code) {
            for (BookType category : values()) {
                if (category.getCode().equals(code)) {
                    return category;
                }
            }
            return null; // 或者抛出异常，表示无效的分类代码
        }
    }
    public int getBookId() {
		return bookId;
	}
    public String getBookName() {
		return bookName;
	}
    public String getAuthor() {
		return author;
	}
    public String getPress() {
		return press;
	}
    public LocalDate getPublicationDate() {
		return publicationDate;
	}
    public String getIsbn() {
		return isbn;
	}
    public BookType getType() {
		return type;
	}
    public String getDescription() {
		return description;
	}
    public int getSubmissionUserId() {
		return submissionUserId;
	}
    public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}
    public ImageIcon getCoverImageIcon() {
		return coverImageIcon;
	}
    public Path getFilePath() {
		return filePath;
	}
    public void setBookId(int bookId) {
		this.bookId = bookId;
	}
    public void setBookName(String bookName) {
		this.bookName = bookName;
	}
    public void setAuthor(String author) {
		this.author = author;
	}
    public void setPress(String press) {
		this.press = press;
	}
    public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}
    public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
    public void setType(BookType type) {
		this.type = type;
	}
    public void setDescription(String description) {
		this.description = description;
	}
    public void setSubmissionUserId(int submissionUserId) {
		this.submissionUserId = submissionUserId;
	}
    public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}
    public void setCoverImageIcon(ImageIcon coverImageIcon) {
		this.coverImageIcon = coverImageIcon;
	}
    public void setFilePath(String filePath) {
        this.filePath = Paths.get(filePath);
    }
}

