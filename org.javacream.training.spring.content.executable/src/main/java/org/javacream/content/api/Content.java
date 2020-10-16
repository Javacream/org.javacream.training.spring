package org.javacream.content.api;

import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document
public class Content {

	@Id
	private String id;
	@Field
	private List<String> tags;
	@Field
	private String data;

	public String getId() {
		return id;
	}
	public List<String> getTags() {
		return tags;
	}
	public String getData() {
		return data;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", tags=" + tags + ", data=" + data + "]";
	}
	public Content(String id, List<String> tags, String data) {
		super();
		this.id = id;
		this.tags = tags;
		this.data = data;
	}
	public Content() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		return true;
	}
}
