package service;

import java.sql.SQLException;
import java.util.List;

import dao.EBookDao;
import dao.EBookDaoImpl;

public class BookServiceImpl implements BookService {
	EBookDao bookDao = new EBookDaoImpl();
	
	@Override
	public List<EBook> selectAll() throws SQLException {
		return bookDao.selectAll();
	}

	@Override
	public void add(EBook book) throws SQLException {
		bookDao.add(book);
	}

	@Override
	public void update(EBook book) throws SQLException {
		bookDao.update(book);
	}

	@Override
	public void delete(EBook book) throws SQLException {
		bookDao.delete(book);
	}

	@Override
	public List<EBook> blurryName(EBook book) throws SQLException {
		return bookDao.blurryName(book);
	}

	@Override
	public EBook bookInfo(EBook book) throws SQLException {
		return bookDao.bookInfo(book);
	}

	@Override
	public List<EBook> selectAll(int currentPage, int pageSize) throws SQLException {
		return bookDao.selectAll(currentPage, pageSize);
	}

}
