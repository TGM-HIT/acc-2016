package main;

import java.util.LinkedList;

/**
 * Provides the settings for the user in {@linkplain Wörterbuch}
 * 
 * @author Peter Fuchs
 * @version 14 Dec 2016
 */
public class Setting {
	private String name;
	private Object[] values;
	private Object selectedValue;
	
	/**
	 * Constructor
	 * 
	 * @param values the possible values of the setting
	 * @param name the name of the setting
	 * @param selectedValue the active value of the setting
	 */
	public Setting(Object[] values, String name, Object selectedValue) {
		this.name = name;
		this.setValues(values);
		for (Object v : values)
			if (v.equals(selectedValue))
				this.selectedValue = selectedValue;
		if (this.selectedValue.equals("") || this.selectedValue == null)
			this.selectedValue = values[0];
	}
	
	/**
	 * Creates a value-Array for the constructor
	 * @param values the values to add to the array
	 * @return an object-array of values
	 */
	public static Object[] createValues(Object ... values) {
		LinkedList<Object> list = new LinkedList<Object>();
		for (Object value : values)
			list.add(value);
		
		return list.toArray();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the selectedValue
	 */
	public Object getSelectedValue() {
		return selectedValue;
	}

	/**
	 * @param selectedValue the selectedValue to set
	 */
	public void setSelectedValue(Object selectedValue) {
		this.selectedValue = selectedValue;
	}

	/**
	 * @return the values
	 */
	public Object[] getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(Object[] values) {
		this.values = values;
	}
}
