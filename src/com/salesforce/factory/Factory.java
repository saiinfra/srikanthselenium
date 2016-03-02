package com.salesforce.factory;

import com.salesforce.ds.TestInformationDAO;
import com.salesforce.ds.TestMetadataLogDAO;
import com.salesforce.ds.TestScriptsDAO;
import com.salesforce.ds.TestScriptsResultsDAO;

public class Factory {

	public static Object getObjectInstance(String name) {
		Object obj = null;

		if (name.equals("TestMetadataLogDAO")) {
			return (new TestMetadataLogDAO());
		} else if (name.equals("TestScriptsDAO")) {
			return (new TestScriptsDAO());
		} else if (name.equals("TestScriptsResultsDAO")) {
			return (new TestScriptsResultsDAO());
		} else if (name.equals("TestInformationDAO")) {
			return (new TestInformationDAO());
		}
		return obj;
	}
}
