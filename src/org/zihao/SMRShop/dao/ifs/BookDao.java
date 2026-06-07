package org.zihao.SMRShop.dao.ifs;

import java.util.List;

import org.zihao.SMRShop.bean.Book;
import org.zihao.SMRShop.dao.enums.BookCond;

public abstract class BookDao extends BaseDaoImpl<Book>
{
	public abstract List<Book> getByCond(BookCond bCond, Object value);

	public abstract boolean saveOrUpdate(Book book);
}
