package de.lubowiecki.javakurs.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

public class DataOperationExecutor {

	private final List<Operation> operations = new ArrayList<>();
	
	public String executeOperation(Operation op) {
		operations.add(op);
		return op.execute();
	}
	
	public void addOperation(Operation op) {
		operations.add(op);
	}
	
	public void executeAllOperatios() {
		operations.forEach(o -> System.out.println(o.execute()));
	}
}
