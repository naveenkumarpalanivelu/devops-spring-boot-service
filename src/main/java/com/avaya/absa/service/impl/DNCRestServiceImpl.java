package com.avaya.absa.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avaya.absa.model.DNCListTable;
import com.avaya.absa.model.DNCUploadTable;
import com.avaya.absa.model.DNCUserProfile;
import com.avaya.absa.repository.DNCListRepository;
import com.avaya.absa.repository.DNCRepository;
import com.avaya.absa.repository.DNCUserRepository;
import com.avaya.absa.service.DNCRestService;

@Service
public class DNCRestServiceImpl implements DNCRestService
{
    private static final Logger log = LoggerFactory.getLogger(DNCRestServiceImpl.class);
    @Autowired
    DNCRepository dncRepository;
    @Autowired
    DNCUserRepository dncUserRepository;
    @Autowired
    DNCListRepository dncListRepository;
    
    @Override
    public void insertSingleDNC(DNCUploadTable dncUploadTable) {
        log.info("# Service insertSingleDNC #");
        this.dncRepository.save(dncUploadTable);
    }
    
    @Override
    public void insertBulkDNC(List<DNCUploadTable> dncUploadList) {
        log.info("# Service insertBulkDNC #");
        this.dncRepository.saveAll(dncUploadList);
    }
    
    @Override
    public boolean validateUser(DNCUserProfile dncUserProfile) {
        log.info("# Service validateUser #");
        boolean isValid = false;
        Optional<DNCUserProfile> dncUsr = dncUserRepository.findById(dncUserProfile.getUserName());
        //DNCUserProfile dncUsr = dncUserRepository.findByCollateId(dncUserProfile.getUserName());
        //if (dncUsr != null && dncUsr.getUserPassword().equals(dncUserProfile.getUserPassword())) {
        if (dncUsr.isPresent() && dncUsr.get().getUserPassword().equals(dncUserProfile.getUserPassword())) {
            isValid = true;
        }
        return isValid;
    }
    
    @Override
    public List<DNCListTable> getDNCList() {
        log.info("# Service getDNCList #");
        return (List<DNCListTable>)dncListRepository.findAll();
    }
    
}
