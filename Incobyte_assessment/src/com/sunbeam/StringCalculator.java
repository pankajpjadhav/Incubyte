package com.sunbeam;

import java.util.ArrayList;

public class StringCalculator {
	private static int count = 0;

	public static int getCount() {
		return count;
	}

	public static int add(String nums) throws InvalidInputException, NegativeValueException {
		count++;
		if (nums.length() == 0)
			return 0;
		ArrayList<String> list = new ArrayList<>();
		String str = "";
		for (int i = 0; i < nums.length(); i++) {

			if (nums.charAt(i) >= 48 && nums.charAt(i) <= 57) {
				str += nums.charAt(i);
				if (str.length() == 1 && i > 0 && nums.charAt(i - 1) == 45)
					throw new NegativeValueException(("Negative Values Not Allowed"));
			}

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
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("1000") || list.get(i).length() < 4) {
				sum += Integer.parseInt(list.get(i));
			}
		}
		return sum;

	}

	public static void main(String[] args) {

		try {
			System.out.println(add("1,2 ,1001"));
			System.out.println(add("1,4 , 1,4 ,5"));
			System.out.println(add("7,8,10"));
			// System.out.println(add("2/***;-3"));
			// System.out.println(add("-2/***;-3"));
			System.out.println(add("//[*]\n1**2**3"));
			System.out.println(add("//[*][%]\\n1*2%3"));
			System.out.println(getCount());
		} catch (InvalidInputException | NegativeValueException e) {
			System.out.println(e.getMessage());
		}
	}

}