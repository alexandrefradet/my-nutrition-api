package com.fradou.nutrition.mvc.utils.filter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class IntakeAsParentFilter extends SimpleBeanPropertyFilter implements PropertyFilter {

	@Override
	public void serializeAsField(Object pojo, JsonGenerator gen, SerializerProvider prov, PropertyWriter writer)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serializeAsElement(Object elementValue, JsonGenerator gen, SerializerProvider prov,
			PropertyWriter writer) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositSchemaProperty(PropertyWriter writer, ObjectNode propertiesNode, SerializerProvider provider)
			throws JsonMappingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositSchemaProperty(PropertyWriter writer, JsonObjectFormatVisitor objectVisitor,
			SerializerProvider provider) throws JsonMappingException {
		// TODO Auto-generated method stub
		
	}

}
