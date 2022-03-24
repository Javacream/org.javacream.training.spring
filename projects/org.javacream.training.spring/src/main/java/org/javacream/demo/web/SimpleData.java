package org.javacream.demo.web;

import java.util.Objects;

public class SimpleData {

	private String data;

	public SimpleData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SimpleData(String data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "SimpleData [data=" + data + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleData other = (SimpleData) obj;
		return Objects.equals(data, other.data);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
