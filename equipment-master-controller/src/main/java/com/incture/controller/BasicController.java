package com.incture.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.incture.dto.FilterDto;
import com.incture.services.MainService;
import com.incture.utils.ResponseDto;
import com.incture.dto.AllDto;
import com.incture.dto.BasicDTO;


@RestController
@RequestMapping("/basic")
public class BasicController {
	
	
	@Autowired
	private MainService mainService;
	

	@GetMapping
	public String TestApi() {
		return "Done";
	}

	
	@GetMapping("/export-stagged-data")
	public void getDownloadStagged(HttpServletResponse response) throws IOException {
		
		FilterDto filterDto = new FilterDto();
		
		filterDto.setType(true);
		filterDto.setProcessed(true);
		
		filterDto.setT(1);
		
		mainService.readAllData(filterDto);
		
	    FileInputStream myStream = new FileInputStream(new File("StaggedData.xls"));

	    //response.addHeader("Content-disposition", "inline;filename=sample.txt");
	    //response.setContentType("txt/plain");
	    
	    response.addHeader("Content-disposition", "attachment;filename=StaggedData.xls");
	    response.setContentType("application/octet-stream");

	    // Copy the stream to the response's output stream.
	    IOUtils.copy(myStream, response.getOutputStream());
	    response.flushBuffer();
	}
	
	
	@GetMapping("/export-master-data")
	public void getDownloadMaster(HttpServletResponse response) throws IOException {


        FilterDto filterDto = new FilterDto();
		
        filterDto.setType(false);
		filterDto.setProcessed(true);
		filterDto.setUpdatePending(false);
		filterDto.setT(1);
		
		mainService.readAllData(filterDto);
		
		 //mainService.exportExcel(1);
	    FileInputStream myStream = new FileInputStream(new File("MasterData.xls"));

	    //response.addHeader("Content-disposition", "inline;filename=sample.txt");
	    //response.setContentType("txt/plain");
	    
	    response.addHeader("Content-disposition", "attachment;filename=MasterData.xls");
	    response.setContentType("application/octet-stream");

	    // Copy the stream to the response's output stream.
	    IOUtils.copy(myStream, response.getOutputStream());
	    response.flushBuffer();
	}
	
	@GetMapping("/category")
	public ResponseDto listCategory() {
		return mainService.myCategory();
	}
	
	@GetMapping("/sorting")
	public ResponseDto listSorting() {
		return mainService.mySortingData();
	}
	
	@PostMapping("/read-stagged-false")
	public ResponseDto createMasterStagged(@RequestBody FilterDto filterDto) {
		filterDto.setType(true);
		filterDto.setProcessed(false);
		return mainService.readAllData(filterDto);
	}
	
	
	
	@PostMapping("/read-stagged-all")
	public ResponseDto viewUpdateStagged(@RequestBody FilterDto filterDto) {
		filterDto.setType(true);
		filterDto.setProcessed(true);
		return mainService.readAllData(filterDto);

	}
	
	@PostMapping("/master-data-all")
	public ResponseDto listMasterDataFalse(@RequestBody FilterDto filterDto) {
		filterDto.setType(false);
		filterDto.setProcessed(true);
		filterDto.setUpdatePending(false);
		return mainService.readAllData(filterDto);

	}
	
	@PostMapping("/master-data-true")
	public ResponseDto listMasterDataTrue(@RequestBody FilterDto filterDto) {
		filterDto.setType(false);
		filterDto.setProcessed(true);
		filterDto.setUpdatePending(true);
		return mainService.readAllData(filterDto);

	}
	
	
	
	@PostMapping("/save-alldata")
	public ResponseDto saveAllData(@RequestBody AllDto allDto)
	{ 	
	   return mainService.saveStaggedData(allDto);
	}
	
	
	@PostMapping("/update-stagged-data")
	public ResponseDto updateAllData(@RequestBody AllDto allDto)
	{ 	
	   return mainService.updateAllData(allDto);
	}
	
	@PostMapping("/create-master-data")
	public ResponseDto updateCreateMasterData(@RequestBody AllDto allDto)
	{ 	
	   return mainService.createMasterData(allDto);
	}
	
	@PostMapping("/update-master-data")
	public ResponseDto updateMasterData(@RequestBody BasicDTO basicD)
	{ 	
	   return mainService.createMasterDataSync(basicD);
	}
	
	
	
}
