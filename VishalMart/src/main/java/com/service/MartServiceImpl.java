package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.MartRequestDto;
import com.dto.MartResponceDto;
import com.model.VishalMart;
import com.repository.MartRepository;

@Service
public class MartServiceImpl implements MartService
{


	@Autowired
	MartRepository martRepository;

	@Override
	public MartResponceDto saved(MartRequestDto requestDto) {
		
		VishalMart mart=new VishalMart();
		mart.setMartName(requestDto.getMartName());
		mart.setManagerName(requestDto.getManagerName());
		mart.setAddress(requestDto.getAddress());
		mart.setCity(requestDto.getCity());
		mart.setState(requestDto.getState());
		VishalMart save = martRepository.save(mart);
		MartResponceDto dto=new MartResponceDto();
		BeanUtils.copyProperties(save, dto);
		
		return dto;
	}

	@Override
	public MartResponceDto search(Long id) 
	{
		VishalMart vishalMart = martRepository.findById(id).get();
		
		MartResponceDto responceDto=new MartResponceDto();
		BeanUtils.copyProperties(vishalMart, responceDto);
		
		return responceDto;
	}

	@Override
	public List<MartResponceDto> all() 
	{
		List<VishalMart> all = martRepository.findAll();
		List<MartResponceDto>dto=new ArrayList<>();
		for(VishalMart mart :all)
		{
			MartResponceDto responceDto=new MartResponceDto();
			BeanUtils.copyProperties(mart, responceDto);
			dto.add(responceDto);
		}
		
		
		return dto;
	}

	@Override
	public MartResponceDto updating(Long id, String name) {
		VishalMart vishalMart = martRepository.findById(id).get();
		vishalMart.setManagerName(name);
		VishalMart save = martRepository.save(vishalMart);
		MartResponceDto dto=new MartResponceDto();
		BeanUtils.copyProperties(save, dto);
				
		
		return dto ;
	}

	@Override
	public List<MartResponceDto> searchIds(List<Long> ids) {
		List<VishalMart> allById = martRepository.findAllById(ids);
		List<MartResponceDto> dtoList=new ArrayList<>();
		for(VishalMart mart :allById)
		{
			MartResponceDto responce=new MartResponceDto();
			BeanUtils.copyProperties(mart, responce);
			dtoList.add(responce);
		}
		return dtoList;
	}

}
