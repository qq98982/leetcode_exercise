# CREATE TABLE `leetcode`.`Employee`  (
#   `Id` int(11) NOT NULL,
#   `Salary` decimal(10, 2) NULL DEFAULT NULL,
#   PRIMARY KEY (`Id`) USING BTREE
# ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
#
# Write a SQL query to get the second highest salary from the Employee table.
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.
#
# +---------------------+
# | SecondHighestSalary |
# +---------------------+
# | 200                 |
# +---------------------+

SELECT MAX(Salary) AS SecondHighestSalary FROM Employee WHERE Salary <(SELECT MAX(Salary) FROM Employee);