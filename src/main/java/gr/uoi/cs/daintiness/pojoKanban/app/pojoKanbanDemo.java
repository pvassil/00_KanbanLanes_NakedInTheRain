package app;

import service.LaneManagementRepoFactory;
import service.LaneManagementRepoInterface;
import service.LaneReporterFactory;
import service.LaneReporterInterface;

public class pojoKanbanDemo {

	public static void main(String[] args) {
		LaneManagementRepoFactory laneFactory = new LaneManagementRepoFactory();
		LaneManagementRepoInterface repo =  laneFactory.makeNewLaneManagementRepo();
		repo.addLane("Done");
		repo.addLane("CompletedButNotTested");
		repo.addLane("InProgress");
		repo.addLane("Upcoming");
		repo.addLane("InBrainStormMode");

		repo.addCardToLane("Buy Stakes", "DL: MON", "no more than 15E/kg", "Done");
		repo.addCardToLane("DeFreeze Stakes", "DL: WED", "all night long", "Done");
		repo.addCardToLane("Prepare Pan", "DL: THU", "Put the pan on fire till it's super hot", "Done");
		repo.addCardToLane("Prepare Stakes", "DL: THU", "Shower Stakes with Oil, Pepper, Salt, Garlic", "Done");
		repo.addCardToLane("Fry Stakes", "DL: THU", "to give them heat and make them encompass it; remember to turn them upside down at least once", "CompletedButNotTested");
		repo.addCardToLane("Cook Stakes", "DL: THU", "by letting them rest quietly for 30 min.", "InProgress");
		repo.addCardToLane("Make a Salad", "DL: THU", "kai mh bariesai", "InProgress");
		repo.addCardToLane("Eat Lunch", "DL: THU", "quietly", "Upcoming");
		repo.addCardToLane("Decide tomorrow's lunch", "DL: FRI", "cook or maybe order?", "InBrainStormMode");
		
		LaneReporterFactory reporterFactory = new LaneReporterFactory();
		LaneReporterInterface textReporter = reporterFactory.makeLaneReporter(LaneReporterFactory.LaneReporterEnumTypes.TEXT, repo);
		System.out.println("\n *** ");
		System.out.println(textReporter.reportLaneLong("Done"));
		System.out.println("\n *** ");
		System.out.println(textReporter.reportLaneLong("CompletedButNotTested"));
		System.out.println("\n *** ");
		System.out.println(textReporter.reportLaneLong("InProgress"));
		System.out.println("\n *** ");
		System.out.println(textReporter.reportLaneLong("Upcoming"));
		System.out.println("\n *** ");
		System.out.println(textReporter.reportLaneLong("InBrainStormMode"));
		

	}//end main

}//end class
