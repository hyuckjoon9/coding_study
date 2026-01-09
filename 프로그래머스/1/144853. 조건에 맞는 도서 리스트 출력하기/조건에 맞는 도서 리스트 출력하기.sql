SELECT book_id, DATE_FORMAT(published_date, '%Y-%m-%d') AS published_date
FROM BOOK
WHERE YEAR(published_date)=2021 
    AND category="인문"
ORDER BY YEAR(published_date) ASC