package com.reporter.service;

import com.reporter.dao.ReportDao;
import com.reporter.entity.MailItem;
import com.reporter.entity.MailRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService{

    private final ReportDao reportDao;

    public ReportServiceImpl(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    public void getMail(Long id){
        Optional<MailRequest> mailRequest = reportDao.getMailRequests(id);
    }

    public void getMailByRequestId(Long id, String requestId){
        List<MailItem> mailItems = reportDao.getMailItemsByRequestUID(requestId, id);
    }

    public void getMailByConfigId(Long id, Long configId){
        List<MailItem> mailItems = reportDao.getMailItemsByMailConfigID(configId, id);
    }
}
