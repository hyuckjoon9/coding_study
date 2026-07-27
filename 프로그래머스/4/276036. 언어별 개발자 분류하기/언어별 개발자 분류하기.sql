with skill_codes as(
    select
        sum(case when CATEGORY='Front End' then `CODE` else 0 end) as frontend_code,
        max(case when NAME = 'Python' then `CODE` end) as python_code,
        max(case when NAME = 'C#' then `CODE` end) as csharp_code 
    from SKILLCODES
)

select
    case when (sc.frontend_code & d.SKILL_CODE) > 0
            and (sc.python_code & d.SKILL_CODE) > 0
                then 'A'
        when (sc.csharp_code & d.SKILL_CODE) > 0
                then 'B'
        when
            (sc.frontend_code & d.SKILL_CODE) > 0
                then 'C'
    end as `GRADE`,
    
    d.ID as `ID`,
    d.EMAIL as `EMAIL`
from 
    DEVELOPERS d
cross join
    skill_codes sc
WHERE
       (sc.frontend_code & d.SKILL_CODE) > 0
    OR (sc.csharp_code & d.SKILL_CODE) > 0
order by
    `GRADE`,
    `ID`
;
