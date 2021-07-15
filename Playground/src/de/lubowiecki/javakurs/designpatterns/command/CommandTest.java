package de.lubowiecki.javakurs.designpatterns.command;

public class CommandTest {

	public static void main(String[] args) {
		
		DataOperationExecutor executor = new DataOperationExecutor();
		
		executor.addOperation(new SaveToDbOperation(new JsonData()));
		executor.addOperation(new SaveToDbOperation(new JsonData()));
		executor.addOperation(new SaveToDbOperation(new JsonData()));
		executor.addOperation(new RemoveFromDbOperation(new JsonData()));
		executor.addOperation(new RemoveFromDbOperation(new JsonData()));
		executor.addOperation(new SaveToDbOperation(new JsonData()));
		executor.addOperation(new SaveToDbOperation(new JsonData()));
		
		executor.executeAllOperatios();
		
		System.out.println("------------------");
		
		executor.addOperation(new SaveToDbOperation(new JsonData()));
		executor.addOperation(new SaveToDbOperation(new JsonData()));
		executor.executeAllOperatios();
		

	}

}
