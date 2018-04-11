package com.adneom.api;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.adneom.exception.InputException;

public class TestPartitionCreator {

	
	@Test
	public void testPartition() throws InputException{
		int [] testArray = {1,2,3,4,5};		
		List<Integer> lstPartition= Arrays.stream(testArray)
				.boxed()
				.collect(Collectors.toList());
		List<List<Integer>> result = PartitionCreator.partition(lstPartition, 2);
		
		assertTrue("Given Input Array has 5 elements and partition number is 2 the number of sublists generated is 3 ", result.size()==3);
		assertTrue("Given Input array has 5 elements and partition number is 2 , second partition contains 2 elements ",result.get(1).size()==2);
		assertTrue("Given Input array has 5 elements and partition number is 2 , third partition contains 1 elements ",result.get(2).size()==1);
		assertTrue("Given Input array has 5 elements and partition number is 2 , the 2nd element in 2nd partition is 4 ",result.get(1).get(1)==4);
	}
	
	@Test
	public void testPartitionLargeSize() throws InputException{
		int [] testArray = {1,2,3,4,5};		
		List<Integer> lstPartition= Arrays.stream(testArray)
				.boxed()
				.collect(Collectors.toList());
		List<List<Integer>> result = PartitionCreator.partition(lstPartition, 100);
		
		assertTrue("Given Input Array has 5 elements and partition number is 100 the number of sublists generated is 1 ", result.size()==1);
	}
	@Test (expected = InputException.class)
	public void testPartitionNullInputList() throws InputException
	{
		PartitionCreator.partition(null, 0);
	}
	@Test (expected = InputException.class)
	public void testPartitionEmptyInputList() throws InputException
	{
		PartitionCreator.partition(new ArrayList<Integer>(), 0);
	}
	
	@Test (expected = InputException.class)
	public void testPartitionInvalidSize() throws InputException
	{
		int [] testArray = {1,2,3,4,5};		
		List<Integer> lstPartition= Arrays.stream(testArray)
				.boxed()
				.collect(Collectors.toList());
		PartitionCreator.partition(lstPartition, 0);
	}
	

}
