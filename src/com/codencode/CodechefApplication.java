package com.codencode;

import java.util.List;


public class CodechefApplication {
	
	public static void main(String[] args) throws Exception
	{
		CodechefDataManager dataManager = new CodechefDataManager();
		
		dataManager.setUserId("waqar_ahmad224");
		System.out.println("loading...");
		
		List<String> solvedProblems = dataManager.getSolvedProblems();
		
		for(String code : solvedProblems)
			System.out.println(code);
		
		System.out.println(dataManager.fullySolvedCount());
		System.out.println(dataManager.partialSolvedCount());
	}
	
}
