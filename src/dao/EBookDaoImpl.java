package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import service.EBook;
import uitl.DBUtil;

public class EBookDaoImpl implements EBookDao {
	private final static String selectAll = "SELECT * FROM EBook";
	private final static String add = "INSERT INTO tb_book_table(bookname,author,type_id)value(?,?,?)";
	private final static String update = "update tb_book_table set ISBN=? where book_id=?";
	private final static String delete = "delete from tb_book_table where book_id=?";
	private final static String blurryName = "select * from tb_book_table where bookname like ?";
	private final static String deleteBook = "select * from tb_book_table where book_id=?";
	private final static String selectAllPage = "select * from book limit ?,?";

	static Connection conn = null;
	static PreparedStatement statement = null;

	public EBookDaoImpl() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void add(EBook book) throws SQLException {
		statement = conn.prepareStatement(add);
		statement.setString(1, book.getBookName());
		statement.setString(2, book.getAuthor());
		statement.setString(3, book.getType().getCode());
		statement.executeUpdate();
	}

	@Override
	public void update(EBook book) throws SQLException {
		// TODO Auto-generated method stub
		statement = conn.prepareStatement(update);
		statement.setString(1, book.getBookName());
		statement.setString(2, book.getAuthor());
		statement.setString(3, book.getType().getCode());
		statement.executeUpdate();
	}

	@Override
	public void delete(EBook book) throws SQLException {
		// TODO Auto-generated method stub
		statement = conn.prepareStatement(delete);
		statement.setInt(1, book.getBookId());
		statement.executeUpdate();
	}

	@Override
	public List<EBook> blurryName(EBook book) throws SQLException {
		// TODO Auto-generated method stub
		statement = conn.prepareStatement(blurryName);
		statement.setString(1, "%" + book.getBookName() + "%");
		ResultSet resultSet = statement.executeQuery();
		List<EBook> list = new ArrayList<EBook>();
		while (resultSet.next()) {
			EBook eBook = new EBook(resultSet.getString("bookname"), resultSet.getString("author"),
					EBook.BookType.getCategoryByCode(resultSet.getString("type_id")));
			eBook.setBookId(resultSet.getInt("book_id"));
			eBook.setPublicationDate(resultSet.getObject("publication_date", LocalDate.class));
			eBook.setPress(resultSet.getString("press"));
			eBook.setIsbn(resultSet.getString("ISBN"));
			eBook.setDescription(resultSet.getString("description"));
			eBook.setSubmissionUserId(resultSet.getInt("submission_user_id"));
			eBook.setSubmissionDate(resultSet.getObject("submission_time", LocalDateTime.class));
			eBook.setCoverImageUrl(resultSet.getString("cover_image_url"));
			eBook.setFilePath(resultSet.getString("file_path"));
			list.add(eBook);
		}
		return list;
	}

	@Override
	public EBook bookInfo(EBook book) throws SQLException {
		statement = conn.prepareStatement(deleteBook);
		statement.setInt(1, book.getBookId());
		ResultSet resultSet = statement.executeQuery();
		EBook eBook = new EBook(resultSet.getString("bookname"), resultSet.getString("author"),
				EBook.BookType.getCategoryByCode(resultSet.getString("type_id")));
		eBook.setBookId(resultSet.getInt("book_id"));
		eBook.setPublicationDate(resultSet.getObject("publication_date", LocalDate.class));
		eBook.setPress(resultSet.getString("press"));
		eBook.setIsbn(resultSet.getString("ISBN"));
		eBook.setDescription(resultSet.getString("description"));
		eBook.setSubmissionUserId(resultSet.getInt("submission_user_id"));
		eBook.setSubmissionDate(resultSet.getObject("submission_time", LocalDateTime.class));
		eBook.setCoverImageUrl(resultSet.getString("cover_image_url"));
		eBook.setFilePath(resultSet.getString("file_path"));
		return eBook;
	}

	@Override
	public List<EBook> selectAll(int currentPage, int pageSize) throws SQLException {
		statement = conn.prepareStatement(selectAllPage);
		statement.setInt(1, (currentPage - 1) * pageSize);
		statement.setInt(2, pageSize);
		ResultSet resultSet = statement.executeQuery();
		List<EBook> list = new ArrayList<EBook>();
		while (resultSet.next()) {
			EBook eBook = new EBook(resultSet.getString("bookname"), resultSet.getString("author"),
					EBook.BookType.getCategoryByCode(resultSet.getString("type_id")));
			eBook.setBookId(resultSet.getInt("book_id"));
			eBook.setPublicationDate(resultSet.getObject("publication_date", LocalDate.class));
			eBook.setPress(resultSet.getString("press"));
			eBook.setIsbn(resultSet.getString("ISBN"));
			eBook.setDescription(resultSet.getString("description"));
			eBook.setSubmissionUserId(resultSet.getInt("submission_user_id"));
			eBook.setSubmissionDate(resultSet.getObject("submission_time", LocalDateTime.class));
			eBook.setCoverImageUrl(resultSet.getString("cover_image_url"));
			eBook.setFilePath(resultSet.getString("file_path"));
			list.add(eBook);
		}
		return list;
	}

	@Override
	public List<EBook> selectAll() throws SQLException {
		statement = conn.prepareStatement(selectAll);
		ResultSet resultSet = statement.executeQuery();
		List<EBook> list = new ArrayList<EBook>();
		while (resultSet.next()) {
			EBook eBook = new EBook(resultSet.getString("bookname"), resultSet.getString("author"),
					EBook.BookType.getCategoryByCode(resultSet.getString("type_id")));
			eBook.setBookId(resultSet.getInt("book_id"));
			eBook.setPublicationDate(resultSet.getObject("publication_date", LocalDate.class));
			eBook.setPress(resultSet.getString("press"));
			eBook.setIsbn(resultSet.getString("ISBN"));
			eBook.setDescription(resultSet.getString("description"));
			eBook.setSubmissionUserId(resultSet.getInt("submission_user_id"));
			eBook.setSubmissionDate(resultSet.getObject("submission_time", LocalDateTime.class));
			eBook.setCoverImageUrl(resultSet.getString("cover_image_url"));
			eBook.setFilePath(resultSet.getString("file_path"));
			list.add(eBook);
		}
		return list;
	}
}
