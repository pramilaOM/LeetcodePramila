# Write your MySQL query statement below
WITH RankedQueue AS (
  SELECT *,
         SUM(weight) OVER (ORDER BY turn) AS running_weight
  FROM Queue
)
SELECT person_name
FROM RankedQueue
WHERE running_weight <= 1000
ORDER BY turn DESC
LIMIT 1;
