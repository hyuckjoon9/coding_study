SELECT f.flavor
FROM FIRST_HALF f
JOIN ICECREAM_INFO i
ON f.FLAVOR = i.FLAVOR
WHERE f.TOTAL_ORDER >=3000 && i.ingredient_type="fruit_based"
order by f.total_order desc
