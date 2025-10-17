SELECT
    ITEM_ID,
    ITEM_NAME,
    RARITY
FROM
    ITEM_INFO
WHERE
    ITEM_ID IN (SELECT
                    t.ITEM_ID
                FROM
                    ITEM_INFO i
                JOIN
                    ITEM_TREE t ON i.ITEM_ID = t.PARENT_ITEM_ID 
                WHERE
                    i.RARITY = 'RARE')
ORDER BY
    ITEM_ID DESC;

    