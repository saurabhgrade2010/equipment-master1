package com.incture.dao;

import java.util.HashMap;
import java.util.List;

import com.incture.dto.BasicDTO;
import com.incture.dto.FilterDto;
import com.incture.dto.GeneralDto;


public interface BasicDao {

	
	void insertBasicData(BasicDTO basicDTO);
	void insertBasicDataMaster(BasicDTO basicDTO);
	
	BasicDTO checkDataExist(BasicDTO basicDto,GeneralDto generalDto);
	
	void updateBasicData(BasicDTO basicDTO);
	
	void updateMasterData(BasicDTO basicDTO);
	
	boolean isIdExist(FilterDto filterDto);
	int getLastVersion(String s,boolean flag);
	String getLastId();
	BasicDTO listBasicData(BasicDTO basicDTO); 
	BasicDTO listMasterData(BasicDTO basicDTO); 
	
	void insertIntoExcel(List<BasicDTO> l,int x);
	
	List<BasicDTO> exportFromExcel(int x);
	
	HashMap<String,Object> listBasicDataByFilterTwo(FilterDto filterDto);
	
	HashMap<Integer,String> listCategory();
	
	HashMap<Integer,String> listSortingData();
	
	
}
