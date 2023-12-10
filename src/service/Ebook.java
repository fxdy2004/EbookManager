package service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EBook {
//	private static int nextId=0;//这里应该调用数据库获得图书总数
	private static final AtomicInteger nextId=new AtomicInteger();//同上
    private int bookId;
    private String bookName;
    private String author;
    private LocalDate publicationDate;
    private String press;
    private String isbn;
    private BookCategory category;
    private String description;
    private String submissionUserId;
    private LocalDateTime submissionDate;
    private String coverImageUrl;
    private Path filePath;
    
    public EBook() {
    	this.bookId=nextId.getAndIncrement();
    }
    public EBook(String bookName,String author) {
    	this();
    	setBookName(bookName);
    	setAuthor(author);
    }
    
    public enum BookCategory {
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
        BookCategory(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
        public static BookCategory getCategoryByCode(String code) {
            for (BookCategory category : values()) {
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
    public BookCategory getCategory() {
		return category;
	}
    public String getDescription() {
		return description;
	}
    public String getSubmissionUserId() {
		return submissionUserId;
	}
    public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}
    public String getCoverImageUrl() {
		return coverImageUrl;
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
    public void setCategory(BookCategory category) {
		this.category = category;
	}
    public void setDescription(String description) {
		this.description = description;
	}
    public void setSubmissionUserId(String submissionUserId) {
		this.submissionUserId = submissionUserId;
	}
    public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}
    public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}
    public void setFilePath(String filePath) {
        this.filePath = Paths.get(filePath);
    }
}

