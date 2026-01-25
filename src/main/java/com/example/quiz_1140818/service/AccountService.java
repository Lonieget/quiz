package com.example.quiz_1140818.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.quiz_1140818.Dao.AccountDao;
import com.example.quiz_1140818.constants.ResCodeMessage;
import com.example.quiz_1140818.entity.Account;
import com.example.quiz_1140818.entity.AccountUser;
import com.example.quiz_1140818.response.BasicRes;
import com.example.quiz_1140818.response.UserRes;

@Service
public class AccountService {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private AccountDao accountDao;

	public BasicRes addInfo(String account, String password ,String name ,String phone, String email, int age , String gender) {
		try { // 因為沒有檢查addinfo有沒有參數，所以用try catch 檢查
				// 若文件有說明新增資訊前要先檢查帳號是否已存在
			int count = accountDao.selectCountByAccount(account);
			// 因為是透過 PK 欄位 account 來查詢是否有存在值，所以 account 只會是 0 或 1 ，1代表PK存在
			if (count == 1) {
				return new BasicRes(ResCodeMessage.ACCOUNT_EXIST.getCode(), //
						ResCodeMessage.ACCOUNT_EXIST.getMessage());
			}
			//存進 DB 中的密碼要記得加密
			accountDao.addInfo(account, encoder.encode(password), name , phone, email, age , gender);
			return new BasicRes(ResCodeMessage.SUCCESS.getCode(), //
					ResCodeMessage.SUCCESS.getMessage());
		} catch (Exception e) {
			// 若是 id(PK) 已存在，新增資料就會失敗
			// 發生 Exception 時，可以有以下2種處理方式
			// 1. 固定的回覆訊息，但真正錯誤原因無法顯示

//			return new BasicRes(ResCodeMessage.ADD_INFO_FAILED.getCode(), //
//					ResCodeMessage.ADD_INFO_FAILED.getMessage()); -->這個是原本使用的方法，但也可以用

			// 2. 將 catch 到的例外(Exception)拋出(Throw)，再由自訂義的類別
			// GlobalExceptionHandler 寫入(回覆)真正的錯誤訊息
			throw e; // -->把例外拋去給 globalexceptionhandler
			// 把抓到的e拋出去，會使用exception的第三種，可以在postman中的trace顯示更明確的錯誤訊息
			// ，對前端或是使用者來說更明確
			// 何時使用1或2的方法：看文件
		}
	};
	
	public UserRes login(String account, String password) {
		// 使用 account 取得對應資料
		Account data = accountDao.selectByAccount(account);
		if(data == null) { // data == null 表示沒資料 --> 也表示該帳號不存在
			return new UserRes(ResCodeMessage.NOT_FOUND.getCode(), //
					ResCodeMessage.NOT_FOUND.getMessage());
		}
		//比對密碼：使用排除法，所以前面記得要有驚嘆號，表示密碼匹配不成功
		if(!encoder.matches(password, data.getPassword())) {
			return new UserRes(ResCodeMessage.PASSWORD_MISSMATCH.getCode(), //
					ResCodeMessage.PASSWORD_MISSMATCH.getMessage());
		}

		return new UserRes(
		        ResCodeMessage.SUCCESS.getCode(), 
		        ResCodeMessage.SUCCESS.getMessage(),
		        data.getName(),    // String
		        data.getPhone(),   // String
		        data.getEmail(),   // String
		        data.getAge(),     // int <--- 檢查 UserRes 這裡是否也是 int
		        data.getGender()   // String
		    );
		
	}

}
