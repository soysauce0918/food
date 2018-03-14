package com.food.dao;
import com.food.model.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;
@Service @Transactional
public class FoodDao {
	@Resource SessionFactory factory;
	
	public void addFood(Food food){
		Session s= factory.getCurrentSession();
		s.save(food);
		
	}
	
	public void deleteFood(Integer foodid){
		Session s= factory.getCurrentSession();
		Object food= s.load(Food.class, foodid);
		s.delete(food);
		
	}
	
    public void UpdateFood(Food food) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(food);
    }
    
    public ArrayList<Food> QueryAllFood() {
        Session s = factory.getCurrentSession();
        String hql = "From Food";
        Query q = s.createQuery(hql);
        List foodList = q.list();
        return (ArrayList<Food>) foodList;
    }
    
    public Food GetFoodById(Integer foodid) {
        Session s = factory.getCurrentSession();
        Food food = (Food)s.get(Food.class, foodid);
        return food;
    }
    
    public ArrayList<Food> QueryFood(String foodname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Food food where 1=1";
    	if(!foodname.equals("")) hql = hql + " and food.foodname like '%" + foodname + "%'";
    	Query q = s.createQuery(hql);
    	List foodList = q.list();
    	return (ArrayList<Food>) foodList;
    }

}
