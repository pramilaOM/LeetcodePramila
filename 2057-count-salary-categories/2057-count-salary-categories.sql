-- Step 1: Create category list
WITH categories AS (
    SELECT 'Low Salary' AS category
    UNION ALL
    SELECT 'Average Salary'
    UNION ALL
    SELECT 'High Salary'
),
-- Step 2: Categorize each account
categorized AS (
    SELECT 
        CASE 
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
            ELSE 'High Salary'
        END AS category
    FROM Accounts
)
-- Step 3: Join and count
SELECT 
    c.category, 
    COUNT(cat.category) AS accounts_count
FROM categories c
LEFT JOIN categorized cat ON c.category = cat.category
GROUP BY c.category;
