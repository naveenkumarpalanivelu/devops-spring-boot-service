package com.avaya.absa.service;

import java.util.*;
import com.avaya.absa.model.*;

public interface DNCRestService
{
    void insertSingleDNC(DNCUploadTable dncUploadTable);
//    
    void insertBulkDNC(List<DNCUploadTable> dncUploadList);
    
    boolean validateUser(DNCUserProfile dncUserProfile);
    
    List<DNCListTable> getDNCList();
}
