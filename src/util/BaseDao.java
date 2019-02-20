package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class BaseDao {
private QueryRunner queryRunner=new QueryRunner();
public int update(String sql,Object...obj){
	Connection conn=null;

	try {
		conn=ConnectionUtil.getConnection();
		return queryRunner.update(conn,sql, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return -1;
}

public <T> List<T> queryList(String sql,BeanListHandler<T> bh,Object...obj){
	Connection conn=null;
	conn=ConnectionUtil.getConnection();
	try {
		return queryRunner.query(conn, sql, bh, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
}

public <T> T querySingled(String sql,BeanHandler<T> bh,Object...obj){
	Connection conn=null;
	conn=ConnectionUtil.getConnection();
	try {
		return queryRunner.query(conn, sql, bh, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
}

public Object queryColumn(String sql,ScalarHandler sh,Object...obj){
	Connection conn=null;
	conn=ConnectionUtil.getConnection();
	try {
		return queryRunner.query(conn, sql, sh, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
}
public List queryColumnList(String sql,ColumnListHandler cl,Object...obj){
	Connection conn=null;
	conn=ConnectionUtil.getConnection();
	try {
		return queryRunner.query(conn, sql, cl, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return null;
}



}
