package himedia.myportal.repositories;

import java.util.List;

import himedia.myportal.repositories.vo.GuestbookVo;

public interface GuestbookDao {
	public List<GuestbookVo> selectAll();
	public int insert(GuestbookVo vo);
	public int delete(GuestbookVo vo);
	
}
