package de.lubowiecki.javakurs.designpatterns.strategy;

public class ADACAutoNavigation extends AbstractNavi {

	public ADACAutoNavigation() {
		setStrategie(new AutoStrategie());
	}
}
