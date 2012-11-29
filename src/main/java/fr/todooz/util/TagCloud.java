package fr.todooz.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.todooz.http.HttpClientTest;

public class TagCloud extends HttpClientTest {
	    private List<String> tags = new ArrayList<String>();

	    private void add(String tag){
	    	 if (tag=="" || tag==null ){
	    		 return;
	    	 }
	    	 if (!tags.contains(tag))
	    		  tags.add(tag);	  
	    }
	    
	    public void add(String ... tags) {
	      if (tags==null) {
	    	  return;
	      }
	      for (String tag : tags){
	    	add(tag);
	      }
	    }

	    public int size() {
	        return tags.size(); 
	    }

		public boolean contains(String string) {
			return tags.contains(string);
		}

		public void top(int i) {
			
			
		}

		public void shuffle() {
			Collections.shuffle(tags);
			
		}
	}
