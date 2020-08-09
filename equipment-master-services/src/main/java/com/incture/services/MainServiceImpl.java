package com.incture.services;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dao.BasicDao;
import com.incture.dao.GeneralDao;
import com.incture.dao.LocationDao;
import com.incture.dao.OrganizationDao;
import com.incture.dto.AllDto;
import com.incture.dto.BasicDTO;
import com.incture.dto.FilterDto;
import com.incture.dto.GeneralDto;
import com.incture.dto.LocationDto;
import com.incture.dto.OrganizationDto;
import com.incture.utils.ResponseDto;

@Service
@Transactional
public class MainServiceImpl implements MainService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BasicDao basicDao;

	@Autowired
	private GeneralDao generalDao;

	@Autowired
	private LocationDao locationDao;

	@Autowired
	private OrganizationDao organizationDao;


	@Override
	public ResponseDto saveStaggedData(AllDto allDto) {
		
			logger.info("MainServiceImpl | saveAllData | Execution start input " + allDto);

			ResponseDto responseDto = new ResponseDto();
			responseDto.setStatus(Boolean.TRUE);
			responseDto.setStatusCode(200);

			try {
				/*
				String id = "ABCDEFGHIJK9871891AHKLSSLMNOPQRSTUVWXYZ0123456789ABCDEFGHZAS";
					   
				 List<String> letters = Arrays.asList(id.split(""));
				  Collections.shuffle(letters);
				  StringBuilder builder = new StringBuilder();
				  for (String letter : letters) {
				   builder.append(letter);
				  }
				  
				    String id1 =  builder.toString();
				
				    id = id1.substring(0,17);
				   
				  
				   
				    */
				 
				  BasicDTO basicDto = allDto.getBasicDetails();
				  GeneralDto generalDto = allDto.getGeneralDetails();
				  
				  BasicDTO bsT = basicDao.checkDataExist(basicDto, generalDto); 
				  
				  String id="";
				  int version = 1;
				  
				  if(bsT != null)
				  {
					  id = bsT.getId();
					  version=basicDao.getLastVersion(id,true);	 	  // here we have to use true and false value of is_processed flag
					  
				  }
				  else{
					  
					  id = basicDao.getLastId();
					  
					  version=basicDao.getLastVersion(id,true);	
				  }
				  
				  
				  
				  
				    
				   basicDto.setId(id);
				   basicDto.setVersion(version);
				   
				  
				   generalDto.setId(id);
				   generalDto.setVersion(version);
				   
				   List<LocationDto> locationList =allDto.getLocationList();
				   List<OrganizationDto> organizationList = allDto.getOrganizationList();
				   
				   System.out.println(locationList);
				   System.out.println(organizationList);
				   
				  basicDao.insertBasicData(basicDto);
				  generalDao.insertGeneralData(generalDto);
				  locationDao.insertLocationData(locationList,id,version);
				  organizationDao.insertOrganizationData(organizationList,id,version);
				  
				  if(version !=1)
				  {
					  FilterDto filterDto = new FilterDto();
					  filterDto.setId(id);
					  filterDto.setProcessed(false);
					  boolean check = basicDao.isIdExist(filterDto);
					  if(check == true){
						  basicDto.setUpdatePendiing(true);
					  basicDao.updateMasterData(basicDto);
					  }
				  }
				  
				  /*
				  organizationDao.insertOrganizationDataMaster(organizationList,id,version);
				  locationDao.insertLocationDataMaster(locationList,id,version);
				  generalDao.insertGeneralDataMaster(generalDto);
				  basicDao.insertBasicDataMaster(basicDto);
				  */
				  
				   
				  responseDto.setMessage("Equipment Details Saved Successfully with Id: " + id);

			} catch (Exception e) {

				logger.error("MainServiceImpl | saveAllData | Exception " + e.getMessage());
				responseDto.setStatus(Boolean.FALSE);
				responseDto.setStatusCode(500);
				responseDto.setMessage(e.getMessage());

			}

			logger.info("MainServiceImpl | saveAllData | Execution end ouput " + responseDto);

			return responseDto;
		}

	
	
	@Override
	public ResponseDto readAllData(FilterDto filterDto) {

		logger.info("MainServiceImpl | readAllData | Execution start input " + filterDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Boolean.TRUE);
		responseDto.setStatusCode(200);

		try {
			
			if(filterDto.isType() == true) // for stagged data
			{
					
				String id = filterDto.getId();
				
				if(id != null && id.isEmpty() == false)
				{
					int version = 0;
					
					if(filterDto.isProcessed() == false)
					{
						version=basicDao.getLastVersion(id,false);  // i will get all data with is_processed = false 
					}
					else
					{
						version=basicDao.getLastVersion(id,true);  // i will get all data 
					}
									
					
					if(version != 1)
					{
						version = version - 1;
					}
					else
					{
						responseDto.setMessage(
								"Equipment Data is not Exist for ID: " + filterDto.getId());
						responseDto.setData(null);
						return responseDto;
						
					}
					System.out.println(version);
					BasicDTO basicDto = new BasicDTO();
					basicDto.setId(id);
	 				basicDto.setVersion(version);
					
					BasicDTO l1 = basicDao.listBasicData(basicDto);

					GeneralDto generalDto = new GeneralDto();
					generalDto.setVersion(version);
					generalDto.setId(id);
					// generalDto.setVersion(basicDto.getVersion());

					LocationDto locationDto = new LocationDto();
					locationDto.setVersion(version);
					locationDto.setId(id);
					// locationDto.setVersion(basicDto.getVersion());

					OrganizationDto organizationDto = new OrganizationDto();
					organizationDto.setVersion(version);
					organizationDto.setId(id);
					// organizationDto.setVersion(basicDto.getVersion());

					GeneralDto l2 = generalDao.listGeneralDataById(generalDto);
					ArrayList<LocationDto> l3 = locationDao.listLocationStaggedDataById(locationDto);
					ArrayList<OrganizationDto> l4 = organizationDao.listOrganizationStaggedDataById(organizationDto);

					AllDto newList = new AllDto();
					newList.setBasicDetails(l1);
					newList.setGeneralDetails(l2);
					newList.setLocationList(l3);
					newList.setOrganizationList(l4);
					
					
					responseDto.setMessage("Equipment Details return Successfully by id: "+id);
					responseDto.setData(newList);
				}
				else{
					
					List<Object> l = basicDao.listBasicDataByFilterTwo(filterDto);
					
					if(filterDto.getT() == 1)
					{
						basicDao.insertIntoExcel(l);
					}
					
					responseDto.setMessage("Equipment Details return Successfully by filter....."); 
					responseDto.setData(l);
				}
				
				
			}
			else
			{
				String id = filterDto.getId();
				if(id != null && id.isEmpty() == false)
				{
				 
				   
				   boolean check = basicDao.isIdExist(filterDto);
					
					if(check == false)
					{
						responseDto.setMessage(
								"Equipment Master Data is not Exist for ID: " + filterDto.getId());
						responseDto.setData(null);
						return responseDto;
						
					}
				
					BasicDTO basicDto = new BasicDTO();
					basicDto.setId(id);
					

					GeneralDto generalDto = new GeneralDto();
					generalDto.setId(id);

					LocationDto locationDto = new LocationDto();
					locationDto.setId(id);
				
					OrganizationDto organizationDto = new OrganizationDto();
					organizationDto.setId(id);
					
					
					ArrayList<OrganizationDto> l4 = organizationDao.listOrganizationMasterDataById(organizationDto);
					ArrayList<LocationDto> l3 = locationDao.listLocationMasterDataById(locationDto);
					GeneralDto l2 = generalDao.listGeneralMasterById(generalDto);
					BasicDTO l1 = basicDao.listMasterData(basicDto);

					AllDto newList = new AllDto();
					newList.setBasicDetails(l1);
					newList.setGeneralDetails(l2);
					newList.setLocationList(l3);
					newList.setOrganizationList(l4);
					
					responseDto.setMessage("Equipment Master Details return Successfully by id: "+id);
					responseDto.setData(newList);
				}
				else{
				
					
					List<Object> l = basicDao.listBasicDataByFilterTwo(filterDto);
					responseDto.setMessage("Equipment Master Details return Successfully by filter....."); 
					responseDto.setData(l);
				}
				
				
			}
			
			
		} catch (Exception e) {

			logger.error("MainServiceImpl | readAllData| Exception " + e.getMessage());
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());

		}

		logger.info("MainServiceImpl | readAllData | Execution end ouput " + responseDto);

		return responseDto;

	}


	@Override
	public ResponseDto updateAllData(AllDto allDto) {
		
		logger.info("MainServiceImpl | updateAllData | Execution start input " + allDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Boolean.TRUE);
		responseDto.setStatusCode(200);

		try {
			   BasicDTO basicDto = allDto.getBasicDetails();
			   
			   String id = basicDto.getId();
			   
			   int version=basicDao.getLastVersion(id,true);	 
			  
			   basicDto.setVersion(version);
			   GeneralDto generalDto = allDto.getGeneralDetails();
			   generalDto.setId(id);
			   generalDto.setVersion(version);
			   
			   List<LocationDto> locationList =allDto.getLocationList();
			   List<OrganizationDto> organizationList = allDto.getOrganizationList();
			   
			   System.out.println(locationList);
			   System.out.println(organizationList);
			   
			  
			  
			   
			  basicDao.insertBasicData(basicDto);
			  generalDao.insertGeneralData(generalDto);
			  locationDao.insertLocationData(locationList,id,version);
			  organizationDao.insertOrganizationData(organizationList,id,version);
			  
			  /*
			  FilterDto filterDto = new FilterDto();
			  filterDto.setId(id);
			  filterDto.setProcessed(false);
			  
			  
			  /*
			  boolean check = basicDao.isIdExist(filterDto);
			  
			  if(check == true){
			 
				  basicDto.setUpdatePendiing(true);
				  basicDao.updateMasterData(basicDto);
				  
			  }
				  */
			  
			  
			  /*
			  organizationDao.insertOrganizationDataMaster(organizationList,id,version);
			  locationDao.insertLocationDataMaster(locationList,id,version);
			  generalDao.insertGeneralDataMaster(generalDto);
			  basicDao.insertBasicDataMaster(basicDto);
			  */
			  
			   
			  responseDto.setMessage("Equipment Details Updated Successfully with Id: " + id);

		} catch (Exception e) {

			logger.error("MainServiceImpl | updateAllData | Exception " + e.getMessage());
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());

		}

		logger.info("MainServiceImpl | updateAllData | Execution end ouput " + responseDto);

		return responseDto;
	}

	@Override
	public ResponseDto createMasterData(AllDto allDto) {
		
		logger.info("MainServiceImpl | updateMasterData | Execution start input " + allDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Boolean.TRUE);
		responseDto.setStatusCode(200);

		try {
			   
			
			
			  BasicDTO basicDto = allDto.getBasicDetails();
			  GeneralDto generalDto = allDto.getGeneralDetails();
			  List<LocationDto> locationList =allDto.getLocationList();
			  List<OrganizationDto> organizationList = allDto.getOrganizationList();
			  
			  System.out.println("ggggggggggggggggggggggg :  "+generalDto );
			
			
			   String id = basicDto.getId();
			   
			   int version=basicDao.getLastVersion(id,false);	
			   
			   if(version !=1)
			   {
				   version = version -1;
			   }
			  
			   basicDto.setVersion(version);
			   
			   basicDao.updateBasicData(basicDto);
			   
			  
			  
				   FilterDto filterDto = new FilterDto();
				   filterDto.setId(id);
				   filterDto.setProcessed(false);
			       boolean check = basicDao.isIdExist(filterDto);
			       
			       if(check == true)
			       {
				      basicDto.setUpdatePendiing(true);
				      basicDao.updateMasterData(basicDto);	   
				   
			       }
			       else
			       {
				   version = 1;
				   basicDto.setVersion(1);
				   generalDto.setVersion(1);
				   generalDto.setId(id);
				   
				   basicDto.setUpdatePendiing(false);
				   organizationDao.insertOrganizationDataMaster(organizationList,id,version);
				   locationDao.insertLocationDataMaster(locationList,id,version);
				   generalDao.insertGeneralDataMaster(generalDto);
				   basicDao.insertBasicDataMaster(basicDto);
			       }
				
			  
			  responseDto.setMessage("Equipment Master Details Saved Successfully with Id: " + basicDto.getId());

		} catch (Exception e) {

			logger.error("MainServiceImpl | saveMasterData | Exception " + e.getMessage());
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());

		}

		logger.info("MainServiceImpl | saveMasterData | Execution end ouput " + responseDto);

		return responseDto;
		
	}

	@Override
	public ResponseDto createMasterDataSync(BasicDTO basicD) {
		
		logger.info("MainServiceImpl | syncMasterData | Execution start input " + basicD.getId());

		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Boolean.TRUE);
		responseDto.setStatusCode(200);

		try {
			   

			String id=basicD.getId();
			
			int  version=basicDao.getLastVersion(id,true);
			
			System.out.println("vvvvvvvvvv : "+ version);
			
			if(version != 1)
			{
				version = version - 1;
			}
			else
			{
				System.out.println("----------------------------------"+version);
				responseDto.setMessage("Equipment Master not exist with Id: " + id);
				return responseDto;
			}
			
			BasicDTO basicDto = new BasicDTO();
			basicDto.setId(id);
			basicDto.setVersion(version);
			
			
			BasicDTO l1 = basicDao.listBasicData(basicDto);
			
			basicDto.setUpdatePendiing(false);

			GeneralDto generalDto = new GeneralDto();
			generalDto.setVersion(version);
			generalDto.setId(id);

			LocationDto locationDto = new LocationDto();
			locationDto.setVersion(version);
			locationDto.setId(id);

			OrganizationDto organizationDto = new OrganizationDto();
			organizationDto.setVersion(version);
			organizationDto.setId(id);
		

			GeneralDto l2 = generalDao.listGeneralDataById(generalDto);
			List<LocationDto> l3 = locationDao.listLocationStaggedDataById(locationDto);
			List<OrganizationDto> l4 = organizationDao.listOrganizationStaggedDataById(organizationDto);
			
			/* String hqlUpdate = "UPDATE User SET loginDate= CURRENT_TIMESTAMP, loginAttempts=(SELECT COUNT(*) FROM loginHistory WHERE user_id=:user_id AND response!=:response AND TIMESTAMPDIFF(MINUTE,valTime,CURRENT_TIMESTAMP) <= 30*24*60) WHERE user_id=:user_id";
		     int updatedEntities = session.createQuery( hqlUpdate )
		              .setParameter("user_id", user_id)
		              .setParameter("response", "OK")
		              .executeUpdate();
			*/
			
			  version = 0; 
			  
			  l2.setVersion(version);
			  l1.setVersion(version);
			  
			  l1.setId(id);
			  l2.setId(id);
			  
			 
			  
			  
			  organizationDao.insertOrganizationDataMaster(l4, id, version);
			  locationDao.insertLocationDataMaster(l3,id,version);
			  generalDao.insertGeneralDataMaster(l2);
			  basicDao.insertBasicDataMaster(l1);
			  
			 
			
			
			  
			  responseDto.setMessage("Equipment Master Details Sync Successfully with Id: " + id);

		} catch (Exception e) {

			logger.error("MainServiceImpl | syncMasterData | Exception " + e.getMessage());
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());

		}

		logger.info("MainServiceImpl | syncMasterData | Execution end ouput " + responseDto);

		return responseDto;
		
	}



	
	

}
