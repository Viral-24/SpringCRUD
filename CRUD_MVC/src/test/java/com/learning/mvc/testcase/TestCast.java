package com.learning.mvc.testcase;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.learning.mvc.service.IDAO;
import com.learning.mvc.service.IDAO_imp;
import com.learning.mvc.ForntController.UserModels;




public class TestCast {

	IDAO ido=new IDAO_imp(); 
	
	@Ignore
	@Test
	public void testConncetion()
	{
		boolean isConnected=ido.getConnection();
		assertEquals(true,isConnected);
	}
	
	@Ignore
	@Test
	public void testRecords()
	{	
		List<UserModels> userlist=new ArrayList<UserModels>();
		userlist=ido.getRecords();
		assertEquals(true,userlist.size()>0);
	}
	
	@Ignore
	@Test
	public void testInsertValuse() {
		UserModels model=new UserModels();
		model.setId(03);
		model.setName("Manu");
		model.setEmail("manu@gmail.com");
		model.setAddr("Pune");
		model.setPhone("9826452561");
		boolean recordsInserted=ido.insertingRecords(model);
		assertEquals(true,recordsInserted);
	}
	@Ignore
	@Test
	public void eidtRecord() {
		UserModels model=new UserModels();
		model.setId(1);	
		model.setName("Das");
		model.setEmail("Das1@gmail.com");
		model.setAddr("Pune");
		model.setPhone("5551481351");
		int rowAffected=ido.editRecords(1,model);
		assertEquals(1, rowAffected);
	}

	@Test
	public void textRecordById() {
		UserModels model=ido.getRecordsById(2);
		String userName=model.getName();
		assertEquals("Sachin",userName);
	}
	@Ignore
	@Test
	public void deleteRecordTest() {
		int rowDelete=ido.deleteRecords(1);
		assertEquals(1,rowDelete);
	}
}
