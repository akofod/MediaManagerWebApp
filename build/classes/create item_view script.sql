CREATE OR REPLACE VIEW mediamanager.item_view AS
SELECT mediamanager.mediaitem.Name, 
mediamanager.genre.GenreDescription, 
mediamanager.mediatype.MediaTypeDescription,
mediamanager.mediaitem.Year, 
mediamanager.mediaitem.Comments, 
mediamanager.mediaitem.CurrentValue,
mediamanager.purchaseinfo.PurchaseLocation,
mediamanager.purchaseinfomediaitem.PurchaseDate,
mediamanager.purchaseinfomediaitem.PurchasePrice
FROM mediamanager.mediaitem
INNER JOIN mediamanager.genre ON mediamanager.mediaitem.GenreID=mediamanager.genre.ID
INNER JOIN mediamanager.mediatype ON mediamanager.mediaitem.MediaTypeID=mediamanager.mediatype.ID
INNER JOIN mediamanager.purchaseinfomediaitem ON mediamanager.purchaseinfomediaitem.MediaItemID=mediamanager.mediaitem.ID
INNER JOIN mediamanager.purchaseinfo ON mediamanager.purchaseinfomediaitem.PurchaseInfoID=mediamanager.purchaseinfo.ID;