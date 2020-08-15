# X city built a new stadium, each day many people visit it and the stats are saved as these columns: id, visit_date, people
#
# Please write a query to display the records which have 3 or more consecutive rows and the amount of people more than 100(inclusive).
#
# For example, the table stadium:
# +------+------------+-----------+
# | id   | visit_date | people    |
# +------+------------+-----------+
# | 1    | 2017-01-01 | 10        |
# | 2    | 2017-01-02 | 109       |
# | 3    | 2017-01-03 | 150       |
# | 4    | 2017-01-04 | 99        |
# | 5    | 2017-01-05 | 145       |
# | 6    | 2017-01-06 | 1455      |
# | 7    | 2017-01-07 | 199       |
# | 8    | 2017-01-08 | 188       |
# +------+------------+-----------+
# For the sample data above, the output is:
#
# +------+------------+-----------+
# | id   | visit_date | people    |
# +------+------------+-----------+
# | 5    | 2017-01-05 | 145       |
# | 6    | 2017-01-06 | 1455      |
# | 7    | 2017-01-07 | 199       |
# | 8    | 2017-01-08 | 188       |
# +------+------------+-----------+
# Note:
# Each day only have one row record, and the dates are increasing with id increasing.
SELECT DISTINCT
                tb1.id,
                tb1.visit_date,
                tb1.people
FROM
     stadium AS tb1,
     stadium AS tb2,
     stadium AS tb3
WHERE
        tb1.people >= 100
    AND tb2.people >= 100
    AND tb3.people >= 100
    AND (
    ( tb1.id + 1 = tb2.id AND tb1.id + 2 = tb3.id )
      OR ( tb1.id - 1 = tb2.id AND tb1.id + 1 = tb3.id )
      OR ( tb1.id - 1 = tb2.id AND tb1.id - 2 = tb3.id )
    )
ORDER BY
         tb1.id;