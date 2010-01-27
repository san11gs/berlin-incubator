package incubator.weldJsfJee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

/**
 * Testing if all the elements in a list are different from each other.
 * 
 * @author schuetz
 * @date 11.01.2010
 */
public class ListTest {

	@Test
	public void areElementsdifferent() {

		// initial data as Array
		Long[] longs = new Long[] { 3L, 2L };

		// convert Array to List (can contain duplicate entries)
		List<Long> list = Arrays.asList(longs);
		System.out.println("list " + list);

		// uniqueness!
		Set<Long> set = new HashSet<Long>(list);
		System.out.println("set " + set);
		assert (longs.length == set.size());
	}
}
