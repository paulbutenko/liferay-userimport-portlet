package com.paul.userimport.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.paul.userimport.portlet.model.UserBean;


public class ImportPortlet extends MVCPortlet {
  private static Log LOG = LogFactoryUtil.getLog(ImportPortlet.class);
  

  public void processAction(javax.portlet.ActionRequest actionRequest,
                            javax.portlet.ActionResponse actionResponse) throws IOException, PortletException {
    UserServiceImpl usi = UserServiceImpl.getInstance();
    int count = 1; 
    LOG.info("---------------- Started import process. ----------------");
    UserCacheEngine userCacheEngine = UserCacheEngine.getInstance();
    
    LOG.info("Adding users to portal");
    List<UserBean> users = userCacheEngine.getUsers();
    
    for (UserBean user : users) {
      LOG.info("Processing " + count + " user. "  + user.getFirstName() + " " + user.getLastName());
      count = count + 1;
      usi.addUser(actionRequest, user);
    }
    LOG.info(users.size() + " Users were added to portal");
    
    
    LOG.info("---------------- Finished import process. ----------------");
  }
}