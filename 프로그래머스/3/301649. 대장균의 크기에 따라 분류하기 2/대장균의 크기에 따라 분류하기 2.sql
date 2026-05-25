select
    ID,
    case
        when q = 1 then 'CRITICAL'
        when q = 2 then 'HIGH'
        when q = 3 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from
    (select
        ID,
        ntile(4) over (order by SIZE_OF_COLONY desc ) as q
     from
        ECOLI_DATA 
    ) t
order by
    ID;