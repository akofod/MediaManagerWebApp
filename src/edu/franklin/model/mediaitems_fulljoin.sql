select 
        `pi`.`PurchaseLocation` AS `purchaselocation`,
        `pii`.`ID` AS `purchaseinfomediaitemid`,
        `pii`.`PurchasePrice` AS `PurchasePrice`,
        `pii`.`PurchaseDate` AS `PurchaseDate`,
        `pii`.`PurchaseInfoID` AS `PurchaseInfoID`,
        `pii`.`MediaItemID` AS `PiiMediaItemId`,
        `g`.`GenreDescription` AS `GenreDescription`,
        `mt`.`MediaTypeDescription` AS `MediaTypeDescription`,
        `mi`.`ID` AS `ID`,
        `mi`.`GenreID` AS `GenreID`,
        `mi`.`MediaTypeID` AS `MediaTypeID`,
        `mi`.`Name` AS `Name`,
        `mi`.`Year` AS `Year`,
        `mi`.`Comments` AS `Comments`,
        `mi`.`CurrentValue` AS `CurrentValue`
    from
        ((((`mediamanager`.`mediaitem` `mi`
        join `mediamanager`.`genre` `g` ON ((`mi`.`GenreID` = `g`.`ID`)))
        join `mediamanager`.`mediatype` `mt` ON ((`mi`.`MediaTypeID` = `mt`.`ID`)))
        left join `mediamanager`.`purchaseinfomediaitem` `pii` ON ((`pii`.`MediaItemID` = `mi`.`ID`)))
        left join `mediamanager`.`purchaseinfo` `pi` ON ((`pi`.`ID` = `pii`.`PurchaseInfoID`)))