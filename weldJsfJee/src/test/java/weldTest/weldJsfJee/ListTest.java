package weldTest.weldJsfJee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListTest {

	public static void main(String[] args) {

		Long[] longs = new Long[] { 3L, 2L };
		System.out.println(areElementsdifferent(longs));

	}

	/**
	 * Testing if all the elements in a list are different from each other:
	 */
	public static boolean areElementsdifferent(Long... longs) {
		List<Long> list = Arrays.asList(longs);
		System.out.println("list " + list);

		// uniqueness!
		Set<Long> set = new HashSet<Long>(list);
		System.out.println("set " + set);
		return (longs.length == set.size());
	}
}
