select
    f.CATEGORY,
    f.PRICE,
    f.PRODUCT_NAME
from
    FOOD_PRODUCT f
join
    (
        select
            CATEGORY,
            max(PRICE) as 'MAX_PRICE'
        from
            FOOD_PRODUCT
        group by
            CATEGORY
    ) t
    on f.CATEGORY=t.CATEGORY
    and f.PRICE=t.MAX_PRICE
where
    f.CATEGORY in ('과자', '국', '김치', '식용유')
order by
    f.PRICE desc
;