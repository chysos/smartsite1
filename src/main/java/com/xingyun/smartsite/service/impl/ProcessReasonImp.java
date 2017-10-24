package com.xingyun.smartsite.service.impl;

import com.xingyun.smartsite.dao.ProcessReasonDao;
import com.xingyun.smartsite.model.ProcessReason;
import com.xingyun.smartsite.service.ProcessReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User:崔弘杨
 * Date:2017/10/12
 * Time:17:35
 */
@Service
public class ProcessReasonImp implements ProcessReasonService {
    @Autowired
    ProcessReasonDao dao;
    @Override
    public List<ProcessReason> getTestProcessReasonInfo(ProcessReason processReason) throws Exception {
        return dao.getTestProcessReasonInfo(processReason);
    }

    @Override
    public void updateProcessReasonInfo(ProcessReason processReason) throws Exception {
     dao.updateProcessReasonInfo(processReason);
    }

    @Override
    public void deleteReasonInfo(String mydata) throws Exception {
        String[] str = mydata.split(",");
        for(int i =0;i<str.length;i++){
            ProcessReason processReason = new ProcessReason();

            processReason.setId( Integer.parseInt(str[i]));

            dao.deleteReasonInfo(processReason);
        }


    }

    @Override
    public void creatProcessReasonInfo(ProcessReason processReason) {
        dao.creatProcessReasonInfo(processReason);
    }

    @Override
    public ProcessReason getTestOneProcessReasonInfo(ProcessReason processReason) throws Exception {
        return dao.getTestOneProcessReasonInfo(processReason);
    }
}
