package service;

public class LaneReporterFactory {

	public enum LaneReporterEnumTypes {TEXT};

	public LaneReporterInterface makeLaneReporter(LaneReporterEnumTypes reporterType, LaneManagementRepoInterface repo) {
		switch(reporterType) {
		case TEXT: return new LaneReporterText(repo);
		default: return null;
		}
	}
}
