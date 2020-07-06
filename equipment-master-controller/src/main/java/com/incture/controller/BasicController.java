package com.incture.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.dto.BasicDTO;
import com.incture.services.BasicServiceImpl;
import com.incture.utils.ResponseDto;


@RestController
@RequestMapping("/basic")
public class BasicController {
	
	@Autowired
	private BasicServiceImpl basicService;

	@GetMapping
	public String TestApi() {
		return "Done";
	}

	@PostMapping
	public ResponseDto saveBasicData(@RequestBody BasicDTO basicDto) {
		return basicService.saveBasicData(basicDto);

	}

}
