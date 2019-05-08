package guet.hj.travel.service.impl;

import guet.hj.travel.dao.UserMapper;
import guet.hj.travel.entity.User;
import guet.hj.travel.entity.UserExample;
import guet.hj.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if(userList.size() != 0){
            return userList.get(0);
        }
        return null;
    }
}
