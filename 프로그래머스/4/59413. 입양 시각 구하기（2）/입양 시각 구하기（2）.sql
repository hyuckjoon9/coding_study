with recursive hours as(
    select 0 as `HOUR`
    
    union all
    
    select HOUR+1
    from hours
    where HOUR < 23
)

select
    h.HOUR as `HOUR`,
    coalesce(count(ao.DATETIME), 0) as `COUNT`
from
    hours as h
left join
    ANIMAL_OUTS as ao
    on h.HOUR = HOUR(ao.DATETIME)
group by
    h.HOUR
order by
    h.HOUR
;
