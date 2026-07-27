with recursive hours as(
    select 0 as hour
    union all
    select hour + 1
    from hours
    where hour < 23
),
hour_counts as(
    select
        HOUR(DATETIME) as 'HOUR',
        count(*) as 'COUNT'
    from
        ANIMAL_OUTS
    group by
        HOUR(DATETIME)
)
select
    h.hour as 'HOUR',
    coalesce(hc.COUNT, 0) as 'COUNT'
from
    hours h
left join
    hour_counts as hc
    on h.hour = hc.HOUR
order by
    h.hour;