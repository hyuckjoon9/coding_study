select
    YEAR(s.SALES_DATE) as `YEAR`,
    MONTH(s.SALES_DATE) as `MONTH`,
    i.GENDER,
    count(distinct i.USER_ID) as `USERS`
from
    USER_INFO i
join
    ONLINE_SALE s
    on i.USER_ID = s.USER_ID
where
    i.GENDER is not null
group by
    YEAR(s.SALES_DATE),
    MONTH(s.SALES_DATE),
    i.GENDER
order by
    YEAR(s.SALES_DATE),
    MONTH(s.SALES_DATE),
    i.GENDER
    