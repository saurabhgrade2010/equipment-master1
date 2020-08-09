package com.incture.dao;

import java.util.ArrayList;
import java.util.List;
import com.incture.dto.OrganizationDto;

public interface OrganizationDao {

	void insertOrganizationData(List<OrganizationDto> organizationList,String id,int version);
	void insertOrganizationDataMaster(List<OrganizationDto> organizationList,String id,int version);

	ArrayList<OrganizationDto> listOrganizationStaggedDataById(OrganizationDto organizationDto);
	ArrayList<OrganizationDto> listOrganizationMasterDataById(OrganizationDto organizationDto);
	
}
