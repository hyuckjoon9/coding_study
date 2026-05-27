select
    year(DIFFERENTIATION_DATE) as 'YEAR',
    b.MAX_SIZE - a.SIZE_OF_COLONY as 'YEAR_DEV',
    ID as 'ID'
from
    ECOLI_DATA a
join
    (select
        year(DIFFERENTIATION_DATE) as 'YEAR',
        max(SIZE_OF_COLONY) as 'MAX_SIZE'
    from
        ECOLI_DATA
    group by
        year(DIFFERENTIATION_DATE)
    ) b
    on year(a.DIFFERENTIATION_DATE) = YEAR
order by
    year(a.DIFFERENTIATION_DATE),
    YEAR_DEV
;