package com.simple.score.service;

import java.util.List;

import com.simple.command.ScoreVO;

public interface ScoreService {
	//service 구현체에서 사용할 추상메서드 모형 선언
	public void regist(ScoreVO vo);
	public List<ScoreVO> getList();
	public void delete(int num);
}
