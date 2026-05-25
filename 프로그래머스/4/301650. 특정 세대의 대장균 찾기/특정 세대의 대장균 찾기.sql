select
    thirdG.ID
from
    ECOLI_DATA firstG
join
    ECOLI_DATA secondG
    on firstG.ID = secondG.PARENT_ID
join
    ECOLI_DATA thirdG
    on secondG.ID = thirdG.PARENT_ID
where
    firstG.PARENT_ID is NULL
order by
    thirdG.ID
;
    
