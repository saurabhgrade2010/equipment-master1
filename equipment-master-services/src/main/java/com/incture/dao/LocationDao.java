package com.incture.dao;

import java.util.ArrayList;
import java.util.List;
import com.incture.dto.LocationDto;


public interface LocationDao {

	void insertLocationData(List<LocationDto> locationList,String id,int version);
	void insertLocationDataMaster(List<LocationDto> locationList,String id,int version);
	
	ArrayList<LocationDto> listLocationStaggedDataById(LocationDto locationDto);
	
	ArrayList<LocationDto> listLocationMasterDataById(LocationDto locationDto);

	
	
}
