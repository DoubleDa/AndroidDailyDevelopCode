package com.dyx.jkp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Test {
	private static ObjectMapper objectMapper = new ObjectMapper();
	static String jsonPerson = "{\"name\":\"dyx\",\"age\":18}";

	public static void main(String[] args) {
		// parseStringJson();
		// parseReaderJson();
		// parseFileJson();
		// parseUrlJson();
		// parseIsJson();
		parseByteArrayJson();
	}

	/*
	 * Reading JSON From a String
	 */
	public static void parseStringJson() {
		try {
			Person person = objectMapper.readValue(jsonPerson, Person.class);
			System.out.println("Name:" + person.getName() + "\n" + "Age:" + person.getAge());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reading JSON From a Reader
	 */
	public static void parseReaderJson() {
		Reader reader = new StringReader(jsonPerson);
		try {
			Person person = objectMapper.readValue(reader, Person.class);
			System.out.println("Name:" + person.getName() + "\n" + "Age:" + person.getAge());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reading JSON From a File
	 */
	public static void parseFileJson() {
		File file = new File("json/person.json");
		try {
			Person person = objectMapper.readValue(file, Person.class);
			System.out.println("Name:" + person.getName() + "\n" + "Age:" + person.getAge());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reading JSON From a URL
	 */
	private static void parseUrlJson() {
		try {
			URL url = new URL("file:json/person.json");
			Person person = objectMapper.readValue(url, Person.class);
			System.out.println("Name:" + person.getName() + "\n" + "Age:" + person.getAge());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reading JSON From an InputStream
	 */
	public static void parseIsJson() {
		try {
			InputStream is = new FileInputStream("json/person.json");
			Person person = objectMapper.readValue(is, Person.class);
			System.out.println("Name:" + person.getName() + "\n" + "Age:" + person.getAge());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reading JSON From a Byte Array
	 */
	private static void parseByteArrayJson() {
		try {
			byte[] array = jsonPerson.getBytes("UTF-8");
			Person person = objectMapper.readValue(array, Person.class);
			System.out.println("Name:" + person.getName() + "\n" + "Age:" + person.getAge());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
