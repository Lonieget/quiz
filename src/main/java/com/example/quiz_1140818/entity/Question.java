package com.example.quiz_1140818.entity;

import com.example.quiz_1140818.constants.ConstantsMessage;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@IdClass(value = QuestionId.class) //為了能夠使用QuestionId
@Table(name = "question")
public class Question {

	@Id
	@Column(name = "quiz_id")
	private int quizId;
	
	//這個是question的id，因為解讀順序的關係，所以這樣放
	
	@Id
	@Column(name = "question_id")
	private int questionId ; 
	
	
	@Column(name = "name")
	private String name;
	
	//物件 Options 轉成字串 塞進 optionsStr
	@Column(name = "options_str")
	private String optionsStr;
	
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "is_required")
	private boolean required;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question( int questionId, String name, String optionsStr, String type, boolean required) {
		super();
		this.questionId = questionId;
		this.name = name;
		this.optionsStr = optionsStr;
		this.type = type;
		this.required = required;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOptionsStr() {
		return optionsStr;
	}

	public void setOptionsStr(String optionsStr) {
		this.optionsStr = optionsStr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	

	
	
	
	
}
