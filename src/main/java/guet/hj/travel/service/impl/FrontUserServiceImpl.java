package guet.hj.travel.service.impl;

import guet.hj.travel.dao.FrontUserMapper;
import guet.hj.travel.entity.FrontUser;
import guet.hj.travel.entity.FrontUserExample;
import guet.hj.travel.service.FrontUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FrontUserServiceImpl implements FrontUserService {
    @Autowired
    private FrontUserMapper frontUserMapper;

    @Override
    public FrontUser getFrontUser(String userPhone) {
        FrontUserExample example = new FrontUserExample();
        FrontUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        List<FrontUser> frontUserList = frontUserMapper.selectByExample(example);
        if (frontUserList.size() != 0){
            return frontUserList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void saveFrontUser(FrontUser frontUser) {
        frontUserMapper.insertSelective(frontUser);
    }
}
