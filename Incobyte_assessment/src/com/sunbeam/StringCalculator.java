package com.sunbeam;

import java.util.ArrayList;

public class StringCalculator {

	public static int add(String nums) {
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
		if (str.length() > 0)
			list.add(str);
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += Integer.parseInt(list.get(i));
		return sum;

	}

	public static void main(String[] args) {
		System.out.println(add("1,2"));
	}

}