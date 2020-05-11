package com.learning.mvc.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.mvc.ForntController.UserModels;
@Component
public interface IDAO {

	boolean getConnection();

	List<UserModels> getRecords();

	boolean insertingRecords(UserModels model);

	int editRecords(int i, UserModels model);

	UserModels getRecordsById(int i);

	int deleteRecords(int i);

}
