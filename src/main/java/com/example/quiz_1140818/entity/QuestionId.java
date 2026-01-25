package com.example.quiz_1140818.entity;

import java.io.Serializable;

// 創這個表是為了集中管理雙PK，要用序列化(Serializable)實作
// QuestionId會有黃蚯蚓，要選@SuppressWarnings("serial")讓黃蚯蚓不見
@SuppressWarnings("serial")
public class QuestionId implements Serializable{ //要記得序列化(implements)

	private int quizId;

	private int questionId;

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}
