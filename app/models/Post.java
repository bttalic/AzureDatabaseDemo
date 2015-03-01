package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Post extends Model {
	
	@Id
	public int id;
	
	@Required
	public String title;
	
	@Required
	public String content;
	
	static Finder<Integer, Post> find = new Finder<Integer, Post>(Integer.class, Post.class);
	
	public static void create(Post p){
		p.save();
	}
	
	public static Post find(int id){
		return find.byId(id);
	}
	
	public static void delete(int id){
		find.byId(id).delete();
	}
	
	public static List<Post> all(){
		return find.all();
	}
	
	public static void update(Post p){
		p.update();
	}
	

}
