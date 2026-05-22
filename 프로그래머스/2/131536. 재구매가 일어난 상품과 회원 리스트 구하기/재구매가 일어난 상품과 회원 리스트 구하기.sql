select distinct
    USER_ID,
    PRODUCT_ID
from
    ONLINE_SALE o1
group by
    USER_ID,
    PRODUCT_ID
having
    count(*) >= 2
order by
    o1.USER_ID,
    o1.PRODUCT_ID desc
