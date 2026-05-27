select
    count(*)
from
    (select
        distinct name
     from
        ANIMAL_INS
     where
        NAME is not null
            
    ) t

;