package com.getbestplace.util;

import java.util.Comparator;
import com.getbestplace.model.Attribute;

public class AttributeNameComparator implements Comparator<Attribute> {

	@Override
	public int compare(Attribute attr1, Attribute attr2) {
		return attr1.getAttributeName().compareTo(attr2.getAttributeName());
	}

}
