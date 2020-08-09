package com.incture.dao;


import com.incture.dto.GeneralDto;

public interface GeneralDao {

	GeneralDto listGeneralDataById(GeneralDto generalDto);
	GeneralDto listGeneralMasterById(GeneralDto generalDto);
	
	
	void insertGeneralData(GeneralDto generalDto);
	void insertGeneralDataMaster(GeneralDto generalDto);
}
