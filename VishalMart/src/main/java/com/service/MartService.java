package com.service;

import java.util.List;

import com.dto.MartRequestDto;
import com.dto.MartResponceDto;

public interface MartService {

	public MartResponceDto saved(MartRequestDto requestDto);

	public MartResponceDto search(Long id);

	public List<MartResponceDto> all();

	public MartResponceDto updating(Long id, String name);

	public List<MartResponceDto> searchIds(List<Long> ids);

}
