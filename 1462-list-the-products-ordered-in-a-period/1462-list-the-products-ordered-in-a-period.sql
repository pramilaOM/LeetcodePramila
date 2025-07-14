/* Write your T-SQL query statement below */

Select p.product_name,SUM(o.unit) AS unit from Products p join Orders o on
p.product_id = o.product_id where o.order_date >= '2020-02-01' AND o.order_date < '2020-03-01' GROUP BY p.product_id,p.product_name having SUM(o.unit) >= 100;