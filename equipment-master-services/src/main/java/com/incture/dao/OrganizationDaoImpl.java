package com.incture.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.dto.OrganizationDto;
import com.incture.entities.BasicDataMaster;
import com.incture.entities.OrganizationData;
import com.incture.entities.OrganizationDataMaster;

@SuppressWarnings("deprecation")
@Repository("OrganizationDaoImpl")
public class OrganizationDaoImpl extends BaseDao<OrganizationDataMaster,OrganizationDto> implements OrganizationDao{


	@Override
	public void insertOrganizationData(List<OrganizationDto> organizationList,String id,int version) {
		
		for(OrganizationDto organizationDto : organizationList)
		{
		
		  organizationDto.setId(id);
		  organizationDto.setVersion(version);
		  getSession().save(importDtoStagged(organizationDto));
		
		}
	}


	@SuppressWarnings("rawtypes")
	@Override
	public void insertOrganizationDataMaster(List<OrganizationDto> organizationList,String id,int version) {
	
		  try{
				
			  
			  
			     if(version == 0)
			     {
			    	    String hql = "delete from OrganizationDataMaster conc where conc.id.id =: id ";
			            Query query = getSession().createQuery(hql);
			            query.setParameter("id",id);
			            query.executeUpdate();
			            
			            for(OrganizationDto organizationDto : organizationList)
						{
			            	organizationDto.setId(id);
							getSession().save(importDto(organizationDto));
						}
			            
			            System.out.println("update organization master table....." );
			     }
			     else
			     {
			    	 for(OrganizationDto organizationDto : organizationList)
						{
							organizationDto.setId(id);
							getSession().save(importDto(organizationDto));
						}
			    	 
			     }
			
			
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
         
        
	
		
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList<OrganizationDto> listOrganizationStaggedDataById(OrganizationDto organizationDto) {
		
		//BasicDataMaster bs=new BasicDataMaster();
		//bs.setId(organizationDto.getId());
		
		String hql = "SELECT O FROM OrganizationData O WHERE O.id =: id and O.version =: version";
		Query query = getSession().createQuery(hql);
		query.setParameter("id",organizationDto.getId());
		query.setParameter("version", organizationDto.getVersion());
		
		ArrayList<OrganizationDto> l = new ArrayList<OrganizationDto>();
		List<OrganizationData> empList = query.list();
		for(OrganizationData emp : empList){
			System.out.println(emp);
			l.add(exportDto(emp));
		}
		return l;	
	}

	@Override
	protected OrganizationDataMaster importDto(OrganizationDto organizationDto) {
		
		OrganizationDataMaster entity = new OrganizationDataMaster();
		
		try{
		if( organizationDto != null)
		{
		 		
			BasicDataMaster basicDataMaster=new BasicDataMaster();
			basicDataMaster.setId(organizationDto.getId());
			
			entity.setId(basicDataMaster);
					
			entity.setAsset(organizationDto.getAsset());
			entity.setCatalogProfile(organizationDto.getCatalogProfile());
			entity.setCompanyCode(organizationDto.getCompanyCode());
			entity.setCostArea(organizationDto.getCostArea());
			entity.setMainWorkCenter(organizationDto.getMainWorkCenter());
			entity.setPlannerGroup(organizationDto.getPlannerGroup());
			entity.setMaintenancePlanningCenter(organizationDto.getMaintenancePlanningCenter());
			entity.setManufacturerSerialNo(organizationDto.getManufacturerSerialNo());
			entity.setPlantAssociated(organizationDto.getPlantAssociated());
			entity.setCurrencyKey(organizationDto.getCurrencyKey());
			entity.setBusinessArea(organizationDto.getBusinessArea());
			
			
		}
		}
		catch(Exception e)
		{
			System.out.println("oooooooo: "+e);
		}
		return entity;
	}
	
	
   protected OrganizationData importDtoStagged(OrganizationDto organizationDto) {
		
		OrganizationData entity = new OrganizationData();
		
		try{
		
		if( organizationDto != null)
		{
			
			/*BasicData basicData=new BasicData();
			EquipmentId equipmentId = new EquipmentId();
			equipmentId.setId(organizationDto.getId());
			equipmentId.setVersion(organizationDto.getVersion());
			
			entity.setEquipmentId(basicData); */
			
			entity.setId(organizationDto.getId());
			entity.setVersion(organizationDto.getVersion());
			entity.setAsset(organizationDto.getAsset());
			entity.setCatalogProfile(organizationDto.getCatalogProfile());
			entity.setCompanyCode(organizationDto.getCompanyCode());
			entity.setCostArea(organizationDto.getCostArea());
			entity.setMainWorkCenter(organizationDto.getMainWorkCenter());
			entity.setPlannerGroup(organizationDto.getPlannerGroup());
			entity.setMaintenancePlanningCenter(organizationDto.getMaintenancePlanningCenter());
			entity.setManufacturerSerialNo(organizationDto.getManufacturerSerialNo());
			entity.setPlantAssociated(organizationDto.getPlantAssociated());
			entity.setCurrencyKey(organizationDto.getCurrencyKey());
			entity.setBusinessArea(organizationDto.getBusinessArea());
			
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return entity;
	}
	
	

	protected OrganizationDto exportDto(OrganizationData organizationData) {
		
		OrganizationDto dto = null;
		
		if(organizationData != null)
		{
			dto = new OrganizationDto();
			dto.setId(organizationData.getId());
			dto.setVersion(organizationData.getVersion());
			dto.setAsset(organizationData.getAsset());
			dto.setCatalogProfile(organizationData.getCatalogProfile());
			dto.setCompanyCode(organizationData.getCompanyCode());
			dto.setCostArea(organizationData.getCostArea());
			dto.setMainWorkCenter(organizationData.getMainWorkCenter());
			dto.setPlannerGroup(organizationData.getPlannerGroup());
			dto.setMaintenancePlanningCenter(organizationData.getMaintenancePlanningCenter());
			dto.setBusinessArea(organizationData.getBusinessArea());
			dto.setCurrencyKey(organizationData.getCurrencyKey());
			dto.setPlantAssociated(organizationData.getPlantAssociated());
			dto.setManufacturerSerialNo(organizationData.getManufacturerSerialNo());
					
		}
		
		return dto;
	}
	
   protected OrganizationDto exportMasterDto(OrganizationDataMaster organizationData) {
		
		OrganizationDto dto = null;
		
		if(organizationData != null)
		{
			dto = new OrganizationDto();
			dto.setId(organizationData.getId().getId());
			dto.setAsset(organizationData.getAsset());
			dto.setCatalogProfile(organizationData.getCatalogProfile());
			dto.setCompanyCode(organizationData.getCompanyCode());
			dto.setCostArea(organizationData.getCostArea());
			dto.setMainWorkCenter(organizationData.getMainWorkCenter());
			dto.setPlannerGroup(organizationData.getPlannerGroup());
			dto.setMaintenancePlanningCenter(organizationData.getMaintenancePlanningCenter());
			dto.setBusinessArea(organizationData.getBusinessArea());
			dto.setCurrencyKey(organizationData.getCurrencyKey());
			dto.setPlantAssociated(organizationData.getPlantAssociated());
			dto.setManufacturerSerialNo(organizationData.getManufacturerSerialNo());
					
		}
		
		return dto;
	}


	@Override
	public ArrayList<OrganizationDto> listOrganizationMasterDataById(OrganizationDto organizationDto) {
		
		String hql = "SELECT O FROM OrganizationDataMaster O WHERE O.id.id =: id ";
		Query query = getSession().createQuery(hql);
		query.setParameter("id",organizationDto.getId());
		ArrayList<OrganizationDto> l = new ArrayList<OrganizationDto>();
		List<OrganizationDataMaster> empList = query.list();
		for(OrganizationDataMaster emp : empList){
			l.add(exportMasterDto(emp));
		}
		return l;	
		
	}


	
}
