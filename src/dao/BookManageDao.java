package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.BookManage;

public class BookManageDao extends BaseDao {
	public List<BookManage> findAll(){//查询数据
		List<BookManage> petList = new ArrayList<BookManage>();
		Connection con = getConnection();
		String sql = new String("select * from BookManage ");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				BookManage pet = new BookManage();
				pet.setBid(rs.getInt("b_Id"));
				pet.setBname(rs.getString("b_Name"));
				pet.setBauthor(rs.getString("b_author"));
				pet.setBtime(rs.getDate("b_time"));
				pet.setBtype(rs.getInt("b_type"));
				petList.add(pet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}
		return petList;
	}
	
	public int add(BookManage pet){//添加数据
		Connection con = getConnection();
		String sql = new String(" insert into BookManage (b_Name,b_author,b_time,b_type) values(?,?,?,?) ");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, pet.getBname());
			ps.setObject(2, pet.getBauthor());
			ps.setObject(3, pet.getBtimes());
			ps.setObject(4, pet.getBtype());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		closeAll(con, ps, rs);
		}
		return 0;
	}
	public int delet(int petId){//删除数据
		Connection con = getConnection();
		String sql = new String(" delete BookManage where b_Id=? ");
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, petId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps,null);
		}
		return 0;
	}
	public BookManage findById(int id){//查询ID值
		Connection con = getConnection();
		String sql = new String("select * from BookManage where b_Id = ? ");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				BookManage pet = new BookManage();
				pet.setBid(rs.getInt("b_Id"));
				pet.setBname(rs.getString("b_Name"));
				pet.setBauthor(rs.getString("b_author"));
				pet.setBtime(rs.getDate("b_time"));
				pet.setBtype(rs.getInt("b_type"));
				return pet;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}
		return null;
	}
	
	public int update(BookManage pet){//修改数据
		Connection con = getConnection();
		String sql = new String(" update BookManage set B_name=?,b_author=?,b_time=?,b_type=?  where b_Id = ? ");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, pet.getBname());
			ps.setObject(2, pet.getBauthor());
			ps.setObject(3, pet.getBtimes());
			ps.setObject(4, pet.getBtype());
			ps.setObject(5, pet.getBid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}
		return 0;
	}
}
