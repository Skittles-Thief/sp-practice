package com.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	/* boardMapper에서 작성한 쿼리를 이곳에 추가 */
	
	@Inject /* 객체 타입에 맞게 클래스를 주입 */
 private SqlSession sql;
 private static String namespace = "com.board.mappers.board";

 // 게시물 목록
 @Override
 public List<BoardVO> list() throws Exception { 
  
  return sql.selectList(namespace + ".list");
 }

@Override
public void write(BoardVO vo) throws Exception {
	// TODO Auto-generated method stub
	
	sql.insert(namespace+ ".write",vo); 
}

@Override
public BoardVO view(int bno) throws Exception {
	// TODO Auto-generated method stub
	return sql.selectOne(namespace+".view",bno);
}

@Override
public void modify(BoardVO vo) throws Exception {
	// TODO Auto-generated method stub
	sql.update(namespace+".modify",vo);
}

@Override
public void delete(int bno) throws Exception {
	// TODO Auto-generated method stub
	sql.delete(namespace+".delete",bno);
}

}