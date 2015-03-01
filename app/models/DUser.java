package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class DUser extends Model {
	
	@Id
	public int id;
	
	@Required
	@Email
	public String email;
	
	@Required
	public String password;
	
	static Finder<Integer, DUser> find = new Finder<Integer, DUser>(Integer.class, DUser.class);
	
	public static void create(DUser u){
		u.save();
	}
	
	public static DUser find(int id){
		return find.byId(id);
	}
	
	public static void delete(int id){
		find.byId(id).delete();
	}
	
	public static List<DUser> all(){
		return find.all();
	}
	
	public static void update(DUser u){
		u.update();
	}
	

}
