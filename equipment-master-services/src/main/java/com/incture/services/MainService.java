package com.incture.services;
import com.incture.dto.AllDto;
import com.incture.dto.BasicDTO;
import com.incture.dto.FilterDto;
import com.incture.utils.ResponseDto;


public interface MainService {
	
	ResponseDto saveStaggedData(AllDto allDto);
	
	ResponseDto readAllData(FilterDto filterDto);
	
	ResponseDto updateAllData(AllDto allDto);
	
	ResponseDto createMasterData(AllDto allDto);
	
	ResponseDto createMasterDataSync(BasicDTO basicDto);

}
