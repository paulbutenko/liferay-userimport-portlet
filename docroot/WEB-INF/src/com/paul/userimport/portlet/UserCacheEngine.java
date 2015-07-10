package com.paul.userimport.portlet;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.paul.userimport.portlet.model.UserBean;

public class UserCacheEngine {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger
			.getLogger(UserCacheEngine.class);

	private UserCSVReader userReader = UserCSVReader.getInstance();

	private List<UserBean> users = new ArrayList<UserBean>();

	private static UserCacheEngine INSTANCE = new UserCacheEngine();

	private UserCacheEngine() {
		init();
	}

	private void init() {
		LOGGER.info("Initialising users.");
		users = userReader.readUsers();
	}

	public static UserCacheEngine getInstance() {
		return INSTANCE;
	}

	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}

}
