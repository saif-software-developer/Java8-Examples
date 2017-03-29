package chapter10.optional;

import java.util.List;
import java.util.Optional;

public class State {

	private String name;
	private List<Gang> gangs;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State withName(String name) {
		this.name = name;
		return this;
	}
	public List<Gang> getGangs() {
		return gangs;
	}
	public void setGangs(List<Gang> gangs) {
		this.gangs = gangs;
	}
	public State withGangs(List<Gang> gangs) {
		this.gangs = gangs;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gangs == null) ? 0 : gangs.hashCode());
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
		State other = (State) obj;
		if (gangs == null) {
			if (other.gangs != null)
				return false;
		} else if (!gangs.equals(other.gangs))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
