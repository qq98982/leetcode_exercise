# CREATE TABLE `leetcode`.`Address`  (
#   `AddressId` int(11) NOT NULL,
#   `PersonId` int(11) NULL DEFAULT NULL,
#   `City` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
#   `State` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
#   PRIMARY KEY (`AddressId`) USING BTREE
# ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
#
# CREATE TABLE `leetcode`.`Person`  (
#   `PersonId` int(11) NOT NULL,
#   `FirstName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
#   `LastName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
#   PRIMARY KEY (`PersonId`) USING BTREE
# ) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
#
# --
# Table: Person
#
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | PersonId    | int     |
# | FirstName   | varchar |
# | LastName    | varchar |
# +-------------+---------+
# PersonId is the primary key column for this table.
# Table: Address
#
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | AddressId   | int     |
# | PersonId    | int     |
# | City        | varchar |
# | State       | varchar |
# +-------------+---------+
#
#
#
# AddressId is the primary key column for this table.
#
#
# Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:
#
# FirstName, LastName, City, State
# --
# insert into Person (PersonId, LastName, FirstName) values ('1', 'Wang', 'Allen')
# insert into Person (PersonId, LastName, FirstName) values ('2', 'Lin', 'lee')

# insert into Address (AddressId, PersonId, City, State) values ('1', '2', 'New York City', 'New York')
# insert into Address (AddressId, PersonId, City, State) values ('2', '1', 'Mexico City', 'Mexico')


SELECT
p.FirstName, p.LastName, a.City, a.State
FROM Person p
LEFT JOIN Address a ON p.PersonId= a.PersonId;