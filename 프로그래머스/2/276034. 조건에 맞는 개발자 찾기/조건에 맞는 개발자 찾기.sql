select distinct
    ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
from
    DEVELOPERS d
join
    SKILLCODES s
    on (d.SKILL_CODE & s.CODE)  != 0
where
     s.NAME IN ('Python', 'C#')
order by
    ID;