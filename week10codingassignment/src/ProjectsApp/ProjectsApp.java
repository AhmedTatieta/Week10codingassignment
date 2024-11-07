package ProjectsApp;

import java.util.List;
import java.util.Objects;

public class ProjectsApp {
	private Scanner = new scanner(System.in);
	private ProjectService projectService = new ProjectService();
	private Project curProject;
	
	// @formatter:off
	private List<String> operations = List.of(
			"1) Add a project",
			"2) List projects",
			"3) Select a project"
			
	);
	// @formatter:on
	
	private void processUserSelections(()  {
		boolean done = false;
		
		while(!done) {
			try {
				int selection = getUserSelection();
				switch(selection = getUserSelection();
				case -1:
					done = exitMenu();
					break;
					
				case 1:
					createProject();
					break:
				
				case 3:
					selectProject();
					break;
					
				default:
					System.out.println("\n" + selection + is not valid selection. Try again."); 
							brea;
			}
		}
		catch(Exception e)  {
			System.out.println("\nError: " + e + "Try again");
		}
	}
}


    private void selectProject() {
    	listProjects();
    	Integer projectId = getIntInput("Enter a project ID to select a project");
    	
    	curProject = null;
    	
    	
    	curProject = projectService.fetchProjectById(projectId);
    }
    
    
    private void listProjects() {
    	List<Project> projects = projectService.fecthAllProjects();
    	
    	System.out.println("\nProjects:");
    	
    	projects.forEach(project -> System.out
    			.println("   " + project.getProjectId() + ": " + project.getProjectName()));
    	
    private void printOperations() {
    	System.out.println("\nThese are the available selections. Press the Enter key to quit:");
    	
    	operations.forEach(Line -> System.out.println("  " + line));
    	
    	
    	if(Objects.isNull(curProject)) {
    		System.out.println("\nYou are not working with a project.");
    	}
    	else	{
    		System.out.println("\nYou are working with project: " + curProject);
		}
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	