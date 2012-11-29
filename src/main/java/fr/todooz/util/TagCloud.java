package fr.todooz.util;

import java.util.ArrayList;
import java.util.List;

import fr.todooz.http.HttpClientTest;

public class TagCloud extends HttpClientTest {
	    private List<String> tags = new ArrayList<String>();

	    public void add(String tag) {
	        tags.add(tag);
	    }

	    public int size() {
	        return tags.size();
	    }
	}
