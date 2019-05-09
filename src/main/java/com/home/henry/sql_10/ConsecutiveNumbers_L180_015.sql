# Write a SQL query to find all numbers that appear at least three times consecutively.
#
# +----+-----+
# | Id | Num |
# +----+-----+
# | 1  |  1  |
# | 2  |  1  |
# | 3  |  1  |
# | 4  |  2  |
# | 5  |  1  |
# | 6  |  2  |
# | 7  |  2  |
# +----+-----+
# For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.
#
# +-----------------+
# | ConsecutiveNums |
# +-----------------+
# | 1               |
# +-----------------+

SELECT DISTINCT(tb1.Num) AS ConsecutiveNums
FROM Logs AS tb1, Logs AS tb2, Logs AS tb3
WHERE
tb1.Id + 1 = tb2.Id AND tb2.Id + 1 = tb3.Id
AND tb1.Num = tb2.Num AND tb2.Num = tb3.Num;
