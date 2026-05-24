select
   child.ITEM_ID,
   child.ITEM_NAME,
   child.RARITY
from
    ITEM_INFO parent
join
    ITEM_TREE tree
    on parent.ITEM_ID = tree.PARENT_ITEM_ID
join
    ITEM_INFO child
    on tree.ITEM_ID = child.ITEM_id
where   
    parent.RARITY = 'RARE'    
order by
    child.ITEM_ID desc