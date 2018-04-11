package com.adneom.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.adneom.exception.InputException;

public class PartitionCreator {

	/**
	 * 
	 * This method returns a partitioned list where each sublist contains the
	 * number of elements specified by the size argument
	 * 
	 * @param listToPartition List of integers that needs to be partitioned
	 * @param size Size of individual partitions
	 * @return Returns List containing partitioned List(s) of Integers
	 * @throws InputException Input Exception is thrown if the listToPartition argument
	 *             is null or empty or if the size argument is less than 1
	 */
	public static List<List<Integer>> partitionTest(List<Integer> listToPartition, int size) throws InputException {
		if (listToPartition == null || listToPartition.size() == 0)
			throw new InputException("Invalid input for list");
		if (size < 1)
			throw new InputException("Invalid input for parameter size");
		int numPartitions = listToPartition.size() % size == 0 ? listToPartition.size() / size
				: (listToPartition.size() / size) + 1;

		List<List<Integer>> result = new ArrayList<List<Integer>>(numPartitions); // Two
																					// dimensional
																					// array
																					// with
																					// result
		int arrayCntr = 0;
		List<Integer> tempList = null;
		for (Integer listItem : listToPartition) {
			if (arrayCntr % size == 0) // create
			{
				tempList = new ArrayList<Integer>(size);
				result.add(tempList);
			}
			tempList.add(listItem);
			arrayCntr++;
		}
		return result;
	}

	/**
	 * 
	 * This method returns a partitioned list where each sublist contains the
	 * number of elements specified by the size argument
	 * 
	 * @param listToPartition List of integers that needs to be partitioned
	 * @param size Size of individual partitions
	 * @return Returns List containing partitioned List(s) of Integers
	 * @throws InputException Input Exception is thrown if the listToPartition argument
	 *             is null or empty or if the size argument is less than 1
	 */
	public static List<List<Integer>> partition(List<Integer> listToPartition, int size) throws InputException {
		if (listToPartition == null || listToPartition.size() == 0)
			throw new InputException("Invalid input for list");
		if (size < 1)
			throw new InputException("Invalid input for parameter size");

		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		int startIndex = 0;
		int lastIndex = size;
		int totalElements = listToPartition.size();
		while (startIndex < totalElements) {
			ret.add(listToPartition.subList(startIndex, Math.min(lastIndex, totalElements)));
			startIndex += size;
			lastIndex += size;
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		int elementNum = 0;
		List<Integer> listToPartition = new ArrayList<Integer>();
		System.out.print("Please enter input array of integers (Seperated by space ): ");
		Scanner in = new Scanner(System.in);
		try {
			try {
				listToPartition = Arrays.stream(in.nextLine().trim().split("\\s+")).map(Integer::valueOf)
						.collect(Collectors.toList());
			} catch (Exception ex) {
				throw new InputException("Input array is incorrect");
			}
			System.out.print("Please enter size of partition : ");
			try {
				elementNum = in.nextInt();
			} catch (Exception ex) {
				throw new InputException("Input number for split is invalid");
			}

			List<List<Integer>> result = PartitionCreator.partition(listToPartition, elementNum);

			System.out.print("Partition output : [");
			for (int i = 0; i < result.size(); i++) {
				List<Integer> lstResultPartition = result.get(i);
				System.out.print(" [");
				for (int j = 0; j < lstResultPartition.size(); j++) {
					String strNumtoPrint = j == 0 ? String.valueOf(lstResultPartition.get(j))
							: "," + lstResultPartition.get(j);
					System.out.print(strNumtoPrint);
				}
				System.out.print("] " + (i < result.size() - 1 ? "," : ""));
			}
			System.out.println("]");
		} catch (Exception ex) {
			System.out.println("Error while running program : " + ex.getMessage());
		} finally {
			in.close();
		}
	}
}
