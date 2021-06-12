package setManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge721 {

	private String name = "721. Accounts Merge";
	private String url = "https://leetcode.com/problems/accounts-merge/";
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set<String>>> mergedAccounts = new HashMap<>();
        
        String accountName;
        List<Set<String>> accountsWithSameName;
        boolean hasMerged;
        for(List<String> account : accounts) {
        	hasMerged = false;
        	accountName = account.get(0);
        	if(!mergedAccounts.containsKey(accountName)) {
        		accountsWithSameName = new ArrayList<>();
        		accountsWithSameName.add(getEmails(account));
        		mergedAccounts.put(accountName, accountsWithSameName);
        		continue;
        	}
        	accountsWithSameName = mergedAccounts.get(accountName);
        	for(Set<String> emails : accountsWithSameName) {
        		if(checkRepeat(account, emails)) {
        			mergeSet(account, emails);
        			hasMerged = true;
        			break;
        		}
        	}
        	if(!hasMerged)
        		accountsWithSameName.add(getEmails(account));
        }
        
        List<List<String>> flattenAccounts = new ArrayList<>();
        for(Map.Entry<String, List<Set<String>>> entry : mergedAccounts.entrySet()) {
        	accountName = entry.getKey();
        	for(Set<String> emails : entry.getValue()) {
        		List<String> flattenAccount = new ArrayList<>();
        		flattenAccount.add(accountName);
        		for(String email : emails) {
        			flattenAccount.add(email);
        		}
        		flattenAccounts.add(flattenAccount);
        	}
        }
        
        return flattenAccounts;
    }
    
    private static Set<String> getEmails(List<String> account) {
    	int i=0;
    	Set<String> emails = new HashSet<>();
    	for(String email : account) {
    		if(i != 0)
    			emails.add(email);
    		i++;
    	}
    	
    	return emails;
    }
    
    private static boolean checkRepeat(List<String> account, Set<String> emails) {
    	int i=0;
    	for(String email : account) {
    		if(i != 0) {
    			if(emails.contains(email))
    				return true;
    		}
    		i++;
    	}
    	return false;
    }
    
    private static void mergeSet(List<String> account, Set<String> emails) {
    	int i=0;
    	for(String email : account) {
    		if(i != 0) {
    			emails.add(email);
    		}
    		i++;
    	}
    	return;
    }
    
}
