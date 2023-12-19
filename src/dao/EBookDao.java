package dao;

import java.sql.SQLException;
import java.util.List;

import service.EBook;

public interface EBookDao {
    /**
     * 查询所有图书
     */
    List<EBook> selectAll() throws SQLException;

    /**
     * 添加图书
     */
    void add(EBook book) throws SQLException;

    /**
     * 更新图书信息
     */
    void update(EBook book) throws SQLException;

    /**
     * 删除图书
     */
    void delete(EBook book) throws SQLException;

    /**
     * 根据书名模糊查询
     */
    List<EBook> blurryName(EBook book) throws SQLException;

    /**
     * 获取具体的图书信息
     * @return
     */
    EBook bookInfo(EBook book) throws SQLException;

    /**
     * 分页查询图书
     */
    List<EBook> selectAll(int currentPage,int pageSize) throws SQLException;
}