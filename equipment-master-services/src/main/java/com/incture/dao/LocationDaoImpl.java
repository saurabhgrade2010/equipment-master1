package com.incture.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.dto.LocationDto;
import com.incture.entities.BasicDataMaster;
import com.incture.entities.LocationData;
import com.incture.entities.LocationDataMaster;

@SuppressWarnings("deprecation")
@Repository("LocationDaoImpl")
public class LocationDaoImpl extends BaseDao<LocationDataMaster,LocationDto> implements LocationDao{

	@Override
	public void insertLocationData(List<LocationDto> locationList,String id,int version) {
		
		
		
		for(LocationDto locationDto : locationList)
		{
			locationDto.setId(id);
			locationDto.setVersion(version);
			getSession().save(importDtoStagged(locationDto));	
		}
        
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public void insertLocationDataMaster(List<LocationDto> locationList,String id,int version) {
		
		    try{
			
		    	  if(version == 0)
		    	  {
		    		  
		    		  String hql = "delete from LocationDataMaster conc where conc.id.id= :id";
		    		  Query query = getSession().createQuery(hql);
		    		  
		    		  query.setParameter("id",id);
		    		  
		    		  query.executeUpdate();
		    		  
		    		  
		    		  
		    		  for(LocationDto locationDto : locationList)
						{
							locationDto.setId(id);
							getSession().save(importDto(locationDto));
						}	  
		    		  System.out.println("update location master table....." );
		    	  }
		    	  else
		    	  {
		    		  for(LocationDto locationDto : locationList)
						{
							locationDto.setId(id);
							getSession().save(importDto(locationDto));
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
	public ArrayList<LocationDto> listLocationStaggedDataById(LocationDto locationDto) {
		
		
		
		
		String hql = "SELECT conc FROM LocationData conc WHERE conc.id =: id and conc.version =: version";
		Query query = getSession().createQuery(hql);
		query.setParameter("id",locationDto.getId());
		query.setParameter("version", locationDto.getVersion());
		
		ArrayList<LocationDto> l = new ArrayList<LocationDto>();
		List<LocationData> empList = query.list();
		
		for(LocationData emp : empList){
			l.add(exportDto(emp));
		}
		return l;	
     
		
	}

	@Override
	protected LocationDataMaster importDto(LocationDto locationDto) {
		
		LocationDataMaster entity =  new LocationDataMaster();
		
		try{
		if (locationDto != null) {
			
			
			BasicDataMaster basicDataMaster=new BasicDataMaster();
			basicDataMaster.setId(locationDto.getId());
			
			entity.setId(basicDataMaster);
			
			entity.setAbcIndicator(locationDto.getAbcIndicator());
			entity.setLocation(locationDto.getLocation());
			entity.setMaintenancePlant(locationDto.getMaintenancePlant());
			entity.setPlantSection(locationDto.getPlantSection());
			entity.setRoom(locationDto.getRoom());
			entity.setSortField(locationDto.getSortField());
			entity.setFax(locationDto.getFax());
			entity.setTelephone(locationDto.getTelephone());
			entity.setStreet(locationDto.getStreet());
			entity.setName(locationDto.getName());
			entity.setWorkCenter(locationDto.getWorkCenter());
			
			
		}
		}
		catch(Exception e)
		{
		  System.out.println(e);
		}
		
		return entity;
	}

	
    protected LocationData importDtoStagged(LocationDto locationDto) {
		
		LocationData entity = new LocationData();
		
		try{
		  
			if (locationDto != null) {
			
			//BasicData basicData=new BasicData();
			//EquipmentId equipmentId = new EquipmentId();
			//equipmentId.setId(locationDto.getId());
			//equipmentId.setVersion(locationDto.getVersion());
			
			//entity.setEquipmentId(basicData);
			
			entity.setId(locationDto.getId());
			entity.setVersion(locationDto.getVersion());
			entity.setAbcIndicator(locationDto.getAbcIndicator());
			entity.setLocation(locationDto.getLocation());
			entity.setMaintenancePlant(locationDto.getMaintenancePlant());
			entity.setPlantSection(locationDto.getPlantSection());
			entity.setRoom(locationDto.getRoom());
			entity.setSortField(locationDto.getSortField());
			entity.setFax(locationDto.getFax());
			entity.setTelephone(locationDto.getTelephone());
			entity.setStreet(locationDto.getStreet());
			entity.setName(locationDto.getName());
			entity.setWorkCenter(locationDto.getWorkCenter());
			
			
		   }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return entity;
	}
	
	
	protected LocationDto exportDto(LocationData locationData) {
		// TODO Auto-generated method stub
		
		LocationDto dto = null;
		if(locationData != null)
		{
			dto = new LocationDto();
			dto.setId(locationData.getId());
			dto.setVersion(locationData.getVersion());
			dto.setAbcIndicator(locationData.getAbcIndicator());
			dto.setLocation(locationData.getLocation());
			dto.setMaintenancePlant(locationData.getMaintenancePlant());
			dto.setPlantSection(locationData.getPlantSection());
			dto.setRoom(locationData.getRoom());
			dto.setSortField(locationData.getSortField());
			dto.setStreet(locationData.getStreet());
			dto.setFax(locationData.getFax());
			dto.setTelephone(locationData.getTelephone());
			dto.setName(locationData.getName());
			dto.setWorkCenter(locationData.getWorkCenter());	
			
		}
		return dto;
	}



	protected LocationDto exportMasterDto(LocationDataMaster locationData) {
		// TODO Auto-generated method stub
		
		LocationDto dto = null;
		if(locationData != null)
		{
			dto = new LocationDto();
			dto.setId(locationData.getId().getId());
			dto.setAbcIndicator(locationData.getAbcIndicator());
			dto.setLocation(locationData.getLocation());
			dto.setMaintenancePlant(locationData.getMaintenancePlant());
			dto.setPlantSection(locationData.getPlantSection());
			dto.setRoom(locationData.getRoom());
			dto.setSortField(locationData.getSortField());
			dto.setStreet(locationData.getStreet());
			dto.setFax(locationData.getFax());
			dto.setTelephone(locationData.getTelephone());
			dto.setName(locationData.getName());
			dto.setWorkCenter(locationData.getWorkCenter());	
			
		}
		return dto;
	}


	@Override
	public ArrayList<LocationDto> listLocationMasterDataById(LocationDto locationDto) {
		
		String hql = "SELECT conc FROM LocationDataMaster conc WHERE conc.id.id =: id ";
		Query query = getSession().createQuery(hql);
		query.setParameter("id",locationDto.getId());
	
		ArrayList<LocationDto> l = new ArrayList<LocationDto>();
		List<LocationDataMaster> empList = query.list();
		
		for(LocationDataMaster emp : empList){
			l.add(exportMasterDto(emp));
		}
		return l;	
		
		
	}

	


}
