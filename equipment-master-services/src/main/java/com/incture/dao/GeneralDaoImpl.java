package com.incture.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.incture.dto.GeneralDto;
import com.incture.entities.BasicDataMaster;
import com.incture.entities.EquipmentId;
import com.incture.entities.GeneralData;
import com.incture.entities.GeneralDataMaster;

@SuppressWarnings("deprecation")
@Repository("GeneralDaoImpl")
public class GeneralDaoImpl extends BaseDao<GeneralDataMaster,GeneralDto> implements GeneralDao{

	
	@Override
	public void insertGeneralData(GeneralDto generalDto) {
		getSession().save(importDtoStagged(generalDto));
	}
	
	
	

	@Override
	public void insertGeneralDataMaster(GeneralDto generalDto) {
	
		try{
			
			if(generalDto.getVersion()==0)
			{
				System.out.println("update general master table....." );
				getSession().update(importDto(generalDto));
			}
			else
			{
				   getSession().save(importDto(generalDto));
			}
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public GeneralDto listGeneralDataById(GeneralDto generalDto) {
		
		GeneralDto generalDTO = new GeneralDto();
		
		String hql = "FROM GeneralData conc WHERE conc.equipmentId.id =: id and conc.equipmentId.version =: version ";
		Query query = getSession().createQuery(hql);
		query.setParameter("id",generalDto.getId());
		query.setParameter("version", generalDto.getVersion());
		query.setFirstResult(0);
		query.setMaxResults(1);

		List<GeneralData> empList = query.list();
		for(GeneralData emp : empList){
		    generalDTO = exportDto(emp);
		}
		return generalDTO;	
		
	}


	@Override
	protected GeneralDataMaster importDto(GeneralDto generalDto) {
		
		GeneralDataMaster entity = new GeneralDataMaster();
		try{
		if (generalDto != null) {
			
			
			
			BasicDataMaster basicDataMaster=new BasicDataMaster();
			basicDataMaster.setId(generalDto.getId());
			
			entity.setId(basicDataMaster);
			
			entity.setClassType(generalDto.getClassType());
			entity.setObjectType(generalDto.getObjectType());
			entity.setManufacturer(generalDto.getManufacturer());
			entity.setAcquistnValue(generalDto.getAcquistnValue());	
			
			
			
			Date date1=null;
			Date date2 = null;
			
			try{
			
			 String sDate1=generalDto.getAcquistnDate();
			 date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			try{ 
				 String sDate2=generalDto.getConstYrMonth();
				 date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			
			
			entity.setAcquistnDate(date1);
			entity.setWeight(generalDto.getWeight());
			entity.setSize(generalDto.getSize());
			entity.setManufacturerCountry(generalDto.getManufacturerCountry());
			entity.setManufacturerPartNo(generalDto.getManufacturerPartNo());
			entity.setConstYrMonth(date2);
			entity.setManufacturerNo(generalDto.getManufacturerNo());
			
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return entity;
	}

	
     protected GeneralData importDtoStagged(GeneralDto generalDto) {
		
		GeneralData entity = new GeneralData();
		try{
		if (generalDto != null) {
			
			//BasicData basicData=new BasicData();
			EquipmentId equipmentId = new EquipmentId();
			equipmentId.setId(generalDto.getId());
			equipmentId.setVersion(generalDto.getVersion());
			
			/*entity.setEquipmentId(basicData); */
			
			entity.setEquipmentId(equipmentId);
			
			entity.setClassType(generalDto.getClassType());
			entity.setObjectType(generalDto.getObjectType());
			entity.setManufacturer(generalDto.getManufacturer());
			entity.setAcquistnValue(generalDto.getAcquistnValue());	
			
			
			
			Date date1=null;
			Date date2 = null;
			
			try{
			
			 String sDate1=generalDto.getAcquistnDate();
			 date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			try{ 
				 String sDate2=generalDto.getConstYrMonth();
				 date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			
			
			entity.setAcquistnDate(date1);
			entity.setWeight(generalDto.getWeight());
			entity.setSize(generalDto.getSize());
			entity.setManufacturerCountry(generalDto.getManufacturerCountry());
			entity.setManufacturerPartNo(generalDto.getManufacturerPartNo());
			entity.setConstYrMonth(date2);
			entity.setManufacturerNo(generalDto.getManufacturerNo());
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return entity;
	}


	
	protected GeneralDto exportDto(GeneralData generalData) {
	    GeneralDto dto = null;
		if (generalData != null) {
			dto = new GeneralDto();
			
			dto.setId(generalData.getEquipmentId().getId());
			dto.setVersion(generalData.getEquipmentId().getVersion());
			
			dto.setClassType(generalData.getClassType());
			dto.setObjectType(generalData.getObjectType());
			dto.setManufacturer(generalData.getManufacturer());
			dto.setAcquistnValue(generalData.getAcquistnValue());
			
			String strDate1=null;
			String strDate2=null;
			try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
			strDate1 = dateFormat.format(generalData.getAcquistnDate());  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			try{
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
				strDate2 = dateFormat.format(generalData.getConstYrMonth());
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			
			dto.setAcquistnDate(strDate1);
			dto.setManufacturerCountry(generalData.getManufacturerCountry());
			dto.setManufacturerPartNo(generalData.getManufacturerPartNo());
			dto.setManufacturerNo(generalData.getManufacturerNo());
			dto.setConstYrMonth(strDate2);
			dto.setWeight(generalData.getWeight());
			dto.setSize(generalData.getSize());
			
			
			
		}
		return dto;
	}

	
	protected GeneralDto exportMasterDto(GeneralDataMaster generalData) {
	    GeneralDto dto = null;
		if (generalData != null) {
			dto = new GeneralDto();
			
			dto.setId(generalData.getId().getId());
			dto.setClassType(generalData.getClassType());
			dto.setObjectType(generalData.getObjectType());
			dto.setManufacturer(generalData.getManufacturer());
			dto.setAcquistnValue(generalData.getAcquistnValue());
			
			String strDate1=null;
			String strDate2=null;
			try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
			strDate1 = dateFormat.format(generalData.getAcquistnDate());  
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			try{
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
				strDate2 = dateFormat.format(generalData.getConstYrMonth());
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			
			dto.setAcquistnDate(strDate1);
			dto.setManufacturerCountry(generalData.getManufacturerCountry());
			dto.setManufacturerPartNo(generalData.getManufacturerPartNo());
			dto.setManufacturerNo(generalData.getManufacturerNo());
			dto.setConstYrMonth(strDate2);
			dto.setWeight(generalData.getWeight());
			dto.setSize(generalData.getSize());
			
			
			
		}
		return dto;
	}




	@Override
	public GeneralDto listGeneralMasterById(GeneralDto generalDto) {
      
		GeneralDto generalDTO = new GeneralDto();
		String hql = "select conc FROM GeneralDataMaster conc WHERE conc.id.id =: id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id",generalDto.getId());
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<GeneralDataMaster> empList = query.list();
		for(GeneralDataMaster emp : empList){
		    generalDTO = exportMasterDto(emp);
		}
		return generalDTO;	
		
	}

	

	

}
