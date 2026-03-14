package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.MartRequestDto;
import com.dto.MartResponceDto;
import com.service.MartService;

@RestController
public class MartController 
{
	@Autowired
	MartService martService;

	@PostMapping("/save")
	public MartResponceDto saving(@RequestBody MartRequestDto requestDto)
	{
		return martService.saved(requestDto);
	}
	
	@GetMapping("/find/{id}")
	public MartResponceDto finding(@PathVariable("id") Long id)
	{
		return martService.search(id);
	}
	
	
	@GetMapping("/findAll")
	public List<MartResponceDto> findAll()
	{
		return martService.all();
	}
	
	@PutMapping("/update")
	public MartResponceDto update(@RequestParam ("id") Long id,String name)
	{
		return martService.updating(id,name);
	}
	@GetMapping("/ids")
	public List<MartResponceDto> ids(@RequestParam("ids") List<Long>ids)
	{
		return martService.searchIds(ids);
	}
}
//hii
