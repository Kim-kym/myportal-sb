package himedia.myportal.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.myportal.repositories.vo.BoardVo;

@Mapper
public interface BoardMapper {
	//	<select id="selectAll" resultType="boardVo">
	List<BoardVo> selectAll();
	//	<insert id="insert" parameterType="boardVo">
	int insert(BoardVo boardvo);
	//	<update id="increaseHitCount" parameterType="int">
	int increaseHitCount(Integer no);
	//	<select id="getContent" parameterType="int" resultType="boardVo">
	BoardVo getContent(Integer no);
	//	<update id="update" parameterType="boardVo">
	int update(BoardVo boardvo);
	//	<delete id="delete" parameterType="map">
	int delete(Integer no, Integer userNo); 
}
