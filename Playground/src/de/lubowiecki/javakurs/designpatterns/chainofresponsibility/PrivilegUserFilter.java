package de.lubowiecki.javakurs.designpatterns.chainofresponsibility;

public class PrivilegUserFilter extends AbstractUserFilter {
	
	private final Privileg mustHave;

	public PrivilegUserFilter(Privileg mustHave) {
		this.mustHave = mustHave;
	}

	@Override
	boolean check(User user) {
		
		System.out.println(getClass().getSimpleName() + ": " + mustHave);
		
		if(user.getPrivilegs().contains(mustHave)) {
			if(nextFilter != null)
				return nextFilter.check(user);
			
			return true;
		}
		return false;
	}
}
