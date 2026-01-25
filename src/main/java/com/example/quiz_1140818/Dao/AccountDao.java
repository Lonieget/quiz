package com.example.quiz_1140818.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.quiz_1140818.entity.Account;
import com.example.quiz_1140818.entity.AccountUser;

@Repository
public interface AccountDao extends JpaRepository<Account, String> {

	@Modifying
	@Transactional
	@Query(value = "insert into account (account,password,name,phone,email,age,gender) values (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
	public void addInfo(String account, String password, String name, String phone, String email, int age, String gender);

	@Query(value = "select count(account) from account where account = ?1", nativeQuery = true)
	public int selectCountByAccount(String account);//用這個方法可以在表中搜尋account裡有沒有輸入的值存在
	
	@Query(value = "select * from account where account = ?1", nativeQuery = true)
	public Account selectByAccount(String account); //在account表搜尋account欄位

	// 假設 account_user 是一張包含所有欄位的表
	@Query(value = "SELECT * FROM account WHERE account = ?1", nativeQuery = true)
	public AccountUser selectUserByAccount(String account);
}
