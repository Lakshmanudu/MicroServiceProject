package com.microservice.consumer.controller;

import java.io.IOException;

import com.microservice.consumer.model.Employee;
import com.microservice.consumer.service.FeignCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

@Controller
public class ConsumerControllerClient {


	@Autowired
	private FeignCallService loadBalancer;

	public void getEmployee() throws RestClientException, IOException {
		
		
		try{
			Employee emp = loadBalancer.getData();
			System.out.println("Employee ID from Producer :" + emp.getEmpId());
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		
	}

}