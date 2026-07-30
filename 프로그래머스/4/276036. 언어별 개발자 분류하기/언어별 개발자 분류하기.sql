with cte_skills as(
    select
        sum(case
            when s.CATEGORY = 'Front End' then `CODE` else 0
        end) as `front`,
    
        max(case
            when s.NAME='C#' then `CODE` else 0
        end) as `csharp`,
    
        max(case
            when s.NAME = 'Python' then `CODE` else 0
        end) as `python`
    from
        SKILLCODES as s
)

select
    case
        when (d.SKILL_CODE & s.front and d.SKILL_CODE & s.python) > 0
            then 'A'
        when d.SKILL_CODE & s.csharp > 0
            then 'B'
        when d.SKILL_CODE & s.front > 0
            then 'C'
    end as `GRADE`,
    d.ID as `ID`,
    d.EMAIL as `EMAIL`
from 
    DEVELOPERS d
cross join
    cte_skills s
where
    d.SKILL_CODE & s.front > 0 or
    d.SKILL_CODE & s.csharp > 0
order by
    GRADE,
    ID
;