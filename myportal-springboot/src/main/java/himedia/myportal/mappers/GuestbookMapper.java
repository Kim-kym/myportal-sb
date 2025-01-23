package himedia.myportal.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.myportal.repositories.vo.GuestbookVo;

@Mapper
public interface GuestbookMapper {
	//	<select id="selectAll" resultType="guestbookVo">
	List<GuestbookVo> selectAll();
	//	<insert id="insert" parameterType="guestbookVo">
	int insert(GuestbookVo guestbookVo);
	//	<delete id="delete" parameterType="guestbookVo">
	int delete(GuestbookVo guestbookVo);
}