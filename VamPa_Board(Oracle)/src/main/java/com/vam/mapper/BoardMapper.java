package com.vam.mapper;

import java.util.List;

import com.vam.model.BoardVO;

public interface BoardMapper {
	 /* 글 등록 */
    public void enroll(BoardVO board);
    
    /* 게시판 목록 */
    public List<BoardVO> getList();
    /* 게시글 상세조회*/
	public BoardVO getPage(int bno);
    
    /* 게시글 수정 */
    public int modify(BoardVO board);
    
    /* 게시글 삭제 */
    public int delete(int bno);
}
