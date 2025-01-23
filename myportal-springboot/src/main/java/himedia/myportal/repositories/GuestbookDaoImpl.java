package himedia.myportal.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exceptions.GuestbookDaoException;
import himedia.myportal.mappers.GuestbookMapper;
import himedia.myportal.repositories.vo.GuestbookVo;

@Repository
public class GuestbookDaoImpl 
	implements GuestbookDao {
	
	@Autowired
	private GuestbookMapper guestbookMapper;
	
	@Override
	public List<GuestbookVo> selectAll() {
//	List<GuestbookVo> list = guestbookMapper.selectAll();
		return guestbookMapper.selectAll();
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = 0;
		try {
			insertedCount = 
					guestbookMapper.insert(vo);
			return insertedCount;
		} catch (Exception e) {
			throw new GuestbookDaoException("방명록 기록중 에러 발생",
											e,
											vo);
		}
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = 0;
		try {
			deletedCount =
					guestbookMapper.delete(vo);
			return deletedCount;
		} catch (Exception e) {
			throw new GuestbookDaoException("방명록 삭제중 에러 발생", 
											e,
											vo);
		}
	}

}
