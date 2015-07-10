package com.paul.userimport.portlet;

import java.util.Locale;

import javax.portlet.ActionRequest;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.paul.userimport.portlet.model.UserBean;


public class UserServiceImpl {
  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

  /** Singleton instance. */
  private static UserServiceImpl INSTANCE = new UserServiceImpl();

  private UserServiceImpl() {
  }

  public static UserServiceImpl getInstance() {
    return INSTANCE;
  }

  public User addUser(final ActionRequest request,
                      final UserBean userBean) {
    User user = addLiferatUser(request, userBean);
    userBean.setLiferayUserId(user.getUserId());
    LOGGER.info("User: " + userBean.getFirstName() + " " + userBean.getLastName() + " was added to liferay.");
    return user;
  }

  private User addLiferatUser(final ActionRequest request,
                             final UserBean userBean) {
    User user = null;
    try {
      ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

      long creatorUserId = themeDisplay.getUserId(); // default liferay user
      long companyId = themeDisplay.getCompanyId(); // default company
      boolean autoPassword = false;
      String password1 = userBean.getPassword();
      String password2 = userBean.getPassword();
      boolean autoScreenName = false;
      String screenName = userBean.getUsername();
      String emailAddress = userBean.getEmail();
      long facebookId = 0;
      String openId = "";
      Locale locale = themeDisplay.getLocale();
      String firstName = userBean.getFirstName();
      String middleName = "";
      String lastName = userBean.getLastName();

      int prefixId = 0;

      int suffixId = 0;
      boolean male = userBean.isMale();

      int birthdayMonth = 5;
      int birthdayDay = 5;
      int birthdayYear = 1980;
      String jobTitle = "";

      long[] groupIds = null;
      long[] organizationIds = null;
      long[] roleIds = null;

      long[] userGroupIds = null;

      boolean sendEmail = false;

      ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

      user = UserLocalServiceUtil.addUser(creatorUserId,
                                          companyId,
                                          autoPassword,
                                          password1,
                                          password2,
                                          autoScreenName,
                                          screenName,
                                          emailAddress,
                                          facebookId,
                                          openId,
                                          locale,
                                          firstName,
                                          middleName,
                                          lastName,
                                          prefixId,
                                          suffixId,
                                          male,
                                          birthdayMonth,
                                          birthdayDay,
                                          birthdayYear,
                                          jobTitle,
                                          groupIds,
                                          organizationIds,
                                          roleIds,
                                          userGroupIds,
                                          sendEmail,
                                          serviceContext);

      user.setPasswordReset(false);
      user = UserLocalServiceUtil.updateUser(user);
      
      UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED);
    } catch (PortalException e) {
      LOGGER.error(e);
    } catch (SystemException e) {
      LOGGER.error(e);
    }
    return user;
  }

 

}
