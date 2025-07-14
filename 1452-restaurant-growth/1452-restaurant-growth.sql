# Write your MySQL query statement below
WITH DailyAmount AS (
  SELECT visited_on, SUM(amount) AS amount
  FROM Customer
  GROUP BY visited_on
),
SevenDayWindow AS (
  SELECT
    d1.visited_on,
    SUM(d2.amount) AS amount,
    ROUND(AVG(d2.amount), 2) AS average_amount
  FROM DailyAmount d1
  JOIN DailyAmount d2 
    ON d2.visited_on BETWEEN DATE_SUB(d1.visited_on, INTERVAL 6 DAY) AND d1.visited_on
  GROUP BY d1.visited_on
)
SELECT *
FROM SevenDayWindow
WHERE visited_on >= (
  SELECT MIN(visited_on) + INTERVAL 6 DAY FROM DailyAmount
)
ORDER BY visited_on;
