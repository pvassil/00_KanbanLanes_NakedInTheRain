/**
 * 
 */
package service;

/**
 * @author pvassil
 *
 */
public class LaneManagementRepoFactory {
	
	public LaneManagementRepoInterface makeNewLaneManagementRepo() {
		return new LaneManagementRepoService();
	}
}
