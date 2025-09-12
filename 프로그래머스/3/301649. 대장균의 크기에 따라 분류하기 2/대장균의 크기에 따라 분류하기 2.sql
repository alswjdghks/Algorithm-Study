-- 코드를 작성해주세요
SELECT
    ID,
    CASE 등급
        WHEN 1 THEN 'CRITICAL'
        WHEN 2 THEN 'HIGH'
        WHEN 3 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM
    ( SELECT ID,
             SIZE_OF_COLONY,
             NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) 등급
      FROM ECOLI_DATA ) AS SUB  
ORDER BY
    ID ASC;