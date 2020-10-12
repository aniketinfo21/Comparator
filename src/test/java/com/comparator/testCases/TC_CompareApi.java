package com.comparator.testCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comparator.common.GetResponse;
import com.comparator.utils.txtUtil;

import io.restassured.response.Response;

public class TC_CompareApi {


	@Test()
	public void compareApi() throws Exception {
		ArrayList<String> getFirstUri = txtUtil.getURI("firstApiList");
		ArrayList<String> getSecondUri = txtUtil.getURI("secondApiList");

		Response resFirst =null;
		Response resSecond = null;

		int length;

		if (getFirstUri.size() < getSecondUri.size() || getFirstUri.size() == getSecondUri.size()) {
			length = getFirstUri.size();
		} else {
			length = getSecondUri.size();
		}
		
		System.out.println("length "+length);

		for (int i = 0; i < length; i++) {
			resFirst = GetResponse.request(getFirstUri.get(i));
			resSecond = GetResponse.request(getSecondUri.get(i));
			
			try {
				Assert.assertEquals(resFirst.asString(), resSecond.asString());
				
			} catch (AssertionError e) {
				e.printStackTrace();
			}
		}
	}

}
