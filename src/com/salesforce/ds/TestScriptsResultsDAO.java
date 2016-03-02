package com.salesforce.ds;

import java.util.List;

import com.salesforce.domain.ResultInformationDO;
import com.salesforce.util.Constants;
import com.salesforce.util.SFoAuthHandle;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.soap.enterprise.sobject.Test_Script_Result__c;

public class TestScriptsResultsDAO {

	public TestScriptsResultsDAO() {
		super();
	}

	public List<Object> listAll(SFoAuthHandle sfHandle) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(ResultInformationDO obj, SFoAuthHandle sfHandle,
			String testscriptId, String testinformationid, String metadataLogId) {
		// create the records

		ResultInformationDO resultInformationDO = (ResultInformationDO) obj;

		Test_Script_Result__c[] record = new Test_Script_Result__c[1];

		// Get the name of the sObject
		Test_Script_Result__c a = new Test_Script_Result__c();
		a.setStatus__c(resultInformationDO.getStatus());
		a.setActual_Result__c(resultInformationDO.getType());
		a.setTimes_s__c(resultInformationDO.getTime());
		a.setTest_Information__c(testinformationid);
		a.setTest_Script__c(testscriptId);
		a.setTesting_MetadataLog__c(metadataLogId);
		// a.setTest_Steps__c(resultInformationDO.getTestcasename());
		// a.setStep__c(1.0);

		record[0] = a;
		commit(record, sfHandle);

		return true;
	}

	public boolean commit(SObject[] sobjects, SFoAuthHandle sfHandle) {
		try {
			com.sforce.soap.enterprise.UpsertResult[] saveResults = sfHandle
					.getEnterpriseConnection().upsert("Id", sobjects);

			for (UpsertResult r : saveResults) {
				if (r.isSuccess()) {
					System.out.println("Created TestResults  record - Id: "
							+ r.getId());
				} else {
					for (com.sforce.soap.enterprise.Error e : r.getErrors()) {
						throw new Exception(e.getMessage() + "-status code-"
								+ e.getStatusCode());
					}
					return false;
				}
			}
			System.out.println("saving TestResults :");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
