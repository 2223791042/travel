package guet.hj.travel.service;

import guet.hj.travel.entity.Complaint;

import java.util.Date;
import java.util.List;

public interface ComplaintService {
    void saveComplaint(Complaint complaint);

    List<Complaint> getComplaintList(Date startTime, Date endTime, String title);

    Complaint getComplaint(Long complaintId);

    void delBatchComplaint(String id_str);

    void delComplaint(Long complaintId);
}
