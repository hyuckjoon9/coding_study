select
    ub.WRITER_ID as `USER_ID`,
    uu.NICKNAME as `NICKNAME`,
    sum(ub.PRICE) as `TOTAL_SALES`
from
    USED_GOODS_BOARD ub
join
    USED_GOODS_USER uu
    on ub.WRITER_ID = uu.USER_ID
where
    ub.STATUS = "DONE"
group by
    ub.WRITER_ID,
    uu.NICKNAME
having
    sum(ub.PRICE) >= 700000
order by
    TOTAL_SALES