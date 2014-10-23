package com.getbestplace.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.getbestplace.action.HighPriorityPlacesAction;
import com.getbestplace.model.HighProrityPlaces;

public class JsonUtils {



    public static String getJsonFromList(List<HighProrityPlaces> hList,List<HighProrityPlaces> mList) throws Exception {
    	
    	/*map one object with two property highpr:[json array],medpr:[json array] , 
    	 * in json array put jsonobjects with two props name and placeimag*/
    	
        JSONObject completeResp=new JSONObject();
    	
        JSONArray highPlaceArray=new JSONArray();
        
        Iterator<HighProrityPlaces> hitr=hList.iterator();
        
        while(hitr.hasNext()){
        	HighProrityPlaces hpp=hitr.next();
        	JSONObject node=new JSONObject();
        	node.putOnce("name", hpp.getPlace().getName());
        	highPlaceArray.put(node);
        }
        completeResp.put("hplace", highPlaceArray);
        
        JSONArray mediumPlaceArray=new JSONArray();
        
        Iterator<HighProrityPlaces> mitr=mList.iterator();
        
        while(mitr.hasNext()){
        	HighProrityPlaces hpp=mitr.next();
        	JSONObject node=new JSONObject();
        	node.put("name", hpp.getPlace().getName());
        	mediumPlaceArray.put(node);
        }
        completeResp.put("mplace", mediumPlaceArray);


        return completeResp.toString();

    }
    
    /*{"locality":[{name:"loc1"},{name:"loc2"}]}*/
    public static String getLocality(List<String> locList) throws Exception{
    	
    	JSONArray loclistArray=new JSONArray();
        
        Iterator<String> locListItr=locList.iterator();
        while(locListItr.hasNext()){
        	JSONObject node=new JSONObject();
        	node.put("name",locListItr.next());
        	loclistArray.put(node);
        }
        JSONObject completeResponse=new JSONObject();
        
        completeResponse.putOnce("locality", loclistArray);
        
    	return completeResponse.toString();
    }
    
}
