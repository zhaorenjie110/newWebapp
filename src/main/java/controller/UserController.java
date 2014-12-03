package controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;


	@RequestMapping("/getAllUser")
	public String getAllUser(HttpServletRequest request) {
		request.setAttribute("userList",userService.getAll(User.class));
		request.setAttribute("user", "test");
		return "index";
	}

	@RequestMapping("/getUser")
	public String getUser(String id, HttpServletRequest request) {
		request.setAttribute("user", userService.get(User.class,id));
		return "/editUser";
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(User user, HttpServletRequest request) {
		userService.save(user);
		return "redirect:/user/getAllUser";
	}

	@RequestMapping("/delUser")
	@ResponseBody
	public Map<String, String> delUser(String id, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		if(id==null){
			map.put("success","fail");
			return map;
		}

		String result = "";

		userService.deleteEntityById(User.class,id);

		result = "success";

		map.put("result", result);
		return map;

	}

	@RequestMapping("/updateUser")
	public String updateUser(User user, HttpServletRequest request) {
		if(user == null){
			return "/error";
		}
		userService.saveOrUpdate(user);
		request.setAttribute("user", user);
		return "redirect:/user/getAllUser";

	}


	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
