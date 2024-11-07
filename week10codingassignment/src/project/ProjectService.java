package project;

public List<Project> fetchAllProjects() {
	return projectDao.fetchAllProjects();
	
	
	@param projectId The project ID.
	@return A  Project object if successful.
	@throws NoSuchElementException Thrown if the project with the given ID does not exist. 
}

public Project fetchProjectById(Integer projectId) {
	return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NosuchElementException(
			"Project with project ID=" + projectId + " does not exist."));
}

