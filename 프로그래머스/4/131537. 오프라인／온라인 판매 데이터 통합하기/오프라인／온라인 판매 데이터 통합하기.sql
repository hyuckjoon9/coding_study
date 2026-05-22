select
    SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
from
    ONLINE_SALE
where
    SALES_DATE between '2022-03-01' and '2022-03-31'
    
union all

select
    SALES_DATE,
    PRODUCT_ID,
    NULL as USER_ID,
    SALES_AMOUNT
from
    OFFLINE_SALE
where
    SALES_DATE between '2022-03-01' and '2022-03-31'
    
order by
    SALES_DATE,
    PRODUCT_ID,
    USER_ID;