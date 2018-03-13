package com.fradou.nutrition.mvc.entity.work;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fradou.nutrition.mvc.entity.generic.GenericEntity;
import com.fradou.nutrition.mvc.utils.serializer.MealSerializer;
import com.fradou.nutrition.mvc.utils.work.MealType;

/**
 * Entity for meals (include food, included in intake)
 * 
 * @author AF
 */
@Entity
@Component
@Table(name="meal")
@JsonSerialize(using = MealSerializer.class)
public class Meal extends GenericEntity {
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private MealType mealType;
	
	@ManyToOne
	@JoinColumn(name="intake_id")
	private Intake intake;
	
	@OneToMany(mappedBy="meal")
	private Set<MealDetail> mealFoods = new HashSet<MealDetail>();
	
	@Override
	protected String initializeEntityPath() {
		return "/meal";
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public Intake getIntake() {
		return intake;
	}

	public void setIntake(Intake intake) {
		this.intake = intake;
	}

	public Set<MealDetail> getMealFoods() {
		return mealFoods;
	}

	public void setMealFoods(Set<MealDetail> mealFoods) {
		this.mealFoods = mealFoods;
	}
}
