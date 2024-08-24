select * from meals m 

select * from ingredients i 

select m."name" as "MealName", i."name" as "IngredientName" 
from meals m
join meal_ingredients mi on mi.meal_id = m.meal_id 
join ingredients i on i.ingredient_id = mi.ingredient_id 
