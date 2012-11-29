package fr.todooz.util;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TagCloudTest {

	@Test
	 public void add() {
	      TagCloud tagCloud = new TagCloud();

	      tagCloud.add("java");
	}
	
	@Test
	public void size() {
	    TagCloud tagCloud = new TagCloud();

	    tagCloud.add("java");

	    Assert.assertEquals(1, tagCloud.size());
	}
}
