package guet.hj.travel.service.impl;

import guet.hj.travel.dao.ComplaintMapper;
import guet.hj.travel.entity.Complaint;
import guet.hj.travel.entity.ComplaintExample;
import guet.hj.travel.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintMapper complaintMapper;

    @Transactional
    @Override
    public void saveComplaint(Complaint complaint) {
        complaint.setComplaintTime(new Date());
        complaintMapper.insertSelective(complaint);
    }

    @Override
    public List<Complaint> getComplaintList(Date startTime, Date endTime, String title) {
        ComplaintExample example = new ComplaintExample();
        ComplaintExample.Criteria criteria = example.createCriteria();
        if (startTime != null){
            criteria.andComplaintTimeGreaterThanOrEqualTo(startTime);
        }
        if (endTime != null){
            criteria.andComplaintTimeLessThanOrEqualTo(endTime);
        }
        if (title != null && !title.trim().equals("")){
            criteria.andTitleLike("%"+title+"%");
        }
        return complaintMapper.selectByExample(example);
    }

    @Override
    public Complaint getComplaint(Long complaintId) {
        return complaintMapper.selectByPrimaryKey(complaintId);
    }

    @Transactional
    @Override
    public void delBatchComplaint(String id_str) {
        String[] ids = id_str.split(",");
        ArrayList<Long> idList = new ArrayList<>();
        for (String id : ids){
            idList.add(Long.parseLong(id));
        }
        ComplaintExample example = new ComplaintExample();
        ComplaintExample.Criteria criteria = example.createCriteria();
        criteria.andComplaintIdIn(idList);
        complaintMapper.deleteByExample(example);
    }

    @Transactional
    @Override
    public void delComplaint(Long complaintId) {
        complaintMapper.deleteByPrimaryKey(complaintId);
    }
}
