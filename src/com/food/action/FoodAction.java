package com.food.action;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.food.dao.FoodDao;
import com.food.model.Food;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class FoodAction extends ActionSupport{
	
	@Resource FoodDao foodDao;
	
	private Food food;

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	private List<Food> foodList;

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	
	public String addFood(){
		foodDao.addFood(food);
		return "message";
	}
	
	public String showFood(){
		foodDao.QueryAllFood();
		return "show_view";
	}
	

}
