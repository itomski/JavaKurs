package de.lubowiecki.javakurs.designpatterns.chainofresponsibility;

import java.time.LocalDate;

public class AgeUserFilter extends AbstractUserFilter {

	@Override
	boolean check(User user) {
		LocalDate minDate = LocalDate.now().minusYears(18);
		
		System.out.println(getClass().getSimpleName());
		
		if(user.getBirthDate().isBefore(minDate)) {
			if(nextFilter != null)
				return nextFilter.check(user);
			
			return true;
		}
		return false;
	}
}
