select    
    count(*)   
from
    USER_INFO 
where
    JOINED between '2021-01-01' AND '2021-12-31'
    AND AGE between 20 AND 29;