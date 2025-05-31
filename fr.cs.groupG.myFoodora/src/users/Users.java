package users;

public abstract class Users {
	
	protected String name;
    protected String surname;
    protected int id;
    protected static int nid;
    protected String username;
    protected String password;
    protected String userType;
    
    public Users(String name, String surname, int id, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public Users(String name, String surname, String username,String password) {
    	this.name = name;
    	this.surname = surname;
    	this.username = username;
    	this.id=nid;
    	++nid;
    	this.password = password;	
    }
    
    public String getUserType() {
    	return userType;
    }
    
    public String getName() { 
    	return name; 
    	}
    
    public String getSurname() { 
    	return surname; 
    	}
    
    public int getId() { 
    	return id; 
    	}
    
    public String getUsername() { 
    	return username; 
    	}
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) { 
    	this.password = password; 
    	}
    
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    

}
