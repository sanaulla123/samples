package info.sanaulla.springbootvuejs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import info.sanaulla.model.CustomMap;

@RunWith(SpringRunner.class)
public class CustomMapTest {

	@Test
	public void testCustomMap(){
		CustomMap<Integer> map = new CustomMap<>();
		
		map.put("one", 1);
		map.put("ONE", 2);
		System.out.println(map);
	}
}
