package com.simple.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;


//@Service
@Service("이름") //빈의 이름 명시
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	@Qualifier("yyy")
	private ScoreDAO scoreDAO;
	
	@Override
	public void regist(ScoreVO vo) {
		System.out.println(vo.toString());
		scoreDAO.regist(vo);
	}

	@Override
	public List<ScoreVO> getList() {
		//List<ScoreVO> list = scoreDAO.getList();
		return scoreDAO.getList();
	}

	@Override
	public void delete(int num) {
		scoreDAO.delete(num);
		
	}
	
}
