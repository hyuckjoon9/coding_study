# 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들
select
    MONTH(START_DATE) as `MONTH`,
    CAR_ID,
    count(*) as `RECORDS`
from
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
where
    CAR_ID in (
        select    
            CAR_ID  
        from
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where
            START_DATE between '2022-08-01' and '2022-10-31'
        group by
            CAR_ID
        having
            count(*) >= 5
    )
    and START_DATE between '2022-08-01' and '2022-10-31'
group by
    MONTH(START_DATE),
    CAR_ID
having
    count(*) > 0
order by
    MONTH,
    CAR_ID desc
    
    
