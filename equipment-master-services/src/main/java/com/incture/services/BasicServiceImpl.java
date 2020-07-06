package com.incture.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.incture.dao.BasicDao;
import com.incture.dto.BasicDTO;
import com.incture.utils.ResponseDto;;

@Service
@Transactional
public class BasicServiceImpl implements BasicService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BasicDao basicDao;

	@Override
	public ResponseDto saveBasicData(BasicDTO basicDto) {
		logger.info("BasicServiceImpl | saveBasicData | Execution start input " + basicDto);

		ResponseDto responseDto = new ResponseDto();
		responseDto.setStatus(Boolean.TRUE);
		responseDto.setStatusCode(200);

		try {
			basicDao.saveBasicData(basicDto);

			responseDto.setMessage("Employee Details Saved Successfully");

		} catch (Exception e) {

			logger.error("BasicServiceImpl | saveBasicData | Exception " + e.getMessage());
			responseDto.setStatus(Boolean.FALSE);
			responseDto.setStatusCode(500);
			responseDto.setMessage(e.getMessage());

		}

		logger.info("BasicServiceImpl | saveBasicData | Execution end ouput " + responseDto);

		return responseDto;
	}

}
