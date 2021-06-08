package com.bjsxt.service.impl;

import com.bjsxt.exception.UserNotFoundException;
import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.pojo.UsersExample;
import com.bjsxt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户登录业务层
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 用户登录
     * @param users
     * @return
     */
    @Override
    public Users userLogin(Users users) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(users.getUsername());
        criteria.andUserpwdEqualTo(users.getUserpwd());
        List<Users> list = this.usersMapper.selectByExample(usersExample);
        if (list == null || list.size() <= 0){
            throw new UserNotFoundException("用户名或密码有误");
        }
        return list.get(0);
    }
}
