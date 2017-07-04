package cn.zqx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zqx.dao.UserDao;
import cn.zqx.entity.User;
import cn.zqx.util.NoteUtil;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;

	public User Login(String name, String password) throws NameException, PasswordException {
		if(name==null||name.trim().isEmpty()){
			throw new NameException("用户名不能为空");
		}
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		User user = userDao.findByName(name);
		if(user==null){
			throw new NameException("用户名错误");
		}
		if(user.getPassword().equals(NoteUtil.md5(password))){
			return user;
		}else{
			throw new PasswordException("密码错误");
		}
		
	}

}
