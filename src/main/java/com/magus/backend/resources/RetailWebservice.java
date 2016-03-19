package com.magus.backend.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.magus.backend.client.LoanAPIClient;
import com.magus.backend.client.RetailAPIClient;
import com.magus.backend.model.AccountBalance;
import com.magus.backend.model.AccountSummary;
import com.magus.backend.model.BehaviourScore;
import com.magus.backend.model.BranchAtmLocator;
import com.magus.backend.model.LoanAccountSummary;
import com.magus.backend.model.TransactionHistory;

@Path("/retail")
public class RetailWebservice extends AbstractService {

	RetailAPIClient client = new RetailAPIClient();
	LoanAPIClient loanClient = new LoanAPIClient();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getResponse() {
		return "Successful";
	}
	
	@GET
	@Path("/accountSummary")
	@Produces(MediaType.APPLICATION_JSON)
	public AccountSummary getMessages(@QueryParam ("accountNumber") String accNo, @QueryParam("customerId") String custId) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.accountSummary(accNo, custId), AccountSummary.class);
	}
	
	@GET
	@Path("/balance")
	@Produces(MediaType.APPLICATION_JSON)
	public AccountBalance getAccountBalance(@QueryParam("accountNumber") String accNo) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.balanceEnquiry(accNo), AccountBalance.class);
	}
	
	@GET
	@Path("/miniStatement")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionHistory getMiniStetement(@QueryParam("accountNumber") String accNo) throws JsonParseException, JsonMappingException, IOException {
		return convertToJSON(client.miniStatement(accNo), TransactionHistory.class);
	}
	
	@GET
	@Path("/transactionHistoryNDays")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionHistory getTransactionHistoryNDays(@QueryParam("accountNumber") String accNo, @QueryParam("days") int days) throws JsonParseException, JsonMappingException, IOException {
		return convertToJSON(client.transactionHistoryNDays(accNo, days), TransactionHistory.class);
	}
	
	@GET
	@Path("/transactionHistoryInterval")
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionHistory getTransactionHistoryInterval(@QueryParam("accountNumber") String accNo, @QueryParam("fromDate") String fromDate, @QueryParam("toDate") String toDate) throws JsonParseException, JsonMappingException, IOException {
		return convertToJSON(client.transactionHistoryInterval(accNo, fromDate, toDate), TransactionHistory.class);
	}
	
	@GET
	@Path("/behaviourScore")
	@Produces(MediaType.APPLICATION_JSON)
	public BehaviourScore getBehaviourScore(@QueryParam("accountNumber") String accNo) throws JsonParseException, JsonMappingException, IOException {
		return convertToJSON(client.behaviourScore(accNo), BehaviourScore.class);
	}
	
	@GET
	@Path("/atmLocator")
	@Produces(MediaType.APPLICATION_JSON)
	public BranchAtmLocator getAtmLocator(@QueryParam("lat") String latitude, @QueryParam("long") String longitude) throws JsonParseException, JsonMappingException, IOException{
		return convertToJSON(client.branchAtmLocator(latitude, longitude), BranchAtmLocator.class);
	}
	
	@GET
	@Path("/loanAccountSummary/{input}")
	@Produces(MediaType.APPLICATION_JSON)
	public LoanAccountSummary getLoanAccountSummaryByLoanAccountNo(@PathParam("input") String input) throws JsonParseException, JsonMappingException, IOException{
		if (input.length() == 8) {
			return convertToJSON(loanClient.loanAccountSummaryByCustId(input), LoanAccountSummary.class);
		}
		else {
			return convertToJSON(loanClient.loanAccountSummaryByAccountNo(input), LoanAccountSummary.class);
		}
	}
	//custId
}
