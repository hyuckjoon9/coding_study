select
    b.AUTHOR_ID,
    a.AUTHOR_NAME,
    b.CATEGORY,
    sum(b.PRICE * s.SALES) as 'TOTAL_SALES'
from
    BOOK b
join
    AUTHOR a
    on a.AUTHOR_ID = b.AUTHOR_ID
join
    BOOK_SALES s
    on s.BOOK_ID = b.BOOK_ID
where
    s.SALES_DATE between '2022-01-01' and '2022-01-31'
group by
    a.AUTHOR_ID,
    b.CATEGORY
order by
    a.AUTHOR_ID,
    b.CATEGORY desc;