package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
//		// 등록
//				ReplyVO rvo = new ReplyVO();
//				rvo.setBoardNo(132);
//				rvo.setReply("댓글연습용");
//				rvo.setReplyer("userNew");
//				svc.addReply(rvo);
//				
//		//삭제
//		svc.removeReply(9);
//		
//		
//		//목록
//		List<ReplyVO> list = svc.replyList(132);
//		for(ReplyVO vo : list) {
//			System.out.println(vo.toString());
//		}
		ReplyVO reply = svc.getReply(10);
		System.out.println(reply);
		
	}
}
