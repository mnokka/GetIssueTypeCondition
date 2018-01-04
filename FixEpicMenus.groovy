//
// Get issue issue type and if EPIC do not show Create Subtask menu entry
// Using Script Runner Script fragments
// Jan 2018  mika.nokka1@gmail.com
//

import org.apache.log4j.Logger
import org.apache.log4j.Level
import com.atlassian.jira.issue.Issue


	//**************** CONFIGURATIONS ****************************
	
String  KillIssueType="Epic"
String  TargetProject="CreateCorrectSubtask" //ALM DEMO
// String TargetProject="Copy GaaS"
// String TargetProject="GaaS"
//String TargetProject="FindNextVersion"

	 // ***************** END OF CONFIGURATIONS ****************************
	
		def log = Logger.getLogger("FixEpicMenus")
		log.setLevel(Level.INFO) // DEBUG INFO
	
		
		//log.debug("---------- GetissueType started ---------------------------------------")
		//log.debug("issue: ${issue}")

			
		def type=issue.getIssueType().getName() // Jira7
		def project=issue.getProjectObject().getName()
			//def type=issue.getIssueTypeObject().getName() // Jira6
		//log.debug("type: ${type}")
		//log.debug("project: ${project}")
		
		if(project==TargetProject) {
			//log.debug("Target Project found: ${project}")
			
			if (type==KillIssueType) {
				log.info("Project: ${project} issue ${issue} is EPIC --> Preventing Create Subtask menu entry  ")
				return false
				}
	
			else { // not EPIC
				//log.debug("Not Epic, no actions")
				return true
			}
		}
		else { // wrong project
			return true
		}
			
		