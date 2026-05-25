select
    child.ID,
    child.GENOTYPE,
    parent.GENOTYPE as 'PARENT_GENOTYPE'
from
    ECOLI_DATA parent
left join
    ECOLI_DATA child
    on parent.ID = child.PARENT_ID
where
    (parent.GENOTYPE | child.GENOTYPE) = child.GENOTYPE
order by
    child.ID
;