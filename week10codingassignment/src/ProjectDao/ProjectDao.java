package ProjectDao;

public List<Project> fetchAllProjects() {
	String sql = "SELECT * FROM " + PROJECT_TABLE + " ORDER BY project_name");
	
	try(Connection conn = DbConnection.getConnection()) {
		startTransaction(conn);
		
		try(PreparedStatment stmt = conn.prepareStatement(sql)) {
			try(ResultSet rs = stmt.executeQuery()) {
				List<Project> projects = new LinkedList<>();
				
				while(rs.next()) {
					projects.add(extract(rs, Project.class));
				}
				
				return projects;
			}
		}
		catch(Exception e)  {
			rollbackTransaction(conn);
			throw new DbException(e);
		}
	}
	catch(SQLException e) {
		throw new DBException(e);
	}
}
public Optional<Project> fetchProjectById(Integer projectId)  {
	String sql = "SELECT * FROM " + PROJECT_TABLE + "WHERE project_id = ?";
	
	try {
	  startTransaction(conn);
	  
	  try { 
		 Project project = null;
		 
		 try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			 setParameter(stmt, 1, projectId, Integer.class);
			 
			 try(ResultSet rs = stmt.executeQuery(() {
				 if(rs.next()) {
					 project = extract(rs, Project.class);
					 
				 }
				 
			 }
		 }
         if(Objects.nonNull(project)) {
        	 project.getMaterials().addAll(fetchMaterialsForProject(conn, projectId));
        	 project.getSteps().addAll(fetchStepeForProject(conn, projectId));
        	 project.getCategories().addAll(fetchCategoriesForProject(conn, projectId));
        }
         
         commitTransaction(conn);
         return Optional.ofNullable(project);
	    }
      } 
	catch(Exception e) {
		rolbackTransaction(conn);
		throw new DbException(e);
	}
}
catch(SQLException e) { 
	throw new DbException(e);
	}
}
private List<Category> fetchCategoriesForProject(Connection conn,
    Integer projectId) throws SQLExcepton {
	// @formatter:off
	String sql = ""
		+ "SELECT c.* FROM" + CATEGORY_TABLE + " c "
		+ "JOIN " + project_category_table + " pc USING (category_id) "
		+ "WHERE project_id = ?";
	// @formatter:on 
	
	try(PreparedStatement stmt = conn.prepareStatement(sql)) {
		setParameter(stmt, 1, projectId, Integer.class):
			
		try(ResultSet rs = stmt.executeQuery()) {
			List<Category> categories = new LinkedList<>();
			
			while(rs.next()) {
				categories.add(extract(rs, Category.class));
				
				return categories 
			}
		}
	
	private List<Step> fetchStepsForProject(Connection con, Integer projectId) throwsSQLException {
		String sql = "SELECT * + STEP_TABLE " + " WHERE project_Id = ?"; 
				
				
	  try(PreparedStatement stmt = conn.prepareStatement(sql)) {
		  setParameter(stmt, 1, projectId, Integer.class);
		  
		  try(ResultSet rs = stmt.excecuteQuery()) {
			  List<Step> steps = new LinkedList<>();
			  
			  while(rs.next()) {
				  steps.add(extract(rs, Step.class));
			  }
			  
			  return steps; 
		  }
	  }	
	}
    private List<Material> fetchMaterialsForProject(Connection conn, Integer projectId)
       throws SQLException {
     String sql = "SELECT * FROM " + MATERIAL_TABLE + " WHERE project_Id = ?"; 
     
     try(PreparedStatement stmt = conn.prepareStatement(sql)) {
    	 setParameter(stmt, 1, project_Id, Integer.class);
    	 
    	 try(ResultSet rs = stmt.excecuteQuey())  {
    		 List<Material> materials = new LinkedList<>();
    		 
    		 while(rs.next()) {
    			 materials.add(extract(rs, Material.class));
    		 }
    		 
    		 return materials;
    	 }
     }
    }
    	  
   