package chapter10.optional;

import java.util.List;

public class Gang {

	private String name;
	private List<GangMember> gangMembers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gang withName(String name) {
		this.name = name;
		return this;
	}
	public List<GangMember> getGangMembers() {
		return gangMembers;
	}
	public void setGangMembers(List<GangMember> gangMembers) {
		this.gangMembers = gangMembers;
	}
	public Gang withGangMembers(List<GangMember> gangMembers) {
		this.gangMembers = gangMembers;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((gangMembers == null) ? 0 : gangMembers.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Gang other = (Gang) obj;
		if (gangMembers == null) {
			if (other.gangMembers != null)
				return false;
		} else if (!gangMembers.equals(other.gangMembers))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
