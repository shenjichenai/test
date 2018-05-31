package com.yida.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.gson.GsonBuilder;

public class ListUtils {

	public static List<List<Object>> splitList(int groupCount, List<Object> list) {

		int avgCount = list.size() / groupCount;

		List<Object> smallList = new ArrayList<>();
		List<List<Object>> splitList = new ArrayList<>();

		for (Object t : list) {
			smallList.add(t);
			if (smallList.size() % avgCount == 0) {
				splitList.add(smallList);
				smallList = new ArrayList<>();
			}
		}
		if (groupCount < splitList.size()) {
			List<Object> moreData = splitList.get(groupCount);
			for (int i = 0; i < moreData.size(); i++) {
				splitList.get(i).add(moreData.get(i));
			}
			splitList.remove(groupCount);
		}
		return splitList;
	}

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 21; i++) {
			list.add(UUID.randomUUID().toString());
		}
		List<List<Object>> splitList = splitList(6, list);
		String json = new GsonBuilder().create().toJson(splitList);
		System.out.println(json);
	}
}
