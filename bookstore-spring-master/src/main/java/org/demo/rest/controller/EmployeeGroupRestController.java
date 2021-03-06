/*
 * Created on 3 avr. 2014 ( Time 19:39:50 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.demo.bean.EmployeeGroup;
import org.demo.business.service.EmployeeGroupService;
import org.demo.web.listitem.EmployeeGroupListItem;

/**
 * Spring MVC controller for 'EmployeeGroup' management.
 */
@Controller
public class EmployeeGroupRestController {

	@Resource
	private EmployeeGroupService employeeGroupService;
	
	@RequestMapping( value="/items/employeeGroup",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<EmployeeGroupListItem> findAllAsListItems() {
		List<EmployeeGroup> list = employeeGroupService.findAll();
		List<EmployeeGroupListItem> items = new LinkedList<EmployeeGroupListItem>();
		for ( EmployeeGroup employeeGroup : list ) {
			items.add(new EmployeeGroupListItem( employeeGroup ) );
		}
		return items;
	}
	
	@RequestMapping( value="/employeeGroup",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<EmployeeGroup> findAll() {
		return employeeGroupService.findAll();
	}

	@RequestMapping( value="/employeeGroup/{employeeCode}/{groupId}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public EmployeeGroup findOne(@PathVariable("employeeCode") String employeeCode, @PathVariable("groupId") Short groupId) {
		return employeeGroupService.findById(employeeCode, groupId);
	}
	
	@RequestMapping( value="/employeeGroup",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public EmployeeGroup create(@RequestBody EmployeeGroup employeeGroup) {
		return employeeGroupService.create(employeeGroup);
	}

	@RequestMapping( value="/employeeGroup/{employeeCode}/{groupId}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public EmployeeGroup update(@PathVariable("employeeCode") String employeeCode, @PathVariable("groupId") Short groupId, @RequestBody EmployeeGroup employeeGroup) {
		return employeeGroupService.update(employeeGroup);
	}

	@RequestMapping( value="/employeeGroup/{employeeCode}/{groupId}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("employeeCode") String employeeCode, @PathVariable("groupId") Short groupId) {
		employeeGroupService.delete(employeeCode, groupId);
	}
	
}
