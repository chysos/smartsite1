package com.xingyun.smartsite.service;

import com.xingyun.smartsite.model.ProcessReason;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User:崔弘杨
 * Date:2017/10/12
 * Time:17:19
 */
@Service
public interface ProcessReasonService {
    List<ProcessReason> getTestProcessReasonInfo(ProcessReason processReason) throws Exception;

    void updateProcessReasonInfo(ProcessReason processReason) throws Exception;

    void deleteReasonInfo(String mydata)throws Exception;

    void creatProcessReasonInfo(ProcessReason processReason);

    ProcessReason getTestOneProcessReasonInfo(ProcessReason processReason)throws Exception;
}
