package com.pku.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pku.loadconfig.LoadConfig;

public class Driver {

	public static void main(String[] args) {
		Map<String, String> mapOfProperties = new HashMap(LoadConfig.instance().properties);
		
		MapLookup lookup = new MapLookupImpl();

		List<String> values = lookup.lookup("customer1.us.ca.*", mapOfProperties);

		System.out.println(values);
		
		
	}
	/*
	 * 	customer1.us.ca.*=server1
		customer2.us.*.*=server3
		customer2.*.*.*=server4
		*.*.*.*=server5
		customer1.us.ca.sjc=server2
		
		The following are the sample inputs and return values against the config file specified above:
		
		findRoute("customer1.us.ca.sfo") -> server1
		findRoute("customer1.us.ca.sjc") -> server2
		findRoute("customer2.us.tx.dfw") -> server3
		findRoute("customer2.cn.tw.tai") -> server4
		findRoute("customer10.us.ny.nyc") -> server5

	 */

}
