package com.vam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vam.mapper.BoardMapper;
import com.vam.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	// 스프링이 관리하는 객체(빈)은 싱글통패턴으로 관리되어 1개의 인스턴스가 유지된다.
	// Autowired를 통해 new 생성자로 호출없이 그 객체를 사용할 수 있다.
	
	// enroll 함수 안에서는 BoardMapper의 인스턴스를 사용해야하는데
	// 그 인스턴스를 enroll 안에서 생성하는 것이 아니라 외부에서 생성된 것을 주입받아서 사용하고 있다.
	// 왜 enroll 함수안에서 생성하지 않는가? 높은 응집도(속성이 비슷한것끼리 뭉쳐있다.), 낮은 결합도(의존성이 줄어든다)를 위해서
	// 안에서 생성하게 되면, 어떤 생성자를 쓸지, 어떻게 생성할지 등을 enroll을 만드는 개발자가 알아야된다.
	// 외부에서 주입받게 되면 어떻게 만들어졌는지 관심이 없다. 만들어져있는 것을 쓰기만 할거다.
	@Override
	public void enroll(BoardVO board) {
		mapper.enroll(board);
	}


    @Override
    public List<BoardVO> getList() {
        
        return mapper.getList();
    }
    
    /* 게시판 조회 */
    @Override
    public BoardVO getPage(int bno) {
         
        return mapper.getPage(bno);
    } 
    
    /* 게시글 수정 */
    @Override
    public int modify(BoardVO board) {
        
        return mapper.modify(board);
    }
    
    /* 게시글 삭제 */
    @Override
    public int delete(int bno) {
    	return mapper.delete(bno);
    }
}
