/**
 * 
 */
package service;

import java.util.List;
import java.util.Objects;

import model.KanbanLane;
import utils.Paragraph;

/**
 * @author pvassil
 *
 */
public class LaneReporterText implements LaneReporterInterface{

	private final LaneManagementRepoInterface repo;
	
	public LaneReporterText(LaneManagementRepoInterface repo) throws NullPointerException{
		this.repo = Objects.requireNonNull(repo);
	}
	
	public String reportLaneLong(String laneName) {
		String result = "";
		KanbanLane lane = this.repo.getKanbanLane(laneName);
		if (lane == null)
			return "Lane " + laneName + " does nto exist. No reporting.";
		
		result = lane.selfDescribeShort().toString();
		List<Paragraph> paragraphs = lane.selfDescribeLong();
		for(Paragraph p: paragraphs) {
			result = result + "\n" + p.toString();
		}
		return result;
	}
}
