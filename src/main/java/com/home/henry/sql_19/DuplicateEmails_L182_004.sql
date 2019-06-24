# Write a SQL query to find all duplicate emails in a table named Person.
#
# +----+---------+
# | Id | Email   |
# +----+---------+
# | 1  | a@b.com |
# | 2  | c@d.com |
# | 3  | a@b.com |
# +----+---------+
# For example, your query should return the following for the above table:
#
# +---------+
# | Email   |
# +---------+
# | a@b.com |
# +---------+

SELECT DISTINCT(tb1.Email)
FROM Person as tb1
INNER JOIN Person as tb2
WHERE tb1.Email=tb2.Email and tb1.Id!=tb2.Id;

-- Faster
SELECT Email
FROM Person
GROUP BY Email
HAVING count(*) > 1;
