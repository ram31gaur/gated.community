package com.gated.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gated.model.Ticket;

public class CommunityControllerTest extends AbstractTest{

		@Test
		public void raiseTicket() throws Exception {
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			String uri = "/myTickets";
			Ticket ticket = new Ticket("raisedBy", "raisedFor", "status", "issue");
			String inputJson = super.mapToJson(ticket);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			assertEquals(content, "[]");
		}
		
		@Test
		public void getMyTickets() throws Exception {
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			String uri = "/myTickets";
			String approverName = "Ram";
			String inputJson = super.mapToJson(approverName);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			assertEquals(content, "[]");
		}
		
		@Test
		public void getMyApprovals() throws Exception {
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			String uri = "/myApprovals";
			String approverName = "Ram";
			String inputJson = super.mapToJson(approverName);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
   
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			assertEquals(content, "[]");
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		@Test
		public void getResidentsList() throws Exception {
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			String uri = "/listAllResidents";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			String[] productlist = super.mapFromJson(content, String[].class);
			assertTrue(productlist.length == 0);
		}
		
		@Test
		public void getVisitorList() throws Exception {
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			String uri = "/listAllVisitors";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			String[] productlist = super.mapFromJson(content, String[].class);
			assertTrue(productlist.length == 0);
		}
		
		@Test
		public void getSecurityList() throws Exception {
			mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			String uri = "/listAllSecurity";
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			String[] productlist = super.mapFromJson(content, String[].class);
			assertTrue(productlist.length == 0);
		}

}
