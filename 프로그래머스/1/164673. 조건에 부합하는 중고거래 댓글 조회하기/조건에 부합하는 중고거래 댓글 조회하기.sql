select
    b.TITLE,
    b.BOARD_ID,
    r.REPLY_ID,
    r.WRITER_ID,
    r.CONTENTS,
    r.CREATED_DATE
from
    USED_GOODS_BOARD b
join
    USED_GOODS_REPLY r
    on b.BOARD_ID = r.BOARD_ID
where
    b.CREATED_DATE between '2022-10-01'
    AND '2022-10-31'
order by
    r.CREATED_DATE,
    b.TITLE;