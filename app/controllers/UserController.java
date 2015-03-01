package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.user.*;
import models.*;

public class UserController extends Controller {
	
static Form<DUser> form = new Form<DUser>(DUser.class);
	
	public static Result all(){
		return ok(
				index.render(
						DUser.all()
						));
	}
	
	public static Result show(int id){
		return ok(show.render(DUser.find(id)));
	}
	
	public static Result newUser(){
		return ok(newUser.render(form));
	}
	
	public static Result create(){
		form = form.bindFromRequest();
		if(form.hasErrors()){
			return redirect("/user/new");
		}
		DUser u = form.get();
		DUser.create(u);
		return redirect("/user/"+u.id);
	}
	
	public static Result update(int id){
		form = form.fill(DUser.find(id));
		return ok(update.render(form));
	}
	
	public static Result save(int id){
		form = form.bindFromRequest();
		if(form.hasErrors()){
			return redirect("/update/"+form.get().id);
		}
		DUser u = form.get();
		u.id = id;
		DUser.update(u);
		return redirect("/user/"+u.id);
	}
	
	public static Result delete(int id){
		DUser.delete(id);
		return redirect("/");
	}

}
