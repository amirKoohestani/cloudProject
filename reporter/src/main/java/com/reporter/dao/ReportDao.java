package com.reporter.dao;

import com.reporter.entity.MailItem;
import com.reporter.entity.MailRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportDao extends JpaRepository {

    @Query(
            value = "select n2mr from MailRequest n2mr join RequestModel n2r on n2mr.request.id = n2r.id where n2r.userId = :id"
    )
    Optional<MailRequest> getMailRequests(@Param("id") long id);

    @Query(
            value = "select item from MailItem item join MailRequest n2mr on n2mr.id = item.mailRequest.id join RequestModel n2r on n2mr.request.id = n2r.id where n2r.notificationId = :request_id and n2r.userId = :id"
    )
    List<MailItem> getMailItemsByRequestUID(@Param("request_id") String request_id, @Param("id") long id);

    @Query(
            value = "select item from MailItem item join MailRequest n2mr on n2mr.id = item.mailRequest.id join RequestModel n2r on n2mr.request.id = n2r.id where n2mr.mailConfig = :mail_config and n2r.userId = :id"
    )
    List<MailItem> getMailItemsByMailConfigID(@Param("mail_config") long configId, @Param("id") long id);
}
