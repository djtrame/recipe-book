
--drop table meal_seasons 
--drop table meals 
--drop sequence meal_id_seq


SELECT last_value FROM meal_id_seq

select last_value from ingredient_id_seq


select * from meals m 

select * from ingredients i


--meals with ingredients
select m.meal_id, m."name" as "MealName", i.ingredient_id, i."name" as "IngredientName" 
from meals m
join meal_ingredients mi on mi.meal_id = m.meal_id 
join ingredients i on i.ingredient_id = mi.ingredient_id 


select * from seasons i
select * from meal_seasons ms

delete from meal_seasons

--meals with seasons
select m.meal_id, m."name" as "MealName", s.season_id, s."name" as "SeasonName" 
from meals m
join meal_seasons ms on ms.meal_id = m.meal_id 
join seasons s on s.season_id = ms.season_id 




