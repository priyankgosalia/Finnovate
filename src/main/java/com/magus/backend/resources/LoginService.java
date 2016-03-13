package com.magus.backend.resources;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.apache.logging.log4j.LogManager;
import com.magus.backend.model.LoginRequest;
import com.magus.backend.model.LoginResponse;
import com.magus.backend.model.UserBO;

@Path("/login")
public class LoginService extends AbstractService {
	private static final Logger logger = LogManager.getLogger(LoginService.class.getName());
	private static final String MSG_LOGIN_FAILED 				= "Login failed. Invalid username/password.";
	private static final String MSG_INSUFFICIENT_CREDENTIALS 	= "Insufficient credentials provided.";
	private static final String MSG_ACCOUNT_DISABLED		 	= "Sorry! Your account has been disabled.";
	private static final String MSG_DATABASE_ISSUE 				= "Login failed. Unable to connect to the Database.";
	
	private static final Map<String,UserBO> users = new HashMap<String,UserBO>();
	
	static {
		users.put("priyank", 	new UserBO("priyank","password","Priyank","Gosalia",true));
		users.put("ujjwal", 	new UserBO("ujjwal","password","Ujjwal","Jain",true));
		users.put("prajot", 	new UserBO("prajot","password","Prajot","Naik",true));
		users.put("puneet", 	new UserBO("puneet","password","Puneet","Khanna",true));
	}
	
	@POST
	@Path("auth")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse authenticate(LoginRequest request,
									@Context HttpServletRequest req) throws JSONException {
		final String username = request.getUsername();
		final String password = request.getPassword();
		LoginResponse response = null;
		if (username!=null && password!=null) {
			logger.info("Logging in User = '"+username+"' with Password = '"+password+"'");
			try {
				final UserBO u = users.get(username);
				if (u!=null) {
					// Check if user is allowed to Login
					if (u.isEnabled()) {
						if (password!=null && u.getPassword()!=null) {
							if (u.getPassword().equals(password)) {
								logger.info("Login successful for user '"+username+"'.");
								response = LoginResponse.getSuccessResponseWithMessage("Login successful for user '"+u.getUsername()+"'.");
								response.setUserFirstName(u.getFirstName());
								response.setUserId(u.getId());
								//req.getSession().setAttribute(ServiceConstants.SESSION_OBJ_CURRENT_USER_ID, u.getId());
								//req.getSession().setAttribute(ServiceConstants.SESSION_OBJ_CURRENT_USER_NAME, u.getUsername());
							} else {
								logger.error("Login failed for user '"+username+"' due to invalid password.");
								response = LoginResponse.getFailureResponseWithMessage(MSG_LOGIN_FAILED);
							}
						} else {
							logger.error("Either username or password is not correctly set in the database for user '"+username+"'.");
							response = LoginResponse.getFailureResponseWithMessage(MSG_LOGIN_FAILED);
						}
					} else {
						logger.warn("The account '"+u.getUsername()+"' has been disabled.");
						response = LoginResponse.getFailureResponseWithMessage(MSG_ACCOUNT_DISABLED);
					}
				} else {
					logger.error("Login failed for user '"+username+"' as user doesn't exist in the database.");
					response = LoginResponse.getFailureResponseWithMessage(MSG_LOGIN_FAILED);
				}
			} catch (Exception ex) {
				logger.error("Failed to query the database. "+ex.getMessage());
				response = LoginResponse.getFailureResponseWithMessage(MSG_DATABASE_ISSUE);
			}
		} else {
			logger.error("Username/Password is null in JSON Request");
			response = LoginResponse.getFailureResponseWithMessage(MSG_INSUFFICIENT_CREDENTIALS);
		}
		return response;
	}
}
