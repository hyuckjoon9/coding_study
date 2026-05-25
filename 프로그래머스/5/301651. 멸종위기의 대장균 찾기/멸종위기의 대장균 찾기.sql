with recursive GEN_TABLE as(
    select
        ID,
        PARENT_ID,
        1 as GENERATION
    from
        ECOLI_DATA
    where
        PARENT_ID is null
    
    union all
    
    select
        child.ID,
        child.PARENT_ID,
        parent.GENERATION + 1
    from
        ECOLI_DATA child
    join 
        GEN_TABLE parent
        on child.PARENT_ID = parent.ID
)

select
    count(*) as COUNT,
    a.GENERATION
from
    GEN_TABLE a
left join
    GEN_TABLE b
    on a.ID = b.PARENT_ID
where
    b.ID is null
group by
    a.GENERATION
order by
    a.GENERATION