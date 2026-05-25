select
    parent.ID,
    count(child.PARENT_ID) as CHILD_COUNT
from
    ECOLI_DATA parent
left join
    ECOLI_DATA child
    on parent.ID = child.PARENT_ID
group by
    parent.ID
order by
    parent.ID
;