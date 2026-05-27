select
    fi.ID as 'ID',
    fn.FISH_NAME as 'FISH_NAME',
    fi.LENGTH as 'LENGTH'
from
    FISH_INFO fi
join
    FISH_NAME_INFO fn
    on fi.FISH_TYPE = fn.FISH_TYPE
where
   ( fi.FISH_TYPE, fi.LENGTH) in (
    select
        FISH_TYPE,
        max(LENGTH)
     from
        FISH_INFO
     group by
        FISH_TYPE
    )
order by
    fi.ID;