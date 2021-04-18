package com.codencode;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CodechefDataManager {
	
	private Document doc;
	private String userId;
	
	CodechefDataManager()
	{
		this.userId = null;
	}
	
	CodechefDataManager(String userId) throws Exception
	{
		this.userId = userId;
		this.setUserId(userId);
	}
	
	public void setUserId(String userId) throws Exception
	{
		this.userId = userId;
		
		doc = Jsoup.connect("https://www.codechef.com/users/" + this.userId).timeout(5000).get();
		
		if(doc.baseUri().equals("https://www.codechef.com/"))
			throw new Exception("Wrong userId");
	}
	
	public int getUserCurrentRating()
	{
		Elements ratingDiv = doc.select("div.rating-number");
		return Integer.parseInt(ratingDiv.html());
	}
	
	
	public String getUserName()
	{
		Elements userNameDiv = doc.select("div.user-details-container header h2");
		
		return userNameDiv.html();
	}
	
	public List<String> getSolvedProblems()
	{
		Element elements = doc.select("section.problems-solved article").get(0);
		
		Elements solvedProblems = elements.select("p").get(0).select("span a");
		List<String> result = new ArrayList<>();
		
		for(Element ele : solvedProblems)
		{
			result.add(ele.html());
		}
		
		return result;
	}
	
	public int partialSolvedCount()
	{
		String partialProblemsSolved = doc.select("section.problems-solved h5").get(1).html();
		
		return extractInteger(partialProblemsSolved);
	}
	
	public int fullySolvedCount()
	{
		String problemsSolved = doc.select("section.problems-solved h5").get(0).html();
		return extractInteger(problemsSolved);
	}
	
	int extractInteger(String text)
	{
		int result = 0;
		
		for(int i=0;i<text.length();i++)
		if(Character.isDigit(text.charAt(i)))
		{
			for(int j=i;j<text.length();j++)
			{
				if(Character.isDigit(text.charAt(j)) == false) break;
				
				result = result * 10 + (text.charAt(j) - '0');
			}
			
			break;
		}
		
		return result;
	}
}
