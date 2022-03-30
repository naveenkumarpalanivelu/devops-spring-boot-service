package com.avaya.absa.repository;

import org.springframework.data.repository.*;
import com.avaya.absa.model.*;

public interface DNCRepository extends CrudRepository<DNCUploadTable, Long>
{
}
