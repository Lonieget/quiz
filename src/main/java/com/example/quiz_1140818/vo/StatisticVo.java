package com.example.quiz_1140818.vo;

import java.util.List;

import com.example.quiz_1140818.entity.Quiz;

public class StatisticVo {

	private Quiz quiz;

	private List<QuestionsCountVo> questionsCountVoList;

	public StatisticVo(Quiz quiz, List<QuestionsCountVo> questionsCountVoList) {
		super();
		this.quiz = quiz;
		this.questionsCountVoList = questionsCountVoList;
	}

	public StatisticVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public List<QuestionsCountVo> getQuestionsCountVoList() {
		return questionsCountVoList;
	}

	public void setQuestionsCountVoList(List<QuestionsCountVo> questionsCountVoList) {
		this.questionsCountVoList = questionsCountVoList;
	}

}
