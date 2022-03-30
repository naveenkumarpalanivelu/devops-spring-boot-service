package com.avaya.absa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avaya.absa.constants.ApplicationConstant;
import com.avaya.absa.model.DNCUploadTable;
import com.avaya.absa.model.DNCUserProfile;
import com.avaya.absa.service.DNCRestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path ="/ABSA/absaservice")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AbsaRestServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(AbsaRestServiceController.class);
	
	@Autowired
    DNCRestService dncRestService;
	
	@PostMapping(path ="/SingleDNC", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertSingleDNC(@RequestBody String dncString) throws JsonProcessingException {
        log.info("# Inside insertSingleDNC #");
        DNCUploadTable dncObj = new ObjectMapper().readValue(dncString, DNCUploadTable.class);
        log.info("insertSingleDNC DNCObject {}", dncObj);
        dncRestService.insertSingleDNC(dncObj);
        log.info("insertSingleDNC result Success");
        return new ResponseEntity<>(getResponseStr(ApplicationConstant.REST_REQUEST_SUCCESS), HttpStatus.OK);
    }
    
    @PostMapping(path ="/BulkDNC" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertBulkDNC(@RequestBody String dncString) throws JsonProcessingException {
        log.info("# Inside insertBulkDNC #");
        List<DNCUploadTable> dncUploadList = new ObjectMapper().readValue(dncString,  new TypeReference<List<DNCUploadTable>>(){});
        if (dncUploadList != null) {
            log.info("insertSingleDNC DNCObject {}", dncUploadList.size());
            dncRestService.insertBulkDNC(dncUploadList);
            log.info("insertSingleDNC result Success");
        }
        return new ResponseEntity<>(getResponseStr(ApplicationConstant.REST_REQUEST_SUCCESS), HttpStatus.OK);
    }
    
    @PostMapping(path ="/UserLogin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> validateUserProfile(@RequestBody String dncUserProfile) throws JsonProcessingException {
        log.info("# Inside validateUserProfile #");
        DNCUserProfile dncUser = (DNCUserProfile)new ObjectMapper().readValue(dncUserProfile, DNCUserProfile.class);
        boolean isValid = dncRestService.validateUser(dncUser);
        log.info("User Validation {}", isValid);
        return new ResponseEntity<>(getResponseStr(isValid + ""), HttpStatus.OK);
    }
    
    @GetMapping(path ="/DNCList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDNCList() throws JsonProcessingException {
        log.info("# Inside getDNCList #");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(dncRestService.getDNCList());
        log.info("DNC List Response {}", jsonString);
        return new ResponseEntity<>(jsonString, HttpStatus.OK);
    }
    
    public String getResponseStr(String resp) {
        return "{\"Webservice_Response\":\"" + resp + "\"}";
    }

}
