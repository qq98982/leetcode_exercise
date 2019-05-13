# Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
#
# +---------+------------------+------------------+
# | Id(INT) | RecordDate(DATE) | Temperature(INT) |
# +---------+------------------+------------------+
# |       1 |       2015-01-01 |               10 |
# |       2 |       2015-01-02 |               25 |
# |       3 |       2015-01-03 |               20 |
# |       4 |       2015-01-04 |               30 |
# +---------+------------------+------------------+
# For example, return the following Ids for the above Weather table:
#
# +----+
# | Id |
# +----+
# |  2 |
# |  4 |
# +----+

SELECT tb1.Id
FROM Weather AS tb1
       INNER JOIN Weather AS tb2
         ON tb1.Temperature > tb2.Temperature AND DATEDIFF(tb1.RecordDate, tb2.RecordDate) = 1
WHERE tb1.RecordDate > tb2.RecordDate;