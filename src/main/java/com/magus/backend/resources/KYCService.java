package com.magus.backend.resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.magus.backend.model.KYCResponse;
import com.magus.backend.model.OTPResponse;

@Path("/kyc")
public class KYCService {
	private static final String DEFAULT_OTP = "123456";
	private static final Logger logger = LogManager.getLogger(KYCService.class.getName());
	
	@GET
	@Path("/otp")
	@Produces(MediaType.APPLICATION_JSON)
	public OTPResponse getOTP(@QueryParam("aadhar") String aadhar){
		logger.info("Received OTP request for Aadhar: "+aadhar);
		return new OTPResponse(DEFAULT_OTP);	
	}
	
	@PUT
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public KYCResponse authenticatWithOTP(@QueryParam("aadhar") String aadhar,@QueryParam("otp") String otp){
		logger.info("Received Aadhar auth request for Aadhar: "+aadhar);
		return KYCResponse.getSuccessResponseWithMessage("KYC Successful for Aadhar: "+aadhar);	
	}
}
