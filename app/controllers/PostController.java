package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.post.*;
import models.*;

public class PostController extends Controller {
	
	static Form<Post> form = new Form<Post>(Post.class);
	
	public static Result all(){
		return ok(
				index.render(
						Post.all()
						));
	}
	
	public static Result show(int id){
		return ok(show.render(Post.find(id)));
	}
	
	public static Result newPost(){
		return ok(newPost.render(form));
	}
	
	public static Result create(){
		form = form.bindFromRequest();
		if(form.hasErrors()){
			return redirect("/post/new");
		}
		Post p = form.get();
		Post.create(p);
		return redirect("/post/"+p.id);
	}
	
	public static Result update(int id){
		form = form.fill(Post.find(id));
		return ok(update.render(form));
	}
	
	public static Result save(int id){
		form = form.bindFromRequest();
		if(form.hasErrors()){
			return redirect("/update/"+form.get().id);
		}
		Post p = form.get();
		p.id = id;
		Post.update(p);
		return redirect("/post/"+p.id);
	}
	
	public static Result delete(int id){
		Post.delete(id);
		return redirect("/");
	}

}
