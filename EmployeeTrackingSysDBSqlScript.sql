CREATE TABLE `employee` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `etype` varchar(45) DEFAULT NULL,
  `logindate` date DEFAULT NULL,
  `shifttime` time DEFAULT NULL,
  `shiftstatus` varchar(45) DEFAULT NULL,
  `deptname` varchar(45) DEFAULT NULL,
  `projectname` varchar(45) DEFAULT NULL,
  `reportingempcount` int DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;