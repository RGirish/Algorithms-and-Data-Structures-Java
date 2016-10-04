package com.girish.interview.bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		Collections.sort(list);
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i = i + 2) {
			if (i + 1 < list.size())
				output.add(list.get(i + 1));
			if (i < list.size())
				output.add(list.get(i));
		}

		for (int a : output) {
			System.out.println(a);
		}
	}

}
