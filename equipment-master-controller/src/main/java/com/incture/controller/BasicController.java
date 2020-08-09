package com.incture.controller;

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

	
	
	@PostMapping("/read-stagged-false")
	public ResponseDto createMasterStagged(@RequestBody FilterDto filterDto) {
		filterDto.setType(true);
		filterDto.setProcessed(false);
		return mainService.readAllData(filterDto);
	}
	
	
	@PostMapping("/insert-into-excel")
	public ResponseDto insertIntoExcel(@RequestBody FilterDto filterDto) {
		filterDto.setType(true);
		filterDto.setProcessed(false);
		filterDto.setT(1);
		return mainService.readAllData(filterDto);
	}
	
	
	@PostMapping("/read-stagged-all")
	public ResponseDto viewUpdateStagged(@RequestBody FilterDto filterDto) {
		filterDto.setType(true);
		filterDto.setProcessed(true);
		return mainService.readAllData(filterDto);

	}
	
	@PostMapping("/master-data-false")
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
