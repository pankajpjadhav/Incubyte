package com.sunbeam;

import java.util.ArrayList;


public class StringCalculator {

	public static int add(String nums) throws InvalidInputException {
		if (nums.length() == 0)
			return 0;
		ArrayList<String> list = new ArrayList<>();
		String str = "";
		for (int i = 0; i < nums.length(); i++) {

			if (nums.charAt(i) >= 48 && nums.charAt(i) <= 57)
				str += nums.charAt(i);

			else {
				if (str.length() > 0)
					list.add(str);
				str = "";
			}
		}
		if (nums.length() > 1 && nums.substring(nums.length() - 1).equals("\n"))
			throw new InvalidInputException("Invalid input");
		if (str.length() > 0)
			list.add(str);
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += Integer.parseInt(list.get(i));
		return sum;

	}

	public static void main(String[] args) {
		
		try {
			System.out.println(add("1,2 ,3"));
			System.out.println(add("1,4 , 1,4 ,5"));
			System.out.println(add("7,8,10"));
			System.out.println(add("2/***;3"));
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());;
		}
	}

}