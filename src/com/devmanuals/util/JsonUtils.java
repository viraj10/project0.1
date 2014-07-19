package com.devmanuals.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.devmanuals.action.HighPriorityPlacesAction;
import com.devmanuals.model.HighProrityPlaces;

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
        	node.putOnce("name", hpp.getPlace().getName());
        	mediumPlaceArray.put(node);
        }
        completeResp.put("mplace", mediumPlaceArray);


        return completeResp.toString();

    }

    
}