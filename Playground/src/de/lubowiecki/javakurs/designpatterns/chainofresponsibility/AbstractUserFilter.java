package de.lubowiecki.javakurs.designpatterns.chainofresponsibility;

public abstract class AbstractUserFilter {
	
	protected AbstractUserFilter nextFilter;

	public void setNextFilter(AbstractUserFilter nextFilter) {
		this.nextFilter = nextFilter;
	}
	
	abstract boolean check(User user);
}
